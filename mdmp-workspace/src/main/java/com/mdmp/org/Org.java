package com.mdmp.org;


/**
 * @author zhefang
 *
 */
public class Org implements Cloneable {
	// id, name, description, createdTime

	private String id;

	private String name;

	private String description;

	private String createdTime;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public final Org clone() {
		try {
			return (Org) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
