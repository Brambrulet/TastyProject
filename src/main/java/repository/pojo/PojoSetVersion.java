package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

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

    public PojoSetVersion(Object... fields) {
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

    public void init(Object... fields) {
        if (fields == null || fields.length != 8) throw new InvalidNumberOfArgumentsException();

        this.id = (Integer) fields[0];
        this.setId = (Integer) fields[1];
        this.startDate = (Timestamp) fields[2];
        this.setValue = (Double) fields[3];
        this.makerId = (Integer) fields[4];
        this.editorId = (Integer) fields[5];
        this.makeDate = (Timestamp) fields[6];
        this.editDate = (Timestamp) fields[7];
    }
}
