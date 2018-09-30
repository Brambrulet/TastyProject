package dbAccess;

import java.util.Arrays;

/**
 * @author Сказка
 */
public class DbKeyImpl implements DbKey {
    final Object[][] values;

    /**
     * Default constructor
     */
    public DbKeyImpl(Object[][] values) {
        this.values = values;
    }

    /**
     * @return
     */
    public String[] getFieldsNames() {
        return Arrays.stream(values).map(f -> f[0]).toArray(String[]::new);
    }

    /**
     * @return
     */
    public int getFieldsQty() {
        return values.length;
    }

    /**
     * @return
     */
    public Object get() throws Exception {
        if (values.length == 1) {
            return values[0][1];
        } else {
            throw new Exception("attempt to call a simple method for a complex object");
        }
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Object get(int fieldIndex) throws Exception {
        if (fieldIndex > -1 && fieldIndex < values.length) {
            return values[fieldIndex][1];
        } else {
            throw new Exception("attempt to call a simple method for a complex object");
        }
    }

    /**
     * @param fieldName
     * @return
     */
    public Object get(String fieldName) throws Exception {
        for (Object name[] : values) {
            if (((String) name[0]).equals(fieldName)) {
                return name[1];
            }
        }

        throw new Exception("invalid field name");
    }

    /**
     * @return
     */
    public Long getAsLong() throws Exception {
        return (Long) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Long getAsLong(int fieldIndex) throws Exception {
        return (Long) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public Long getAsLong(String fieldName) throws Exception {
        return (Long) get(fieldName);
    }

    /**
     * @return
     */
    public Integer getAsInteger() throws Exception {
        return (Integer) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Integer getAsInteger(int fieldIndex) throws Exception {
        return (Integer) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public Integer getAsInteger(String fieldName) throws Exception {
        return (Integer) get(fieldName);
    }

    /**
     * @return
     */
    public Short getAsShort() throws Exception {
        return (Short) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Short getAsShort(int fieldIndex) throws Exception {
        return (Short) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public Short getAsShort(String fieldName) throws Exception {
        return (Short) get(fieldName);
    }

    /**
     * @return
     */
    public Byte getAsByte() throws Exception {
        return (Byte) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Byte getAsByte(int fieldIndex) throws Exception {
        return (Byte) get();
    }

    /**
     * @param fieldName
     * @return
     */
    public Byte getAsByte(String fieldName) throws Exception {
        return (Byte) get(fieldName);
    }

    /**
     * @return
     */
    public Character getAsChracter() throws Exception {
        return (Character) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Character getAsChracter(int fieldIndex) throws Exception {
        return (Character) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public Character getAsChracter(String fieldName) throws Exception {
        return (Character) get(fieldName);
    }

    /**
     * @return
     */
    public String getAsString() throws Exception {
        return (String) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public String getAsString(int fieldIndex) throws Exception {
        return (String) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public String getAsString(String fieldName) throws Exception {
        return (String) get(fieldName);
    }

    /**
     * @return
     */
    public Double getAsDouble() throws Exception {
        return (Double) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Double getAsDouble(int fieldIndex) throws Exception {
        return (Double) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public Double getAsDouble(String fieldName) throws Exception {
        return (Double) get(fieldName);
    }

    /**
     * @return
     */
    public Boolean getAsBoolean() throws Exception {
        return (Boolean) get();
    }

    /**
     * @param fieldIndex
     * @return
     */
    public Boolean getAsBoolean(int fieldIndex) throws Exception {
        return (Boolean) get(fieldIndex);
    }

    /**
     * @param fieldName
     * @return
     */
    public Boolean getAsBoolean(String fieldName) throws Exception {
        return (Boolean) get(fieldName);
    }
}