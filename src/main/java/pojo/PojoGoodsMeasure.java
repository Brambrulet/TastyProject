package pojo;

import java.sql.Timestamp;

public class PojoGoodsMeasure {
    private Integer goodsId;
    private Integer measureId;
    private Boolean primary;
    private Double k;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoGoodsMeasure(Integer goodsId, Integer measureId, Boolean primary, Double k, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        init(goodsId, measureId, primary, k, makerId, editorId, makeDate, editDate);
    }

    public PojoGoodsMeasure(Object[] fields) {
        init(fields);
    }

    public PojoGoodsMeasure() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
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

    public void init(Integer goodsId, Integer measureId, Boolean primary, Double k, Integer makerId, Integer editorId, Timestamp makeDate, Timestamp editDate) {
        this.goodsId = goodsId;
        this.measureId = measureId;
        this.primary = primary;
        this.k = k;
        this.makerId = makerId;
        this.editorId = editorId;
        this.makeDate = makeDate;
        this.editDate = editDate;
    }

    public void init(Object[] fields) {
        boolean isNull = fields == null;

        this.goodsId = isNull ? null : (Integer) fields[0];
        this.measureId = isNull ? null : (Integer) fields[1];
        this.primary = isNull ? null : (Boolean) fields[2];
        this.k = isNull ? null : (Double) fields[3];
        this.makerId = isNull ? null : (Integer) fields[4];
        this.editorId = isNull ? null : (Integer) fields[5];
        this.makeDate = isNull ? null : (Timestamp) fields[6];
        this.editDate = isNull ? null : (Timestamp) fields[7];
    }
}
