package pojo;

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

    public PojoSet(Object[] fields) {
        init(fields);
    }

    public PojoSet(Integer id, String name, Integer nodeId, Integer measureId, Boolean singleton, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        init(id, name, nodeId, measureId, singleton, makerId, editorId, makeDate, editDate);
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

    public void init(Integer id, String name, Integer nodeId, Integer measureId, Boolean singleton, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        this.id = id;
        this.name = name;
        this.nodeId = nodeId;
        this.measureId = measureId;
        this.singleton = singleton;
        this.makerId = makerId;
        this.editorId = editorId;
        this.makeDate = makeDate;
        this.editDate = editDate;
    }

    public void init(Object[] fields) {
        boolean isNull = fields == null;

        this.id = isNull ? null : (Integer) fields[0];
        this.name = isNull ? null : (String) fields[1];
        this.nodeId = isNull ? null : (Integer) fields[2];
        this.measureId = isNull ? null : (Integer) fields[3];
        this.singleton = isNull ? null : (Boolean) fields[4];
        this.makerId = isNull ? null : (Integer) fields[5];
        this.editorId = isNull ? null : (Integer) fields[6];
        this.makeDate = isNull ? null : (Timestamp) fields[7];
        this.editDate = isNull ? null : (Timestamp) fields[8];
    }

}
