package com.mdmp.dashboard;

/**
 * @author zhefang
 *
 */
public class Dashboard implements Cloneable {
	//id, name, aid, description, createdTime

	// id, name, aid, description, createdTime
	private String id;

	private String name;

	private String aid;

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

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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

	public final Dashboard clone() {
		try {
			return (Dashboard) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
