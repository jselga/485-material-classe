package Principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String FILE_PATH = "db.properties";
    private static final Properties PROPERTIES = loadProperties();

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String url = PROPERTIES.getProperty("db.url");
        String user = PROPERTIES.getProperty("db.user");
        String password = PROPERTIES.getProperty("db.password");

        if (url == null || url.isBlank()) {
            throw new IllegalStateException("La propietat db.url no esta configurada.");
        }
        if (user == null || user.isBlank()) {
            throw new IllegalStateException("La propietat db.user no esta configurada.");
        }

        return DriverManager.getConnection(url, user, password);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(FILE_PATH)) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("No s'ha pogut llegir " + FILE_PATH + ".", e);
        }
    }
}
