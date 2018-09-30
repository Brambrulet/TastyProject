package dbAccess;

/**
 *
 */
public interface DbRow {

    /**
     * @param item
     * @return
     */
    public static DbRow newItem(DbRow item, DbRowType dbRowType) {
        // TODO implement here
        return null;
    }

    /**
     * return value of Id field
     *
     * @return Id of row in database
     */
    public DbKey getKey();

    /**
     * @return
     */
    public boolean read();

    /**
     * @param id
     * @return
     */
    public boolean read(int id);

    /**
     * @return
     */
    public boolean readAndResolveAllLinks();

    /**
     * @param id
     * @return
     */
    public boolean readAndResolveAllLinks(int id);

    /**
     * @return
     */
    public boolean write();

    /**
     * @return
     */
    public boolean delete();

    /**
     * @return
     */
    public DbRow newItem();

    /**
     * @param field
     * @return
     */
    public Object getValueByName(String field);

    /**
     * @param field
     * @return
     */
    public Long getValueByNameAsLong(String field);

    /**
     * @param field
     * @return
     */
    public Integer getValueByNameAsInteger(String field);

    /**
     * @param field
     * @return
     */
    public Short getValueByNameAsShort(String field);

    /**
     * @param field
     * @return
     */
    public byte getValueByNameAsByte(String field);

    /**
     * @param field
     * @return
     */
    public Character getValueByNameAsCharacter(String field);

    /**
     * @param field
     * @return
     */
    public Double getValueByNameAsDouble(String field);

    /**
     * @param field
     * @return
     */
    public Float getValueByNameAsFloat(String field);

    /**
     * @param field
     * @return
     */
    public String getValueByNameAsString(String field);

    /**
     * @param field
     * @return
     */
    public Boolean getValueByNameAsBoolean(String field);

    /**
     * @param fieldIndex
     * @return
     */
    public Object getValueByIndex(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Long getValueByIndexAsLong(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Integer getValueByIndexAsInteger(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Short getValueByIndexAsShort(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Byte getValueByIndexAsByte(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Character getValueByIndexAsCharacter(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public String getValueByIndexAsString(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Double getValueByIndexAsDouble(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Float getValueByIndexAsFloat(int fieldIndex);

    /**
     * @param fieldIndex
     * @return
     */
    public Boolean getValueByIndexAsBoolean(int fieldIndex);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Object value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Long value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Integer value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Short value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Byte value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Character value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, String value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Double value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Float value);

    /**
     * @param field
     * @param value
     */
    public void setValueByName(String field, Boolean value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Object value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Long value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Integer value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Short value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Byte value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Character value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, String value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Double value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Float value);

    /**
     * @param fieldIndex
     * @param value
     */
    public void setValueByIndex(int fieldIndex, Boolean value);

    /**
     * @param field
     * @return
     */
    public DbRow readLinkByName(String field);

    /**
     * @param linkedFieldName
     * @return
     */
    public boolean resolveLinkByFieldName(String linkedFieldName);

    /**
     * @param linkedFieldIndex
     * @return
     */
    public boolean resolveLinkByFieldIndex(int linkedFieldIndex);

    /**
     * @param linkIndex
     * @return
     */
    public boolean resolveLinkByLinkIndex(int linkIndex);

    /**
     * @return
     */
    public boolean resolveAllLinks();

    /**
     * @param linkedFieldName
     * @return
     */
    public boolean updateLinkByFieldName(String linkedFieldName);

    /**
     * @return
     */
    public boolean updateAllLinks();

    /**
     * @return
     */
    public boolean modified();

}