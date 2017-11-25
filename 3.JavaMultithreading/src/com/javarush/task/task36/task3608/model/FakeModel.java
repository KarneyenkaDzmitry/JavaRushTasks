package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Дмитрий on 26.10.2017.
 */
public class FakeModel implements Model {
    private ModelData modelData=new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<User>();
        Collections.addAll(users,new User("A",1,1), new User("B", 1,1));
        modelData.setUsers(users);
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
