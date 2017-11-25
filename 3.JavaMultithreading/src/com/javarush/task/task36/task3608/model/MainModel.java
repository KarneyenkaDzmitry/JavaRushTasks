package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Дмитрий on 26.10.2017.
 */
public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private ModelData modelData=new ModelData();
    private List<User> users = getAllUsers();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    private List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        users=userService.getUsersBetweenLevels(1,100);
        users=userService.filterOnlyActiveUsers(users);
        return users;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        List<User> users = new ArrayList<User>();
        users=getAllUsers();
        modelData.setUsers(users);
    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(getAllUsers());
    }
}
