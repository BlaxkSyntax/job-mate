package za.co.wethinkcode.database.model;

import net.lemnik.eodsql.ResultColumn;

/**
*/
public class Register {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String verify;
    private String otp;
    private String date;

    public String getName() {
        return name;
    }
    
    public String getDate() {
        return date;
    }

    @ResultColumn( value = "date" )
    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    @ResultColumn( value = "id" )
    public void setId(String id) {
        this.id = id;
    }

    public String getOtp() {
        return otp;
    }

    @ResultColumn( value = "opt" )
    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getVerify() {
        return verify;
    }

    @ResultColumn( value = "verify" )
    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getPassword() {
        return password;
    }

    @ResultColumn( value = "password" )
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @ResultColumn( value = "email" )
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    @ResultColumn( value = "surname" )
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ResultColumn( value = "name" )
    public void setName(String name) {
        this.name = name;
    }   

    public String toString(){
        return "{"
                    +"\"id\":"+"\""+getId()+"\","
                    +"\"name\":"+"\""+getName()+"\","
                    +"\"surname\":"+"\""+getSurname()+"\","
                    +"\"email\":"+"\""+getEmail()+"\","
                    +"\"password\":"+"\""+getPassword()+"\","
                    +"\"verify\":"+"\""+getVerify()+"\","
                    +"\"otp\":"+"\""+getOtp()+"\","
                    +"\"date\":"+"\""+getDate()+"\""+
                "}";
    }
}
