package com.twu28.biblioteca;

import java.util.HashMap;

public class UserList {

    private HashMap<String, String> userList;

    public UserList() {
        userList = new HashMap<String, String>();
    }

    public void populateList() {
        userList.put("111-1111", "abc");
        userList.put("111-0001", "def");
        userList.put("111-0003", "ghi");
        userList.put("111-0004", "jkl");
        userList.put("111-0005", "mno");
        userList.put("111-0006", "pqr");
        userList.put("111-0007", "stu");
        userList.put("111-0008", "vwx");
        userList.put("111-0009", "yza");
        userList.put("111-0010", "bcd");
        userList.put("111-0011", "efg");
        userList.put("111-0012", "hij");
        userList.put("111-0013", "klm");
        userList.put("111-0014", "nop");
        userList.put("111-0015", "qrs");
    }

    public Integer size() {
        return userList.size();
    }


    public boolean checkUserName(String username, String password) {
        if (!userList.containsKey(username)) return false;
        if (password.equals(userList.get(username))) return true;
        return false;
    }
}
