package pojo;

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

    public PojoMeasure(Integer id, String name, Byte kind, Boolean primary, Double baseK, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        init(id, name, kind, primary, baseK, makerId, editorId, makeDate, editDate);
    }

    public PojoMeasure(Object[] fields) {
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

    public void init(Integer id, String name, Byte kind, Boolean primary, Double baseK, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.primary = primary;
        this.baseK = baseK;
        this.makerId = makerId;
        this.editorId = editorId;
        this.makeDate = makeDate;
        this.editDate = editDate;
    }

    public void init(Object[] fields) {
        boolean isNull = fields == null;

        this.id = isNull ? null : (Integer) fields[0];
        this.name = isNull ? null : (String) fields[1];
        this.kind = isNull ? null : (Byte) fields[2];
        this.primary = isNull ? null : (Boolean) fields[3];
        this.baseK = isNull ? null : (Double) fields[4];
        this.makerId = isNull ? null : (Integer) fields[5];
        this.editorId = isNull ? null : (Integer) fields[6];
        this.makeDate = isNull ? null : (Timestamp) fields[7];
        this.editDate = isNull ? null : (Timestamp) fields[8];
    }
}
