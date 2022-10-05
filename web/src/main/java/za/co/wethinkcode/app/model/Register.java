package za.co.wethinkcode.app.model;

public class Register {
    private String name;
    private String surname;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public String toString(){
        return "{"
                    +"\"name\":"+"\""+getName()+"\","
                    +"\"surname\":"+"\""+getSurname()+"\","
                    +"\"email\":"+"\""+getEmail()+"\","
                    +"\"password\":"+"\""+getPassword()+"\""+
                "}";
    }
}
