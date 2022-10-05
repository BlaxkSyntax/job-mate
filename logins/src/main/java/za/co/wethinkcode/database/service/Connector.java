package za.co.wethinkcode.database.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private Connection connection;
    private String url;

    public Connector(Connection connection, String url) {
        this.connection = connection;
        this.setUrl(url);
    }
    
    public void setConnection() throws SQLException {
        File dbFile = new File("test.db");
        if (dbFile.exists()){
            System.out.println("connection to database");
            this.connection = DriverManager.getConnection(url);
            System.out.println("connected");
        }else{
            throw new IllegalArgumentException( "Database file " + dbFile.getName() + " not found." );
        }
    }

    public String getUrl() {
        return url;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void closeConnection(){
        try {
            if(this.connection.isValid(1)){
                this.connection.close();
            }else{
                System.out.println("Cant close databse");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
