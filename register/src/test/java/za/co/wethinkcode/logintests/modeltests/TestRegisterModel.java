package za.co.wethinkcode.logintests.modeltests;

import org.junit.jupiter.api.Test;

import za.co.wethinkcode.database.model.Register;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRegisterModel {

    String id = "1";
    String name = "email";
    String surname = "emaill";
    String email = "email@emaill";
    String password = "123";
    String verify = "123";
    String otp = "opt";
    String date = "date";

    String register = 
    "{"
        +"\"id\":"+"\""+ id +"\","
        +"\"name\":"+"\""+ name +"\","
        +"\"surname\":"+"\""+ surname +"\","
        +"\"email\":"+"\""+ email +"\","
        +"\"password\":"+"\""+ password +"\","
        +"\"verify\":"+"\""+ verify +"\","
        +"\"otp\":"+"\""+ otp +"\","
        +"\"date\":"+"\""+ date +"\""+
    "}";
    
    private Register reg = new Register();
    @Test
    @DisplayName("Register : id")
    public void testId(){
        reg.setId("1");
        assertThat(email.equals(reg.getId()));
    }

    @Test
    @DisplayName("Register : name")
    public void testName(){
        reg.setName("name");
        assertThat(name.equals(reg.getName()));
    }

    @Test
    @DisplayName("Register : surname")
    public void testSurname(){
        reg.setSurname("surname");
        assertThat(surname.equals(reg.getEmail()));
    }

    @Test
    @DisplayName("Register : email")
    public void testEmail(){
        reg.setEmail(email);
        assertThat(email.equals(reg.getEmail()));
    }

    @Test
    @DisplayName("Register: password")
    public void testPassword(){
        reg.setPassword(password);
        assertThat(password.equals(reg.getPassword()));
    }

    @Test
    @DisplayName("Register : Verify")
    public void testVerify(){
        reg.setVerify(email);
        assertThat(email.equals(reg.getEmail()));
    }

    @Test
    @DisplayName("Register: password")
    public void testOtp(){
        reg.setOtp(otp);
        assertThat(otp.equals(reg.getPassword()));
    }

    @Test
    @DisplayName("Register: date")
    public void testDate(){
        reg.setPassword(password);
        assertThat(password.equals(reg.getPassword()));
    }

    @Test
    @DisplayName("Register: register")
    public void testRegister(){
        assertThat(register.equals(reg.toString()));
    }
}
