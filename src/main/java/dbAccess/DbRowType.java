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
    DBTYPE_GOODS,
    DBTYPE_FLOWCHART,
    DBTYPE_PROCESSFLOWCHART
}