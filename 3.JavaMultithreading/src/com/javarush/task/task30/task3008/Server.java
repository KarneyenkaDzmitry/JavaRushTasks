package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Дмитрий on 07.11.2017.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Connection is lost.");;
            }
        }
    }
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            String nickname=null;
            System.out.println("установлено соединение с удаленным адресом"+socket.getRemoteSocketAddress());
            try (Connection connection  = new Connection(socket);){

                //System.out.println("установлено соединение с удаленным адресом"+socket.getRemoteSocketAddress());

                nickname= serverHandshake(connection);
                if (nickname!=null){
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, nickname));
                sendListOfUsers(connection, nickname);
                serverMainLoop(connection, nickname);}

            } catch (IOException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом.");
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом.");
            } finally{
                try {
                    if (nickname!=null){
                    connectionMap.remove(nickname);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, nickname));
                    }
                    System.out.println("Connection closed");

                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if(message.getType()==MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName+": "+message.getData()));

                }else{
                    System.out.println("Exception.");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
                if (!userName.equals(pair.getKey()))
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = new Message(MessageType.NAME_REQUEST);
            Message messageResponce = null;
            String nickname = null;
            while (true) {
                connection.send(message);
                messageResponce = connection.receive();
                if (messageResponce.getType().equals(MessageType.USER_NAME)) {
                    nickname = messageResponce.getData();
                    if (!nickname.isEmpty()) {
                        if (!connectionMap.containsKey(nickname)) {
                            connectionMap.put(nickname, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return nickname;
                        }
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
    ConsoleHelper consoleHelper = new ConsoleHelper();
    int portServer = consoleHelper.readInt();
        ServerSocket serverSocket=null;
        Socket socket;
        try {
            serverSocket = new ServerSocket(portServer);
            System.out.println("Server is running");
            while(true){
                socket=serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            try {
                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
