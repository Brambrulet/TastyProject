package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class PojoAttribute {
    private Integer id;
    private String name;
    private String value;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoAttribute(Object... fields) {
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

    public void init(Object... fields) {
        if (fields == null || fields.length != 7) throw new InvalidNumberOfArgumentsException();

        this.id = (Integer) fields[0];
        this.name = (String) fields[1];
        this.value = (String) fields[2];
        this.makerId = (Integer) fields[3];
        this.editorId = (Integer) fields[4];
        this.makeDate = (Timestamp) fields[5];
        this.editDate = (Timestamp) fields[6];
    }
}
