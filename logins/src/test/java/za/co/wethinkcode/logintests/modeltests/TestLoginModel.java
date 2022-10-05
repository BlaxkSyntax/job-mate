package za.co.wethinkcode.logintests.modeltests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import za.co.wethinkcode.database.model.Login;

public class TestLoginModel {

    String email = "Hope@hope.com";
    String password = "123";
    String id = "id";
    String authkey = "key";
    String login = "{"+
        "\"email\" :" + "\""+email+"\""+","
        +"\"password\" :" + "\""+password+"\""+","+"\"id\" :" + "\""+id+"\""+","+"\"authkey\" :" +"\""+authkey+"\""
        +"}";
    
    private Login user = new Login();

    @Test
    @DisplayName("login : email")
    public void testEmail(){
        assertThat(email.equals(user.getEmail()));
    }

    @Test
    @DisplayName("login: password")
    public void testPassword(){
        assertThat(password.equals(user.getPassword()));
    }

    @Test
    @DisplayName("login: login")
    public void testLogin(){
        assertThat(login.equals(user.toString()));
    }

}
