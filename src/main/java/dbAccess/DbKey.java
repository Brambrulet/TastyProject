package dbAccess;

/**
 *
 */
public interface DbKey {


    /**
     * @return
     */
    public String getFieldsNames();

    /**
     * @return
     */
    public int getFieldsQty();

    /**
     * @return
     */
    public Object get();

    /**
     * @param int fieldIndex
     * @return
     */
    public Object get(void int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Object get(String fieldName);

    /**
     * @return
     */
    public Long getAsLong();

    /**
     * @param fieldIndex
     * @return
     */
    public Long getAsLong(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Long getAsLong(String fieldName);

    /**
     * @return
     */
    public Integer getAsInteger();

    /**
     * @param fieldIndex
     * @return
     */
    public Integer getAsInteger(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Integer getAsInteger(String fieldName);

    /**
     * @return
     */
    public Short getAsShort();

    /**
     * @param fieldIndex
     * @return
     */
    public Short getAsShort(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Short getAsShort(String fieldName);

    /**
     * @return
     */
    public Byte getAsByte();

    /**
     * @param fieldIndex
     * @return
     */
    public Byte getAsByte(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Byte getAsByte(String fieldName);

    /**
     * @return
     */
    public Character getAsChracter();

    /**
     * @param fieldIndex
     * @return
     */
    public Character getAsChracter(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Character getAsChracter(String fieldName);

    /**
     * @return
     */
    public String getAsString();

    /**
     * @param fieldIndex
     * @return
     */
    public String getAsString(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public String getAsString(String fieldName);

    /**
     * @return
     */
    public Double getAsDouble();

    /**
     * @param fieldIndex
     * @return
     */
    public Double getAsDouble(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Double getAsDouble(String fieldName);

    /**
     * @return
     */
    public Boolean getAsBoolean();

    /**
     * @param fieldIndex
     * @return
     */
    public Boolean getAsBoolean(int fieldIndex);

    /**
     * @param fieldName
     * @return
     */
    public Boolean getAsBoolean(String fieldName);

}