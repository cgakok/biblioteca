package com.twu28.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserListTest {
    @Test
    public void checkThatUserListgetsPopulated() {
        //Given
        UserList userList = new UserList();
        //When
        userList.populateList();
        //Then
        assertThat(userList.size(), is(15));
    }

    @Test
    public void checkThatUsernameAndPasswordAreCorrect() {
        //Given
        UserList userList = new UserList();
        userList.populateList();
        String username = "111-0001";
        String password = "def";
        //When
        boolean check = userList.checkUserName(username, password);
        //Then
        assertThat(check, is(true));
    }

    @Test
    public void checkThatIncorrectPasswordReturnsFalse() {
        //Given
        UserList userList = new UserList();
        userList.populateList();
        String username = "111-0001";
        String password = "notthetruepassword";
        //When
        boolean check = userList.checkUserName(username, password);
        //Then
        assertThat(check, is(false));
    }

}
