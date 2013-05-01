/**
 * 
 */
package com.mdmp.member;


/**
 * @author zhefang
 *
 */
public class Member {
	//id, name, oid, role, createdTime
	
	private String id;

	private String name;

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

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	private String oid;
	
	private String role;

	private String createdTime;
	
	public final Member clone() {
		try {
			return (Member) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
