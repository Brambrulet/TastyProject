package dbAccess;

/**
 * Перечисление задаёт список типов строк, которые могут быть получены из базы.
 * Так же элементы перечисления хранят информацию о полях соответствующих наборов данных.
 */
public enum DbRowType {
    DBTYPE_USER,
    DBTYPE_SET,
    DBTYPE_SET_VERSION,
    DBTYPE_SET_LINE,
    DBTYPE_SET_TREE,
    DBTYPE_GOODS,
    DBTYPE_GOODS_SETS,
    DBTYPE_GOODS_MEASURE,
    DBTYPE_FLOWCHART,
    DBTYPE_PROCESSFLOWCHART,
    DBTYPE_ATTRIBUTES,
    DBTYPE_MEASURE;

    DbFieldInfo[] fieldsInfo;
    String sqlSelect;
    String sqlUpdate;
    String sqlInsert;
    String sqlDelete;

    int linksQty;
    int[] keyFields;
}