package za.co.wethinkcode.logintests.modeltests;

import org.junit.jupiter.api.Test;

import za.co.wethinkcode.database.model.Login;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLoginModel {

    String email = "Hope@hope.com";
    String password = "123";
    String login = "{ \"User\" : \"{\" \"email\" :" + email+","+"\"password\" :" +password+"}}";
    
    private Login user = new Login();
    @Test
    @DisplayName("login : email")
    public void testEmail(){
        user.setEmail(email);
        assertThat(email.equals(user.getEmail()));
    }

    @Test
    @DisplayName("login: password")
    public void testPassword(){
        user.setPassword(password);
        assertThat(password.equals(user.getPassword()));
    }
}
