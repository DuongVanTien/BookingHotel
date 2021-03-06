package vn.framgia.model;

import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
@SuppressWarnings("serial")
public class User implements Serializable{
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;
    private String role;

    public User() {
    	super();
    }

    public User(Integer id, String username, String password, String fullname,
                String email, String phone, String role) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }
    
    public User(Integer id) {
		this.id = id;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
