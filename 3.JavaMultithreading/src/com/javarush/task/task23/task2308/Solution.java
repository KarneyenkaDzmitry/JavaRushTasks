package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {
    public static final class Constants{
        public static final String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
        public static final String USER_IS_NOT_AUTHORIZED= "User is not authorized.";
        public static final String USER_IS_BANNED = "User is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";



    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(new Constants().SERVER_IS_NOT_ACCESSIBLE_FOR_NOW);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(new Constants().SERVER_IS_NOT_ACCESSIBLE_FOR_NOW, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(new Constants().USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(new Constants().USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(new Constants().USER_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(new Constants().USER_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(new Constants().ACCESS_IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(new Constants().ACCESS_IS_DENIED, cause);
        }
    }

    public static void main(String[] args) {

    }
}
