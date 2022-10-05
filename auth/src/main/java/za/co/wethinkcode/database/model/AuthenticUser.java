package za.co.wethinkcode.database.model;

public class AuthenticUser {
    
    private String username;
    private String id;
    private String authkey;

    public String getId() {
        return id;
    }

    public void setId(String userID) {
        this.id = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthkey() {
        return authkey;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }

    @Override
    public String toString(){
        return "{\"id\" :" +"\""+ getId()+"\""+","+"\"username\" :" +"\""+getUsername()+"\""+"}";
    }
}
