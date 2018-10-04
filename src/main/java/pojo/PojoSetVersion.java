package pojo;

import java.sql.Timestamp;

public class PojoSetVersion {
    private Integer id;
    private Integer setId;
    private Timestamp startDate;
    private Double setValue;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoSetVersion(Integer id, Integer setId, Timestamp startDate, Double setValue, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        init(id, setId, startDate, setValue, makerId, editorId, makeDate, editDate);
    }

    public PojoSetVersion(Object[] fields) {
        init(fields);
    }

    public PojoSetVersion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Double getSetValue() {
        return setValue;
    }

    public void setSetValue(Double setValue) {
        this.setValue = setValue;
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

    public void init(Integer id, Integer setId, Timestamp startDate, Double setValue, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        this.id = id;
        this.setId = setId;
        this.startDate = startDate;
        this.setValue = setValue;
        this.makerId = makerId;
        this.editorId = editorId;
        this.makeDate = makeDate;
        this.editDate = editDate;
    }

    public void init(Object[] fields) {
        boolean isNull = fields == null;

        this.id = isNull ? null : (Integer) fields[0];
        this.setId = isNull ? null : (Integer) fields[1];
        this.startDate = isNull ? null : (Timestamp) fields[2];
        this.setValue = isNull ? null : (Double) fields[3];
        this.makerId = isNull ? null : (Integer) fields[4];
        this.editorId = isNull ? null : (Integer) fields[5];
        this.makeDate = isNull ? null : (Timestamp) fields[6];
        this.editDate = isNull ? null : (Timestamp) fields[7];
    }
}
