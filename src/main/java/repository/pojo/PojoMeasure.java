package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class PojoMeasure {
    private Integer id;
    private String name;
    private Byte kind;
    private Boolean primary;
    private Double baseK;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoMeasure(Object... fields) {
        init(fields);
    }

    public PojoMeasure() {
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

    public Byte getKind() {
        return kind;
    }

    public void setKind(Byte kind) {
        this.kind = kind;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Double getBaseK() {
        return baseK;
    }

    public void setBaseK(Double baseK) {
        this.baseK = baseK;
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
        if (fields == null || fields.length != 9) throw new InvalidNumberOfArgumentsException();

        this.id = (Integer) fields[0];
        this.name = (String) fields[1];
        this.kind = (Byte) fields[2];
        this.primary = (Boolean) fields[3];
        this.baseK = (Double) fields[4];
        this.makerId = (Integer) fields[5];
        this.editorId = (Integer) fields[6];
        this.makeDate = (Timestamp) fields[7];
        this.editDate = (Timestamp) fields[8];
    }
}
