package org.passenger.pojo;

public class Station {
    private String id;

    private String name;

    private String code;
    
    private String pinYin;
    
    private String sanZiMa;

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

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

	public String getSanZiMa() {
		return sanZiMa;
	}

	public void setSanZiMa(String sanZiMa) {
		this.sanZiMa = sanZiMa;
	}
    
}