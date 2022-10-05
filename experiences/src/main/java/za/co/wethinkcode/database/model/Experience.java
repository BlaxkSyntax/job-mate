package za.co.wethinkcode.database.model;

/**
*/
public class Experience {

    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Experience(String Email,String Password){
        setEmail(Email);
        setPassword(Password);
    }

    @Override
    public String toString(){
        return "{\"email\" :" +"\""+ getEmail()+"\""+","+"\"password\" :" +"\""+getPassword()+"\""+"}";
    }
    
}
