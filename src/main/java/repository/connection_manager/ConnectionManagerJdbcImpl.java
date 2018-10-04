package repository.connection_manager;

import consts.Consts;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(ConnectionManagerJdbcImpl.class);
    private static ConnectionManager connectionManager;

    private ConnectionManagerJdbcImpl() {
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerJdbcImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");

            connection = DriverManager.getConnection(
                    "jdbc:firebirdsql://localhost:3050/tastyProject",
                    "SYSDBA",
                    "masterkey");
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.trace(Consts.CATCH_EXCEPTION, e);
        }
        return connection;
    }
}
