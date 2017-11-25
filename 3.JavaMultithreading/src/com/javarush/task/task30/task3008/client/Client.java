package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Дмитрий on 11.11.2017.
 */
public class Client {

    protected Connection connection;
    private volatile boolean clientConnected=false;

    protected String getServerAddress(){
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
       return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        SocketThread  socketThread = new SocketThread();
        return socketThread;
    }


    protected void sendTextMessage(String text){

        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage( "Connection is fail");
            clientConnected=false;
           //e.printStackTrace();
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try { this.wait();
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Socket thread is interrupted!");
            }
        }

        if (clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");}
            else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
            while(clientConnected){
                String text =  ConsoleHelper.readString();
                if (text.equals("exit"))break;
                if (shouldSendTextFromConsole()){
                    sendTextMessage(text);
                   }
                }
            }


    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }


    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" is Added");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" is deleted");

        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected=clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true) {
                Message message = connection.receive();
                //if (message.getType() != null) {
                    if (message.getType()==(MessageType.NAME_REQUEST)) {
                        String name = getUserName();
                        Message messageName = new Message(MessageType.USER_NAME, name);
                        connection.send(messageName);
                    } else {
                        if (message.getType()==(MessageType.NAME_ACCEPTED)) {
                            notifyConnectionStatusChanged(true);
                            break;
                        } else {
                            throw new IOException("Unexpected MessageType");
                        }
                    }
                //}
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if (message.getType()==(MessageType.TEXT)){
                    processIncomingMessage(message.getData());
                }else{
                    if (message.getType()==(MessageType.USER_ADDED)){
                        informAboutAddingNewUser(message.getData());
                    }else{
                        if (message.getType()==(MessageType.USER_REMOVED)){
                            informAboutDeletingNewUser(message.getData());
                        }else{
                            throw new IOException("Unexpected MessageType");
                        }

                    }
                }

            }
        }

        @Override
        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            Socket socket = null;
            try {
                socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }

        }
    }


}
