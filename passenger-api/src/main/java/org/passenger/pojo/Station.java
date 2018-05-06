package org.passenger.pojo;

public class Station {
    private String id;

    private String name;

    private String code;

    private String pinyin;

    private String sanzima;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSanzima() {
        return sanzima;
    }

    public void setSanzima(String sanzima) {
        this.sanzima = sanzima;
    }
}