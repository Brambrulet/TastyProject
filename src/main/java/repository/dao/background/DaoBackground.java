package repository.dao.background;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static utils.consts.Consts.*;


/**
 * Утильный класс. Берёт на себя большую часть работы с запросами.
 *
 * Все методы имеют парметр params: Object... params
 * Если хотя бы одно значение передано, то будет использован PreparedStatement,
 * и все значения params будут переданы в запрос.
 *
 * Если параметров передано не было, то используется Statement
 *
 * Класс DaoBackground является дженериком,
 * и специализироваться должен типом объекта Pojo.
 *
 * Конструктор принимает три параметра - все функциональные интерфейсы.
 * Function<Object[], T> pojoMaker - создатель объектов Pojo
 * IntFunction<T[]> pojoArrayMaker - создатель массива объектов Pojo
 * BiConsumer<T, Object[]> pojoPusher - пушер объектов Pojo
 */
public class DaoBackground<T> {
    private static final Logger LOGGER = Logger.getLogger(DaoBackground.class);
    private final Function<Object[], T> pojoMaker;
    private final IntFunction<T[]> pojoArrayMaker;
    private final BiConsumer<T, Object[]> pojoPusher;

    private static final String SQL_ID = "id";
    private static final String SQL_NAME = "name";
    private static final String SQL_LOGIN = "login";
    private static final String SQL_MD5PASSW = "md5passw";
    private static final String SQL_NICK = "nick";
    private static final String SQL_VALUE = "value";
    private static final String SQL_KIND = "kind";
    private static final String SQL_IS_PRIMARY = "is_primary";
    private static final String SQL_BASE_K = "base_k";
    private static final String SQL_K = "k";
    private static final String SQL_NODE_ID = "node_id";
    private static final String SQL_MEASURE_ID = "measure_id";
    private static final String SQL_SINGLETON = "is_singleton";
    private static final String SQL_MAKER_ID = "maker_id";
    private static final String SQL_EDITOR_ID = "editor_id";
    private static final String SQL_MAKE_DATE = "make_date";
    private static final String SQL_EDIT_DATE = "edit_date";
    private static final String SQL_TEMPLATE_SELECT = "select %s from %s;";
    private static final String SQL_TEMPLATE_SELECT_WHERE = "select %s from %s where %s = ?;";
    private static final String SQL_VERSION_ID = "version_id";
    private static final String SQL_GOODS_ID = "goods_id";
    private static final String SQL_TEMPLATE_DELETE = "delete from %s where id = ?;";
    private static final String SQL_SET_ID = "set_id";
    private static final String SQL_PARAMS = "params";
    private static final String SQL_VALUE1 = "value1";
    private static final String SQL_VALUE2 = "value2";
    private static final String SQL_VALUE3 = "value3";
    private static final String SQL_START_DATE = "start_date";
    private static final String SQL_SET_VALUE = "set_value";
    private static final String SQL_PARENT_ID = "parent_id";
    private static final String SQL_NODE_TYPE = "node_type";
    private static final String SQL_TEMPLATE_SELECT_WHERE_2 = "select %s from %s where %s = ? and %s = ?;";

    private static final String SQL_TEMPLATE_INSERT_2 = "insert into %s(%s, editor_id) values(?, ?, ?) returning %s";
    private static final String SQL_TEMPLATE_3_FIELDS = "%s, %s, %s";
    private static final String SQL_TEMPLATE_4_FIELDS = "%s, %s, %s, %s";
    private static final String SQL_STD_TAIL_FIELDS = String.format(SQL_TEMPLATE_4_FIELDS, SQL_MAKER_ID, SQL_EDITOR_ID, SQL_MAKE_DATE, SQL_EDIT_DATE);

    private static final String SQL_TEMPLATE_SELECT_ROOT = "select %s from %s where parent_node = -1;";
    private static final String SQL_TEMPLATE_DELETE_2 = "delete from %s where %s = ? and %s = ?;";

    private static final String SQL_TEMPLATE_INSERT_4 = "insert into %s(%s, editor_id) values(?, ?, ?, ?, ?) returning %s";
    private static final String SQL_TEMPLATE_INSERT_7 = "insert into %s(%s, editor_id) values(?, ?, ?, ?, ?, ?, ?, ?) returning %s";
    private static final String SQL_TEMPLATE_UPDATE_2 = "update %s set %s=?, %s=?, editor_id=? where id = ?";
    private static final String SQL_TEMPLATE_UPDATE_2_2 = "update %s set %s=?, %s=?, editor_id=? where %s = ? and %s = ?";
    private static final String SQL_TEMPLATE_UPDATE_3 = "update %s set %s=?, %s=?, %s=?, editor_id=? where id = ?";
    private static final String SQL_TEMPLATE_INSERT_3 = "insert into %s(%s, editor_id) values(?, ?, ?, ?) returning %s";
    private static final String SQL_TEMPLATE_UPDATE_7 = "update %s set %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, editor_id=? where id = ?";
    private static final String SQL_TEMPLATE_UPDATE_4 = "update %s set %s=?, %s=?, %s=?, %s=?, editor_id=? where id = ?";

    private static final String SQL_MEASURE = "measure";
    private static final String SQL_MEASURE_MOD_FIELDS = String.format(SQL_TEMPLATE_4_FIELDS, SQL_NAME, SQL_KIND, SQL_IS_PRIMARY, SQL_BASE_K);
    private static final String SQL_MEASURE_ALL_FIELDS = String.format(SQL_TEMPLATE_3_FIELDS, SQL_ID, SQL_MEASURE_MOD_FIELDS, SQL_STD_TAIL_FIELDS);
    protected static final String SQL_MEASURE_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_MEASURE_ALL_FIELDS, SQL_MEASURE);
    protected static final String SQL_MEASURE_INSERT = String.format(SQL_TEMPLATE_INSERT_4, SQL_MEASURE,
            SQL_MEASURE_MOD_FIELDS, SQL_MEASURE_ALL_FIELDS);
    protected static final String SQL_MEASURE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_MEASURE);
    protected static final String SQL_MEASURE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_4, SQL_MEASURE, SQL_NAME, SQL_KIND, SQL_IS_PRIMARY, SQL_BASE_K);

    private static final String SQL_USER = "users";
    protected static final String SQL_MEASURE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_MEASURE_ALL_FIELDS, SQL_MEASURE, SQL_ID);
    protected static final String SQL_MEASURE_SELECT_BY_KIND = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_MEASURE_ALL_FIELDS, SQL_MEASURE, SQL_KIND);
    private static final String SQL_USER_MOD_FIELDS = SQL_LOGIN + ", " + SQL_MD5PASSW + ", " + SQL_NICK;
    private static final String SQL_USER_ALL_FIELDS = SQL_ID + ", " + SQL_USER_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_USER_INSERT = String.format(SQL_TEMPLATE_INSERT_3, SQL_USER, SQL_USER_MOD_FIELDS, SQL_USER_ALL_FIELDS);
    protected static final String SQL_USER_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_USER);
    protected static final String SQL_USER_SELECT_BY_LOGIN = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_USER_ALL_FIELDS, SQL_USER, SQL_LOGIN);
    protected static final String SQL_USER_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_USER_ALL_FIELDS, SQL_USER, SQL_ID);
    protected static final String SQL_USER_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_USER_ALL_FIELDS, SQL_USER);
    protected static final String SQL_USER_UPDATE = String.format(SQL_TEMPLATE_UPDATE_3, SQL_USER, SQL_LOGIN, SQL_MD5PASSW, SQL_NICK);

    private static final String SQL_ATTRIBUTE = "attribute";
    private static final String SQL_ATTRIBUTE_MOD_FIELDS = SQL_NAME + ", " + SQL_VALUE;
    private static final String SQL_ATTRIBUTE_ALL_FIELDS = SQL_ID + ", " + SQL_ATTRIBUTE_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_ATTRIBUTE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_ATTRIBUTE);
    protected static final String SQL_ATTRIBUTE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_ATTRIBUTE_ALL_FIELDS, SQL_ATTRIBUTE, SQL_ID);
    protected static final String SQL_ATTRIBUTE_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_ATTRIBUTE_ALL_FIELDS, SQL_ATTRIBUTE);
    protected static final String SQL_ATTRIBUTE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_2, SQL_ATTRIBUTE, SQL_NAME, SQL_VALUE);
    protected static final String SQL_ATTRIBUTE_INSERT = String.format(SQL_TEMPLATE_INSERT_2, SQL_ATTRIBUTE, SQL_ATTRIBUTE_MOD_FIELDS, SQL_ATTRIBUTE_ALL_FIELDS);

    private static final String SQL_GOODS = "goods";
    protected static final String SQL_GOODS_UPDATE = String.format(SQL_TEMPLATE_UPDATE_3, SQL_GOODS, SQL_NAME, SQL_NODE_ID, SQL_MEASURE_ID);
    protected static final String SQL_GOODS_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_GOODS);
    private static final String SQL_GOODS_MOD_FIELDS = SQL_NAME + ", " + SQL_NODE_ID + ", " + SQL_MEASURE_ID;
    private static final String SQL_GOODS_ALL_FIELDS = SQL_ID + ", " + SQL_GOODS_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_GOODS_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_GOODS_ALL_FIELDS, SQL_GOODS, SQL_ID);
    protected static final String SQL_GOODS_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_GOODS_ALL_FIELDS, SQL_GOODS);
    protected static final String SQL_GOODS_INSERT = String.format(SQL_TEMPLATE_INSERT_3, SQL_GOODS, SQL_GOODS_MOD_FIELDS, SQL_GOODS_ALL_FIELDS);

    private static final String SQL_SET = "set";
    protected static final String SQL_SET_UPDATE = String.format(SQL_TEMPLATE_UPDATE_4, SQL_SET, SQL_NAME, SQL_NODE_ID, SQL_MEASURE_ID, SQL_SINGLETON);
    protected static final String SQL_SET_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_SET);
    private static final String SQL_SET_MOD_FIELDS = SQL_NAME + ", " + SQL_NODE_ID + ", " + SQL_MEASURE_ID + ", " + SQL_SINGLETON;
    private static final String SQL_SET_ALL_FIELDS = SQL_ID + ", " + SQL_SET_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_SET_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_SET_ALL_FIELDS, SQL_SET, SQL_ID);
    protected static final String SQL_SET_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_SET_ALL_FIELDS, SQL_SET);
    protected static final String SQL_SET_INSERT = String.format(SQL_TEMPLATE_INSERT_4, SQL_SET, SQL_SET_MOD_FIELDS, SQL_SET_ALL_FIELDS);

    private static final String SQL_SET_LINE = "set_line";
    private static final String SQL_SET_LINE_MOD_FIELDS = SQL_VERSION_ID + ", " + SQL_GOODS_ID + ", " + SQL_SET_ID + ", " + SQL_PARAMS + ", " + SQL_VALUE1 + ", " + SQL_VALUE2 + ", " + SQL_VALUE3;
    private static final String SQL_SET_LINE_ALL_FIELDS = SQL_ID + ", " + SQL_SET_LINE_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_SET_LINE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_7, SQL_SET_LINE, SQL_VERSION_ID, SQL_GOODS_ID, SQL_SET_ID, SQL_PARAMS, SQL_VALUE1, SQL_VALUE2, SQL_VALUE3);
    protected static final String SQL_SET_LINE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_SET_LINE);
    protected static final String SQL_SET_LINE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_SET_LINE_ALL_FIELDS, SQL_SET_LINE, SQL_ID);
    protected static final String SQL_SET_LINE_SELECT_BY_VERSION = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_SET_LINE_ALL_FIELDS, SQL_SET_LINE, SQL_VERSION_ID);
    protected static final String SQL_SET_LINE_INSERT = String.format(SQL_TEMPLATE_INSERT_7, SQL_SET_LINE, SQL_SET_LINE_MOD_FIELDS, SQL_SET_LINE_ALL_FIELDS);

    private static final String SQL_SET_TREE = "set_tree";
    private static final String SQL_TREE_MOD_FIELDS = SQL_PARENT_ID + ", " + SQL_NAME + ", " + SQL_NODE_TYPE;
    protected static final String SQL_TREE_ALL_FIELDS = SQL_ID + ", " + SQL_TREE_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_SET_TREE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_3, SQL_SET_TREE, SQL_PARENT_ID, SQL_NAME, SQL_NODE_TYPE);
    protected static final String SQL_SET_TREE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_SET_TREE);
    protected static final String SQL_SET_TREE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_TREE_ALL_FIELDS, SQL_SET_TREE, SQL_ID);
    protected static final String SQL_SET_TREE_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_TREE_ALL_FIELDS, SQL_SET_TREE);
    protected static final String SQL_SET_TREE_SELECT_ROOT = String.format(SQL_TEMPLATE_SELECT_ROOT, SQL_TREE_ALL_FIELDS, SQL_SET_TREE);
    protected static final String SQL_SET_TREE_SELECT_CHILDREN = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_TREE_ALL_FIELDS, SQL_SET_TREE, SQL_PARENT_ID);
    protected static final String SQL_SET_TREE_INSERT = String.format(SQL_TEMPLATE_INSERT_3, SQL_SET_TREE, SQL_TREE_MOD_FIELDS, SQL_TREE_ALL_FIELDS);

    private static final String SQL_GOODS_TREE = "goods_tree";
    protected static final String SQL_GOODS_TREE_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_TREE_ALL_FIELDS, SQL_GOODS_TREE, SQL_ID);
    protected static final String SQL_GOODS_TREE_SELECT_ALL = String.format(SQL_TEMPLATE_SELECT, SQL_TREE_ALL_FIELDS, SQL_GOODS_TREE);
    protected static final String SQL_GOODS_TREE_SELECT_ROOT = String.format(SQL_TEMPLATE_SELECT_ROOT, SQL_TREE_ALL_FIELDS, SQL_GOODS_TREE);
    protected static final String SQL_GOODS_TREE_SELECT_CHILDREN = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_TREE_ALL_FIELDS, SQL_GOODS_TREE, SQL_PARENT_ID);
    protected static final String SQL_GOODS_TREE_INSERT = String.format(SQL_TEMPLATE_INSERT_3, SQL_GOODS_TREE, SQL_TREE_MOD_FIELDS, SQL_TREE_ALL_FIELDS);
    protected static final String SQL_GOODS_TREE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_3, SQL_GOODS_TREE, SQL_PARENT_ID, SQL_NAME, SQL_NODE_TYPE);
    protected static final String SQL_GOODS_TREE_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_GOODS_TREE);

    private static final String SQL_SET_VERSION = "set_version";
    protected static final String SQL_SET_VERSION_UPDATE = String.format(SQL_TEMPLATE_UPDATE_3, SQL_SET_VERSION, SQL_PARENT_ID, SQL_NAME, SQL_NODE_TYPE);
    protected static final String SQL_SET_VERSION_DELETE = String.format(SQL_TEMPLATE_DELETE, SQL_SET_VERSION);
    private static final String SQL_SET_VERSION_MOD_FIELDS = SQL_SET_ID + ", " + SQL_START_DATE + ", " + SQL_SET_VALUE;
    private static final String SQL_SET_VERSION_ALL_FIELDS = SQL_ID + ", " + SQL_SET_VERSION_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_SET_VERSION_SELECT_BY_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_SET_VERSION_ALL_FIELDS, SQL_SET_VERSION, SQL_ID);
    protected static final String SQL_SET_VERSION_SELECT_BY_SET_ID = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_SET_VERSION_ALL_FIELDS, SQL_SET_VERSION, SQL_SET_ID);
    protected static final String SQL_SET_VERSION_INSERT = String.format(SQL_TEMPLATE_INSERT_3, SQL_SET_VERSION, SQL_SET_VERSION_MOD_FIELDS, SQL_SET_VERSION_ALL_FIELDS);

    private static final String SQL_GOODS_MEASURE = "goods_measure";
    protected static final String SQL_GOODS_MEASURE_UPDATE = String.format(SQL_TEMPLATE_UPDATE_2_2, SQL_GOODS_MEASURE, SQL_IS_PRIMARY, SQL_K, SQL_GOODS_ID, SQL_MEASURE_ID);
    protected static final String SQL_GOODS_MEASURE_DELETE = String.format(SQL_TEMPLATE_DELETE_2, SQL_GOODS_MEASURE, SQL_GOODS_ID, SQL_MEASURE_ID);
    private static final String SQL_GOODS_MEASURE_MOD_FIELDS = SQL_IS_PRIMARY + ", " + SQL_K;
    private static final String SQL_GOODS_MEASURE_ALL_FIELDS = SQL_GOODS_ID + ", " + SQL_MEASURE_ID + ", " + SQL_GOODS_MEASURE_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_GOODS_MEASURE_SELECT_BY_IDS = String.format(SQL_TEMPLATE_SELECT_WHERE_2, SQL_GOODS_MEASURE_ALL_FIELDS, SQL_GOODS_MEASURE, SQL_GOODS_ID, SQL_MEASURE_ID);
    protected static final String SQL_GOODS_MEASURE_SELECT_ALL_FOR_GOODS = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_GOODS_MEASURE_ALL_FIELDS, SQL_GOODS_MEASURE, SQL_GOODS_ID);
    protected static final String SQL_GOODS_MEASURE_INSERT = String.format(SQL_TEMPLATE_INSERT_4, SQL_GOODS_MEASURE, SQL_GOODS_ID + ", " + SQL_MEASURE_ID + ", " + SQL_GOODS_MEASURE_MOD_FIELDS, SQL_GOODS_MEASURE_ALL_FIELDS);

    private static final String SQL_GOODS_SET = "goods_set";
    protected static final String SQL_GOODS_SET_UPDATE = String.format(SQL_TEMPLATE_UPDATE_2_2, SQL_GOODS_SET, SQL_MEASURE_ID, SQL_K, SQL_GOODS_ID, SQL_SET_ID);
    protected static final String SQL_GOODS_SET_DELETE = String.format(SQL_TEMPLATE_DELETE_2, SQL_GOODS_SET, SQL_GOODS_ID, SQL_SET_ID);
    private static final String SQL_GOODS_SET_MOD_FIELDS = SQL_MEASURE_ID + ", " + SQL_K;
    private static final String SQL_GOODS_SET_ALL_FIELDS = SQL_GOODS_ID + ", " + SQL_SET_ID + ", " + SQL_GOODS_SET_MOD_FIELDS + ", " + SQL_STD_TAIL_FIELDS;
    protected static final String SQL_GOODS_SET_SELECT_BY_IDS = String.format(SQL_TEMPLATE_SELECT_WHERE_2, SQL_GOODS_SET_ALL_FIELDS, SQL_GOODS_SET, SQL_GOODS_ID, SQL_SET_ID);
    protected static final String SQL_GOODS_SET_SELECT_ALL_FOR_GOODS = String.format(SQL_TEMPLATE_SELECT_WHERE, SQL_GOODS_SET_ALL_FIELDS, SQL_GOODS_SET, SQL_GOODS_ID);
    protected static final String SQL_GOODS_SET_INSERT = String.format(SQL_TEMPLATE_INSERT_4, SQL_GOODS_SET, SQL_GOODS_ID + ", " + SQL_SET_ID + ", " + SQL_GOODS_SET_MOD_FIELDS, SQL_GOODS_SET_ALL_FIELDS);

    /**
     * Конструктор принимает три параметра - все функциональные интерфейсы.
     * Function<Object[], T> pojoMaker - создатель объектов Pojo
     * IntFunction<T[]> pojoArrayMaker - создатель массива объектов Pojo
     * BiConsumer<T, Object[]> pojoPusher - пушер объектов Pojo
     *
     *
     * @param pojoMaker
     * @param pojoArrayMaker
     * @param pojoPusher
     */
    protected DaoBackground(Function<Object[], T> pojoMaker,
                            IntFunction<T[]> pojoArrayMaker,
                            BiConsumer<T, Object[]> pojoPusher
    ) {
        this.pojoMaker = pojoMaker;
        this.pojoArrayMaker = pojoArrayMaker;
        this.pojoPusher = pojoPusher;
    }

    /**
     * Пробегает по столбцам в source (результат SQL запроса)
     * и возвращает массив значений (Object[])
     *
     * @param source
     * @return
     * @throws SQLException
     */
    private static Object[] internalObjArrayFromResultSet(ResultSet source) throws SQLException {
        Object[] result = new Object[source.getMetaData().getColumnCount()];

        for (int iColumn = 0; iColumn < result.length; ++iColumn) {
            result[iColumn] = source.getObject(iColumn + 1);
        }

        return result;
    }

    /**
     * Исполняет запрос sql.
     * Возвращает true, если всё ок.
     *
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     *
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    protected static boolean execute(String sql, Object... params) {
        try (DaoStatement statement = new DaoStatement(sql, params)) {

            return statement.execute();
        } catch (SQLException e) {
            LOGGER.trace(CATCH_EXCEPTION, e);
        }
        return false;
    }

    /**
     * Исполняет запрос sql,
     * возвращает первое значение в первой строке
     * результатов запроса (ResultSet resultSet).
     * Остальные результаты запроса игнорируются.
     *
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт null.
     *
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     *
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    protected static Object fetchOneFieldAsObject(String sql, Object... params) {
        try (DaoStatement statement = new DaoStatement(sql, params);
             ResultSet resultSet = statement.executeQuery()) {

            if(resultSet != null && resultSet.next() && resultSet.getMetaData().getColumnCount() > 0){
                return resultSet.getObject(1);
            }else{
                return null;
            }
        } catch (SQLException e) {
            LOGGER.trace(CATCH_EXCEPTION, e);
        }
        return null;
    }

    /**
     * Исполняет запрос sql,
     * возвращает все значения из первой строки
     * результатов запроса (ResultSet resultSet)
     * в виде массива (Object[]).
     * Остальные результаты запроса игнорируются.
     *
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт массив нулевой длины (new Object[0]).
     *
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     *
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    protected static Object[] fetchOneRowAsObjArray(String sql, Object... params) {
        try (DaoStatement statement = new DaoStatement(sql, params);
             ResultSet resultSet = statement.executeQuery()) {

            if(resultSet != null && resultSet.next()){
                return internalObjArrayFromResultSet(resultSet);
            }else{
                return new Object[0];
            }
        } catch (SQLException e) {
            LOGGER.trace(CATCH_EXCEPTION, e);
        }
        return new Object[0];
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * результатов запроса (ResultSet resultSet)
     * передаёт пушеру (pusher - функциональный интерфейс)
     * в виде массива (Object[]).
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     *
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт false.
     *
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     *
     * Если параметров передано не было, то используется Statement
     *
     * @param pusher
     * @param sql
     * @param params
     * @return
     */
    protected static boolean fetchOneRowAsPojoObject(Consumer<Object[]> pusher, String sql, Object... params) {
        Object[] fields = fetchOneRowAsObjArray(sql, params);

        if (fields.length == 0) {
            return false;
        } else {
            pusher.accept(fields);
            return true;
        }
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * результатов запроса (ResultSet resultSet)
     * пушером (pojoPusher - функциональный интерфейс, задаётся в конструкторе)
     * загоняются в объект destPojo (передаётся в функцию в параметрах).
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     *
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт false.
     *
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     *
     * Если параметров передано не было, то используется Statement
     *
     * @param destPojo
     * @param sql
     * @param params
     * @return
     */
    protected boolean fetchOneRowAsPojoObject(T destPojo, String sql, Object... params) {
        Object[] fields = fetchOneRowAsObjArray(sql, params);

        if (fields.length == 0) {
            return false;
        } else {
            pojoPusher.accept(destPojo, fields);
            return true;
        }
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * передаются в конструктов объекта Pojo,
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     *
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт null.
     *
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     *
     * Если параметров передано не было, то используется Statement
     * @param sql
     * @param params
     * @return
     */
    protected T fetchOneRowAsPojoObject(String sql, Object... params) {
        Object[] fields = fetchOneRowAsObjArray(sql, params);
        return fields.length == 0 ? null : pojoMaker.apply(fields);
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * передаются в конструктор объекта Pojo,
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     *
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт null.
     *
     * @param sql
     * @param params
     * @return
     */
    protected T[] fetchRowsAsPojoArray(String sql, Object... params) {
        try (DaoStatement statement = new DaoStatement(sql, params);
             ResultSet resultSet = statement.executeQuery()) {

            if(resultSet != null){
                List<T> pojoList = new ArrayList<>();

                while (resultSet.next()) {
                    pojoList.add(pojoMaker.apply(internalObjArrayFromResultSet(resultSet)));
                }

                return pojoList.toArray(pojoArrayMaker.apply(pojoList.size()));
            }else{
                return pojoArrayMaker.apply(0);
            }
        } catch (SQLException e) {
            LOGGER.trace(CATCH_EXCEPTION, e);
        }
        return pojoArrayMaker.apply(0);
    }
}
