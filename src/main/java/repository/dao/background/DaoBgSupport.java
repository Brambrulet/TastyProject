package repository.dao.background;

import consts.Consts;
import org.apache.log4j.Logger;
import repository.connection_manager.ConnectionManager;
import repository.connection_manager.ConnectionManagerJdbcImpl;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public final class DaoBgSupport {
    private static final ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();
    private static final String SQL_ID = "id";
    private static final String SQL_NAME = "name";
    private static final String SQL_LOGIN = "login";
    private static final String SQL_MD5PASSW = "md5passw";
    private static final String SQL_NICK = "nick";
    private static final String SQL_VALUE = "value";
    private static final String SQL_KIND = "kind";
    private static final String SQL_IS_PRIMARY = "is_primary";
    private static final String SQL_BASE_K = "base_k";
    private static final String SQL_MAKER_ID = "maker_id";
    private static final String SQL_EDITOR_ID = "editor_id";
    private static final String SQL_MAKE_DATE = "make_date";
    private static final String SQL_EDIT_DATE = "edit_date";
    private static final String SQL_TEMPLATE_SELECT = "select %s from %s;";
    private static final String SQL_TEMPLATE_SELECT_WHERE = "select %s from %s where %s = ?;";
    private static final String SQL_TEMPLATE_DELETE = "delete from %s where id = ?;";
    private static final String SQL_TEMPLATE_INSERT = "insert into %s(%s, editor_id) values(?, ?, ?, ?) returning %s";
    private static final String SQL_TEMPLATE_UPDATE_2 = "update %s set %s=?, %s=?, editor_id=?) where id = ?";
    private static final String SQL_TEMPLATE_UPDATE_3 = "update %s set %s=?, %s=?, %s=?, editor_id=?) where id = ?";
    private static final String SQL_TEMPLATE_UPDATE_4 = "update %s set %s=?, %s=?, %s=?, %s=?, editor_id=?) where id = ?";
    private static final String SQL_TEMPLATE_3_FIELDS = "%s, %s, %s";
    private static final String SQL_TEMPLATE_4_FIELDS = "%s, %s, %s, %s";
    private static final String SQL_STD_TAIL_FIELDS = String.format(SQL_TEMPLATE_4_FIELDS, SQL_MAKER_ID, SQL_EDITOR_ID, SQL_MAKE_DATE, SQL_EDIT_DATE);
    private static final String SQL_MEASURE = "measure";
    public static final String SQL_MEASURE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_4, SQL_MEASURE, SQL_NAME, SQL_KIND, SQL_IS_PRIMARY, SQL_BASE_K);
    public static final String SQL_MEASURE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_MEASURE);
    private static final String SQL_MEASURE_MOD_FIELDS = String.format(SQL_TEMPLATE_4_FIELDS, SQL_NAME, SQL_KIND, SQL_IS_PRIMARY, SQL_BASE_K);
    private static final String SQL_MEASURE_ALL_FIELDS = String.format(SQL_TEMPLATE_3_FIELDS, SQL_ID, SQL_MEASURE_MOD_FIELDS, SQL_STD_TAIL_FIELDS);
    public static final String SQL_MEASURE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_MEASURE_ALL_FIELDS, SQL_MEASURE, SQL_ID);
    public static final String SQL_MEASURE_SELECT_BY_KIND = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_MEASURE_ALL_FIELDS, SQL_MEASURE, SQL_KIND);
    public static final String SQL_MEASURE_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_MEASURE_ALL_FIELDS, SQL_MEASURE);
    public static final String SQL_MEASURE_INSERT = String.format(SQL_TEMPLATE_INSERT, SQL_MEASURE, SQL_MEASURE_MOD_FIELDS, SQL_MEASURE_ALL_FIELDS);
    private static final String SQL_USER = "users";
    public static final String SQL_USER_UPDATE = String.format(SQL_TEMPLATE_UPDATE_3, SQL_USER, SQL_LOGIN, SQL_MD5PASSW, SQL_NICK);
    public static final String SQL_USER_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_USER);
    private static final String SQL_USER_MOD_FIELDS = SQL_LOGIN + ", " + SQL_MD5PASSW + ", " + SQL_NICK;
    private static final String SQL_USER_ALL_FIELDS = SQL_ID + ", " + SQL_USER_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    public static final String SQL_USER_SELECT_BY_LOGIN = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_USER_ALL_FIELDS, SQL_USER, SQL_LOGIN);
    public static final String SQL_USER_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_USER_ALL_FIELDS, SQL_USER, SQL_ID);
    public static final String SQL_USER_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_USER_ALL_FIELDS, SQL_USER);
    public static final String SQL_USER_INSERT = String.format(SQL_TEMPLATE_INSERT, SQL_USER, SQL_USER_MOD_FIELDS, SQL_USER_ALL_FIELDS);
    private static final String SQL_ATTRIBUTE = "attribute";
    public static final String SQL_ATTRIBUTE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_2, SQL_ATTRIBUTE, SQL_NAME, SQL_VALUE);
    public static final String SQL_ATTRIBUTE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_ATTRIBUTE);
    private static final String SQL_ATTRIBUTE_MOD_FIELDS = SQL_NAME + ", " + SQL_VALUE;
    private static final String SQL_ATTRIBUTE_ALL_FIELDS = SQL_ID + ", " + SQL_ATTRIBUTE_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    public static final String SQL_ATTRIBUTE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_ATTRIBUTE_ALL_FIELDS, SQL_ATTRIBUTE, SQL_ID);
    public static final String SQL_ATTRIBUTE_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_ATTRIBUTE_ALL_FIELDS, SQL_ATTRIBUTE);
    public static final String SQL_ATTRIBUTE_INSERT = String.format(SQL_TEMPLATE_INSERT, SQL_ATTRIBUTE, SQL_ATTRIBUTE_MOD_FIELDS, SQL_ATTRIBUTE_ALL_FIELDS);
    private static final Logger LOGGER = Logger.getLogger(ConnectionManagerJdbcImpl.class);

    private DaoBgSupport() {
    }

    private static PreparedStatement setStatementParams(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if (params != null) {
            for (int iParam = 0; iParam < params.length; iParam++) {
                preparedStatement.setObject(iParam + 1, params[iParam]);
            }
        }
        return preparedStatement;
    }

    private static Object[] fetchRow(ResultSet resultSet, Object[] target) throws SQLException {
        for (int iColumn = 0; iColumn < target.length; ++iColumn) {
            target[iColumn] = resultSet.getObject(iColumn + 1);
        }

        return target;
    }

    public static boolean execute(String sql, Object... params) {
        boolean isPreparedSql = params != null && params.length > 0;

        try (Connection connection = connectionManager.getConnection();
             Statement statement = isPreparedSql ? null : connection.createStatement();
             PreparedStatement preparedStatement = isPreparedSql ? setStatementParams(connection.prepareStatement(sql), params) : null) {
            return isPreparedSql ? preparedStatement.execute() : statement.execute(sql);
        } catch (SQLException e) {
            LOGGER.trace(Consts.CATCH_EXCEPTION, e);
        }
        return false;
    }

    public static Object executeQueryGetOneField(String sql, Object... params) {
        boolean isPreparedSql = params != null && params.length > 0;

        try (Connection connection = connectionManager.getConnection();
             Statement statement = isPreparedSql ? null : connection.createStatement();
             PreparedStatement preparedStatement = isPreparedSql ?
                     setStatementParams(connection.prepareStatement(sql), params) :
                     null;
             ResultSet resultSet = isPreparedSql ?
                     preparedStatement.executeQuery() :
                     statement.executeQuery(sql)) {
            return resultSet.next() && resultSet.getMetaData().getColumnCount() > 0 ?
                    resultSet.getObject(1) :
                    null;
        } catch (SQLException e) {
            LOGGER.trace(Consts.CATCH_EXCEPTION, e);
        }
        return null;
    }

    public static Object[] executeQueryGetOneRow(String sql, Object... params) {
        boolean isPreparedSql = params != null && params.length > 0;

        try (Connection connection = connectionManager.getConnection();
             Statement statement = isPreparedSql ?
                     null :
                     connection.createStatement();
             PreparedStatement preparedStatement = isPreparedSql ?
                     setStatementParams(connection.prepareStatement(sql), params) :
                     null;
             ResultSet resultSet = isPreparedSql ?
                     preparedStatement.executeQuery() :
                     statement.executeQuery(sql)
        ) {
            if (resultSet.next()) {
                Object[] result = new Object[resultSet.getMetaData().getColumnCount()];

                fetchRow(resultSet, result);
                return result;
            }
        } catch (SQLException e) {
            LOGGER.trace(Consts.CATCH_EXCEPTION, e);
        }
        return new Object[0];
    }

    private static Queue<Object[]> executeQueryGetRows(String sql, Object... params) {
        boolean isPreparedSql = params != null && params.length > 0;

        try (Connection connection = connectionManager.getConnection();
             Statement statement = isPreparedSql ?
                     null :
                     connection.createStatement();
             PreparedStatement preparedStatement = isPreparedSql ?
                     connection.prepareStatement(sql) :
                     null;
             ResultSet resultSet = isPreparedSql ?
                     setStatementParams(preparedStatement, params).executeQuery() :
                     statement.executeQuery(sql)
        ) {
            int colsQty = resultSet.getMetaData().getColumnCount();
            Queue<Object[]> result = new LinkedList<>();

            while (resultSet.next()) {
                result.add(fetchRow(resultSet, new Object[colsQty]));
            }
            return result;
        } catch (SQLException e) {
            LOGGER.trace(Consts.CATCH_EXCEPTION, e);
        }
        return new LinkedList<>();
    }

    private static Object newPonjoObject(Class clazz, Object[] fields) {
        try {
            return clazz.getDeclaredConstructor(fields.getClass()).newInstance(new Object[]{fields});
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.trace(Consts.CATCH_EXCEPTION, e);
        }
        return null;
    }

    public static Object fetchOneRowAsPonjo(Class clazz, String sql, Object... params) {
        Object[] fields = DaoBgSupport.executeQueryGetOneRow(sql, params);
        return fields.length == 0 ? null : newPonjoObject(clazz, fields);
    }

    public static Object[] getRowsAsPonjoArray(Class clazz, String sql, Object... params) {
        Queue<Object[]> fields = executeQueryGetRows(sql, params);
        Object[] users = new Object[fields.size()];

        for (int iUser = 0; !fields.isEmpty(); iUser++) {
            users[iUser] = newPonjoObject(clazz, fields.poll());
        }

        return users;
    }
}
