package za.co.wethinkcode.app.model;


public class Signin {
    
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "{"
                    +"\"email\":"+"\""+getEmail()+"\","
                    +"\"password\":"+"\""+getPassword()+"\"" +
                "}";
    }
}
