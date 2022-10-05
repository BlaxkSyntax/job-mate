package za.co.wethinkcode.database.model;

public class AuthenticUser {

    private String username;
    private String id;
    //private String cookie;

    
    
    
    //public String getAuthkey() {
        //return authkey;
    //}


    //public void setAuthkey(String authkey) {
        //this.authkey = authkey;
    //}src


    //public String getCookie() {
        //return cookie;
    //}


    //public void setCookie(String cookie) {
        //this.cookie = cookie;
        //}


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString(){
        return "{\"id\" :" +"\""+ getId()+"\""+","+"\"username\" :" +"\""+getUsername()+"\""+"}";
    }
}
