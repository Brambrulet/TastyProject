package dbAccess;

/**
 * Хранит информацию о связи столбцов базы данных и полей классов DbRow*
 *
 * @author Сказка
 */
public class DbRowFieldInfo {

    /**
     *
     */
    public final String dbName;
    /**
     *
     */
    public final int type;
    /**
     *
     */
    public final int size;
    /**
     *
     */
    public final Class linkType;
    /**
     *
     */
    public final int linkIndex;
    /**
     *
     */
    public final boolean isKey;

    /**
     * Default constructor
     */
    public DbRowFieldInfo() {
    }


}