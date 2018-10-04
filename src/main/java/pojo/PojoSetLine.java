package pojo;

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

    public PojoSetLine(Object[] fields) {
        init(fields);
    }

    public PojoSetLine() {
    }

    public PojoSetLine(Integer id, Integer versionId, Integer goodsId, Integer setId, Integer params, Double value1, Double value2, Double value3, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        init(id, versionId, goodsId, setId, params, value1, value2, value3, makerId, editorId, makeDate, editDate);
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

    public void init(Integer id, Integer versionId, Integer goodsId, Integer setId, Integer params, Double value1, Double value2, Double value3, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        this.id = id;
        this.versionId = versionId;
        this.goodsId = goodsId;
        this.setId = setId;
        this.params = params;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.makerId = makerId;
        this.editorId = editorId;
        this.makeDate = makeDate;
        this.editDate = editDate;
    }

    public void init(Object[] fields) {
        boolean isNull = fields == null;

        this.id = isNull ? null : (Integer) fields[0];
        this.versionId = isNull ? null : (Integer) fields[1];
        this.goodsId = isNull ? null : (Integer) fields[2];
        this.setId = isNull ? null : (Integer) fields[3];
        this.params = isNull ? null : (Integer) fields[4];
        this.value1 = isNull ? null : (Double) fields[5];
        this.value2 = isNull ? null : (Double) fields[6];
        this.value3 = isNull ? null : (Double) fields[7];
        this.makerId = isNull ? null : (Integer) fields[8];
        this.editorId = isNull ? null : (Integer) fields[9];
        this.makeDate = isNull ? null : (Timestamp) fields[10];
        this.editDate = isNull ? null : (Timestamp) fields[11];
    }
}
