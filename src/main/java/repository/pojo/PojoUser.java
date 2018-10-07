package repository.pojo;

import utils.errors.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class PojoUser {
    private Integer id;
    private String login;
    private String md5Passw;
    private String nick;
    private Integer makerId;
    private Integer editorId;
    private Timestamp makeDate;
    private Timestamp editDate;

    public PojoUser(Object... fields) {
        init(fields);
    }

    public PojoUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMd5Passw() {
        return md5Passw;
    }

    public void setMd5Passw(String md5Passw) {
        this.md5Passw = md5Passw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
        this.login = (String) fields[1];
        this.md5Passw = (String) fields[2];
        this.nick = (String) fields[3];
        this.makerId = (Integer) fields[4];
        this.editorId = (Integer) fields[5];
        this.makeDate = (Timestamp) fields[6];
        this.editDate = (Timestamp) fields[7];
    }

    @Override
    public String toString() {
        return "PojoUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", md5Passw='" + md5Passw + '\'' +
                ", nick='" + nick + '\'' +
                ", makerId=" + makerId +
                ", editorId=" + editorId +
                ", makeDate=" + makeDate +
                ", editDate=" + editDate +
                '}';
    }
}
