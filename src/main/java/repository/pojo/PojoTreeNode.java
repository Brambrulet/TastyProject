package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class PojoTreeNode {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer nodeType;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoTreeNode(Object... fields) {
        init(fields);
    }

    public PojoTreeNode() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
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
        this.parentId = (Integer) fields[1];
        this.name = (String) fields[2];
        this.nodeType = (Integer) fields[3];
        this.makerId = (Integer) fields[4];
        this.editorId = (Integer) fields[5];
        this.makeDate = (Timestamp) fields[6];
        this.editDate = (Timestamp) fields[7];
    }
}
