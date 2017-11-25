package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Message;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Дмитрий on 14.11.2017.
 */
public class ClientGuiModel extends Client {
    private final Set<String> allUserNames=new HashSet<String>();
    private String newMessage;

    public void addUser(String newUserName){
        allUserNames.add(newUserName);
    }

    public void deleteUser(String userName){
        allUserNames.remove(userName);
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public String getNewMessage() {
        return newMessage;
    }

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }
}
