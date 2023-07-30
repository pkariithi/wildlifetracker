import org.sql2o.Sql2o;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class DB {
    public static Sql2o sql2o() {
        final Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get("application.properties")));
            return new Sql2o(properties.get("psql.url").toString(), properties.get("psql.username").toString(), properties.get("psql.password").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
