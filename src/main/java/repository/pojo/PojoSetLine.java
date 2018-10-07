package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class PojoSetLine {
    private Integer id;
    private Integer versionId;
    private Integer goodsId;
    private Integer setId;
    private Integer params;
    private Double value1;
    private Double value2;
    private Double value3;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoSetLine(Object... fields) {
        init(fields);
    }

    public PojoSetLine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Integer getParams() {
        return params;
    }

    public void setParams(Integer params) {
        this.params = params;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public Double getValue3() {
        return value3;
    }

    public void setValue3(Double value3) {
        this.value3 = value3;
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
        if (fields == null || fields.length != 12) throw new InvalidNumberOfArgumentsException();

        this.id = (Integer) fields[0];
        this.versionId = (Integer) fields[1];
        this.goodsId = (Integer) fields[2];
        this.setId = (Integer) fields[3];
        this.params = (Integer) fields[4];
        this.value1 = (Double) fields[5];
        this.value2 = (Double) fields[6];
        this.value3 = (Double) fields[7];
        this.makerId = (Integer) fields[8];
        this.editorId = (Integer) fields[9];
        this.makeDate = (Timestamp) fields[10];
        this.editDate = (Timestamp) fields[11];
    }
}
