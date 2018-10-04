package pojo;

import java.sql.Timestamp;

public class PojoAttribute {
    private Integer id;
    private String name;
    private String value;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoAttribute(Integer id, String name, String value, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        init(id, name, value, makerId, editorId, makeDate, editDate);
    }

    public PojoAttribute(Object[] fields) {
        init(fields);
    }

    public PojoAttribute() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getMakerId() {
        return makerId;
    }

    public void setMakerId(Integer makerId) {
        this.makerId = makerId;
    }

    public Integer getEditorId() {
        return editorId;
    }

    public void setEditorId(Integer editorId) {
        this.editorId = editorId;
    }

    public Timestamp getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Timestamp makeDate) {
        this.makeDate = makeDate;
    }

    public Timestamp getEditDate() {
        return editDate;
    }

    public void setEditDate(Timestamp editDate) {
        this.editDate = editDate;
    }

    public void init(Integer id, String name, String value, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.makerId = makerId;
        this.editorId = editorId;
        this.makeDate = makeDate;
        this.editDate = editDate;
    }

    public void init(Object[] fields) {
        boolean isNull = fields == null;

        this.id = isNull ? null : (Integer) fields[0];
        this.name = isNull ? null : (String) fields[1];
        this.value = isNull ? null : (String) fields[2];
        this.makerId = isNull ? null : (Integer) fields[3];
        this.editorId = isNull ? null : (Integer) fields[4];
        this.makeDate = isNull ? null : (Timestamp) fields[5];
        this.editDate = isNull ? null : (Timestamp) fields[6];
    }
}
