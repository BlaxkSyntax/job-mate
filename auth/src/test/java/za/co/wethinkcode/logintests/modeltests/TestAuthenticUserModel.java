package za.co.wethinkcode.logintests.modeltests;

import org.junit.jupiter.api.Test;

import za.co.wethinkcode.database.model.AuthenticUser;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAuthenticUserModel {
    
    String email = "Hope@hope.com";
    String id = "1";
    String authkey = "123";
    String authuser = "{\"id\" :" +"\""+ id+"\""+","+"\"username\" :" +"\""+email+"\""+"}";
    
    private AuthenticUser user = new AuthenticUser();
    @Test
    @DisplayName("auth : username")
    public void testUserName(){
        user.setUsername(email);
        assertThat(email.equals(user.getUsername()));
    }

    @Test
    @DisplayName("auth: id")
    public void testId(){
        user.setId(id);
        assertThat(id.equals(user.getId()));
    }

    @Test
    @DisplayName("Authkey : email")
    public void testAuthKey(){
        user.setAuthkey(authkey);
        assertThat(authkey.equals(user.getAuthkey()));
    }

    @Test
    @DisplayName("Authkey : email")
    public void testAuthUser(){
        user.setAuthkey(authkey);
        user.setUsername(email);
        user.setId(id);
        assertThat(authuser.equals(user.toString()));
    }
}
