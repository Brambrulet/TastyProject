package dbAccess;

/**
 *
 */
public interface DbKey {


    /**
     * @return
     */
    public String[] getFieldsNames();

    /**
     * @return
     */
    public int getFieldsQty();

    /**
     * @return
     */
    public Object get() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Object get(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Object get(String fieldName) throws Exception;

    /**
     * @return
     */
    public Long getAsLong() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Long getAsLong(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Long getAsLong(String fieldName) throws Exception;

    /**
     * @return
     */
    public Integer getAsInteger() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Integer getAsInteger(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Integer getAsInteger(String fieldName) throws Exception;

    /**
     * @return
     */
    public Short getAsShort() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Short getAsShort(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Short getAsShort(String fieldName) throws Exception;

    /**
     * @return
     */
    public Byte getAsByte() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Byte getAsByte(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Byte getAsByte(String fieldName) throws Exception;

    /**
     * @return
     */
    public Character getAsChracter() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Character getAsChracter(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Character getAsChracter(String fieldName) throws Exception;

    /**
     * @return
     */
    public String getAsString() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public String getAsString(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public String getAsString(String fieldName) throws Exception;

    /**
     * @return
     */
    public Double getAsDouble() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Double getAsDouble(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Double getAsDouble(String fieldName) throws Exception;

    /**
     * @return
     */
    public Boolean getAsBoolean() throws Exception;

    /**
     * @param fieldIndex
     * @return
     */
    public Boolean getAsBoolean(int fieldIndex) throws Exception;

    /**
     * @param fieldName
     * @return
     */
    public Boolean getAsBoolean(String fieldName) throws Exception;

}