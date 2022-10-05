package za.co.wethinkcode.app.model;


public class Post {
    private int id;
    private String post;
    
    public int getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String toString(){
        return "{"
                    +"\"id\":"+"\""+getId()+"\","
                    +"\"post\":"+"\""+getPost()+"\","
                    +"\"" +
                "}";
    }
}
