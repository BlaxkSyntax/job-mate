package za.co.wethinkcode.servicetests;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import za.co.wethinkcode.database.service.Connector;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectorTest {
    
    private final static String url = "jdbc:sqlite:test.db";
    private static Connection connection;
    static Connector connector = new Connector(connection, url);


    @BeforeAll
    public static void startCOnnection() throws SQLException {
        connector.setConnection();
    }

    @AfterAll
    public static void stopConnection() throws SQLException {
        connector.closeConnection();
    }
    
    @Test
    @DisplayName("database connection: connetion")
    void testConnection() throws SQLException {
        assertThat(connector.getConnection().isValid(1));
    }

    @Test
    @DisplayName("database connection: connetion")
    void testGetUrl() throws SQLException {
        assertThat(connector.getUrl().equals("test.db"));
    }

    @Test
    @DisplayName("database connection: connetion")
    void testSetUrl() throws SQLException {
        connector.setUrl("testurl");
        assertThat(connector.getUrl().equals("testurl"));
    }
}
