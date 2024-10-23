package utp.restaurant.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class RestaurantDB {
    
    private static RestaurantDB instance;
    private String url;
    private String user;
    private String password;
    private Connection conn;
    private Dotenv dotenv;
    
    private RestaurantDB() {
        
        dotenv = Dotenv.load();
        url = dotenv.get("DB_URL");
        user = dotenv.get("DB_USER");
        password = dotenv.get("DB_PASSWORD");
        
        startConnection();
        
    }
    
    private void startConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    //patron singleton
    public static RestaurantDB getInstance() {
        if (instance == null) {
            instance = new RestaurantDB();
        }
        
        return instance;
    }
    
}
