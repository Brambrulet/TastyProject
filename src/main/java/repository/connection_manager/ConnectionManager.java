package repository.connection_manager;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
