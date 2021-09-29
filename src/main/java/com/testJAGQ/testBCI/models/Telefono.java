package com.testJAGQ.testBCI.models;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Telefono {
	
	@Id
	private short number;
	
	private short citycode;
	private short contrycode;
	
	public short getNumber() {
		return number;
	}
	public void setNumber(short number) {
		this.number = number;
	}
	public short getCitycode() {
		return citycode;
	}
	public void setCitycode(short citycode) {
		this.citycode = citycode;
	}
	public short getContrycode() {
		return contrycode;
	}
	public void setContrycode(short contrycode) {
		this.contrycode = contrycode;
	}
	
	@Override
    public String toString() {
        return 	"{" +
                "\"number\":\"" + number + "\"" +
                ", \"citycode\":\"" + citycode + "\"" +
                ", \"contrycode\":\"" + contrycode + "\"" +
                "}";
    }
	
}
