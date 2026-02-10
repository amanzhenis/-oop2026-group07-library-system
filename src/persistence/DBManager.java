package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    private static DBManager instance;
    private Connection connection;

    private DBManager() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require",
                    "postgres.nvenexrgrxyxtrpoaqpu",
                    "zhekaamanbr0thers"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
