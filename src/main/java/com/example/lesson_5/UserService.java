package com.example.lesson_5;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    public static UUID nextUUID(){
        return UUID.randomUUID();
    }

    private static boolean checkUUID(UUID checkUUID, String id){
        UUID findUUID = UUID.fromString(id);
        return checkUUID.equals(findUUID);
    }

    public static ResponseUserDTO findUserById(String id, List<ResponseUserDTO> users) {
        for (ResponseUserDTO user : users) {
            if (checkUUID(user.getId(),id)) {
                return user;
            }
        }
        return null;
    }

    public static ResponseUserDTO updateUser(String id, List<ResponseUserDTO> users,ResponseUserDTO updateUser ) {
        for (int i =0; i< users.size();i++) {
            if (checkUUID(users.get(i).getId(),id)) {
                users.set(i,updateUser);
                return users.get(i);
            }
        }
        return null;
    }
    public static boolean deleteUser(String id, List<ResponseUserDTO> users ) {
        for (int i =0; i< users.size(); i++) {
            if (checkUUID(users.get(i).getId(),id)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}