package dbAccess;

/**
 * Хранит информацию о связи столбцов базы данных и полей классов DbRow*
 *
 * @author Сказка
 */
public class DbFieldInfo {

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
     * @param dbName
     * @param type
     * @param size
     * @param linkType
     * @param linkIndex
     * @param isKey
     */
    public DbFieldInfo(String dbName, int type, int size, Class linkType, int linkIndex, boolean isKey) {
        this.dbName = dbName;
        this.type = type;
        this.size = size;
        this.linkType = linkType;
        this.linkIndex = linkIndex;
        this.isKey = isKey;
    }


}