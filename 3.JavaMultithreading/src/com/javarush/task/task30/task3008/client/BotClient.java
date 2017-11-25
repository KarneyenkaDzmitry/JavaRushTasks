package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Дмитрий on 14.11.2017.
 */
public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_"+(int)(Math.random()*100);
    }

    public static void main(String[] args) {
        BotClient  botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message!=null&&message.contains(":")){
                String[] string = message.split(": ");
                if (string.length==2){


                String line ="Информация для "+string[0]+": ";
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format=null;
                switch (string[1]){
                    case "дата":format = new SimpleDateFormat("d.MM.YYYY");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "день":format = new SimpleDateFormat("d");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "месяц":format = new SimpleDateFormat("MMMM");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "год":format = new SimpleDateFormat("YYYY");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "время":format = new SimpleDateFormat("H:mm:ss");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "час":format = new SimpleDateFormat("H");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "минуты":format = new SimpleDateFormat("m");sendTextMessage(line+format.format(calendar.getTime()));break;
                    case "секунды":format = new SimpleDateFormat("s");sendTextMessage(line+format.format(calendar.getTime()));break;
                    //default: format = new SimpleDateFormat("d.MM.YYYY.H:mm:ss");break;
                }

            }
            }
        }
    }
}
