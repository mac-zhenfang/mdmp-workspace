package com.mdmp.util;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {
	public Pagination() {
	}

	public Pagination(List<T> entries) {
		this.entries = entries;
		if (entries == null) {
			this.entries = new ArrayList<T>();
		}
		this.totalCount = this.entries.size();
	}

	private int totalCount;
	private List<T> entries;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getEntries() {
		return entries;
	}

	public void setEntries(List<T> entries) {
		this.entries = entries;
	}
}
