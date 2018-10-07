package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class PojoSet {
    private Integer id;
    private String name;
    private Integer nodeId;
    private Integer measureId;
    private Boolean singleton;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoSet() {
    }

    public PojoSet(Object... fields) {
        init(fields);
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

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    public Boolean getSingleton() {
        return singleton;
    }

    public void setSingleton(Boolean singleton) {
        this.singleton = singleton;
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
        this.nodeId = (Integer) fields[2];
        this.measureId = (Integer) fields[3];
        this.singleton = (Boolean) fields[4];
        this.makerId = (Integer) fields[5];
        this.editorId = (Integer) fields[6];
        this.makeDate = (Timestamp) fields[7];
        this.editDate = (Timestamp) fields[8];
    }
}
