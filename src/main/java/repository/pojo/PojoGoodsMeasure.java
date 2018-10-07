package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

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

    public PojoGoodsMeasure(Object ... fields) {
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

    public void init(Object ... fields) {
        if (fields == null || fields.length != 8) throw new InvalidNumberOfArgumentsException();

        this.goodsId = (Integer) fields[0];
        this.measureId = (Integer) fields[1];
        this.primary = (Boolean) fields[2];
        this.k = (Double) fields[3];
        this.makerId = (Integer) fields[4];
        this.editorId = (Integer) fields[5];
        this.makeDate = (Timestamp) fields[6];
        this.editDate = (Timestamp) fields[7];
    }
}
