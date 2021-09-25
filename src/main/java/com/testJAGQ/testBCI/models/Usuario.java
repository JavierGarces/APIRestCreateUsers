package com.testJAGQ.testBCI.models;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class Usuario {
	
	private String id;
	private String email;
	private String name;
	private String password;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private Boolean isactive;
	
	private List<Telefono> phones;
	
	public Usuario() {
		this.setId("");
		this.setCreated((Date)Calendar.getInstance().getTime());
		this.setModified((Date)Calendar.getInstance().getTime());
		this.setLast_login((Date)Calendar.getInstance().getTime());
		this.setToken("");
		this.setIsactive(true);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public List<Telefono> getPhones() {
		return phones;
	}
	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}
	
	@Override
    public String toString() {
        return 	"'id':'" + id + "'"+
                ", 'name':'" + name + "'"+
                ", 'email':'" + email + "'" +
                ", 'created':'" + created + "'" +
                ", 'modified':'" + modified + "'" +
                ", 'last_login':'" + last_login + "'" +
                ", 'token':'" + token + "'" +
                ", 'isactive':'" + isactive + "'" +
                ", 'phones':[" + phones + "]";
    }
	
}
