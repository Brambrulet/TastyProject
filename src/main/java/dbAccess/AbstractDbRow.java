package dbAccess;

/**
 * @author Сказка
 */
public class AbstractDbRow implements DbRow {

    /**
     *
     */
    final DbRowType rowType;
    /**
     *
     */
    final Object fields[];
    /**
     *
     */
    final DbRow links[];
    /**
     *
     */
    boolean modified = false;


    /**
     * @param rowType
     */
    AbstractDbRow(DbRowType rowType) {
        this.rowType = rowType;
        fields = new Object[rowType.fieldsInfo.length];
        links = new DbRow[rowType.linksQty];
    }

    /**
     * @param item
     * @return
     */
    public static DbRow newItem(DbRow item) {
        // TODO implement here
        return null;
    }

    /**
     * return value of Id field
     *
     * @return Id of row in database
     */
    public DbKey getKey() {
        Object[][] key = new Object[rowType.keyFields.length][];
        for (int iField : rowType.keyFields) {
            key[iField] = new Object[]{rowType.fieldsInfo[iField].dbName, fields[iField]};
        }
        return new DbKeyImpl(key);
    }

    /**
     * @return
     */
    public boolean read() {
        // TODO implement here
        return false;
    }

    /**
     * @param id
     * @return
     */
    public boolean read(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean readAndResolveAllLinks() {
        // TODO implement here
        return false;
    }

    /**
     * @param id
     * @return
     */
    public boolean readAndResolveAllLinks(int id) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean write() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean delete() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public DbRow newItem() {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public Object getValueByName(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public Long getValueByNameAsLong(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public Integer getValueByNameAsInteger(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public Short getValueByNameAsShort(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public byte getValueByNameAsByte(String field) {
        // TODO implement here
        return 0;
    }

    /**
     * @param field
     * @return
     */
    public Character getValueByNameAsCharacter(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public Double getValueByNameAsDouble(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public Float getValueByNameAsFloat(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @return
     */
    public String getValueByNameAsString(String field) {
        // TODO implement here
        return "";
    }

    /**
     * @param field
     * @return
     */
    public Boolean getValueByNameAsBoolean(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Object getValueByIndex(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Long getValueByIndexAsLong(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Integer getValueByIndexAsInteger(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Short getValueByIndexAsShort(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Byte getValueByIndexAsByte(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Character getValueByIndexAsCharacter(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public String getValueByIndexAsString(int fieldIndex) {
        // TODO implement here
        return "";
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Double getValueByIndexAsDouble(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Float getValueByIndexAsFloat(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Boolean getValueByIndexAsBoolean(int fieldIndex) {
        // TODO implement here
        return null;
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Object value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Long value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Integer value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Short value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Byte value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Character value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, String value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Double value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Float value) {
        // TODO implement here
    }

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Boolean value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Object value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Long value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Integer value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Short value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Byte value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Character value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, String value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Double value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Float value) {
        // TODO implement here
    }

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Boolean value) {
        // TODO implement here
    }

    /**
     * @param field
     * @return
     */
    public DbRow readLinkByName(String field) {
        // TODO implement here
        return null;
    }

    /**
     * @param linkedFieldName
     * @return
     */
    public boolean resolveLinkByFieldName(String linkedFieldName) {
        // TODO implement here
        return false;
    }

    /**
     * @param linkedFieldIndex
     * @return
     */
    public boolean resolveLinkByFieldIndex(int linkedFieldIndex) {
        // TODO implement here
        return false;
    }

    /**
     * @param linkIndex
     * @return
     */
    public boolean resolveLinkByLinkIndex(int linkIndex) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean resolveAllLinks() {
        // TODO implement here
        return false;
    }

    /**
     * @param linkedFieldName
     * @return
     */
    public boolean updateLinkByFieldName(String linkedFieldName) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean updateAllLinks() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean modified() {
        // TODO implement here
        return false;
    }

}