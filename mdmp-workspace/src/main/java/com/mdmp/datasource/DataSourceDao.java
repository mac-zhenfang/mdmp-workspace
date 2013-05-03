package com.mdmp.datasource;

import java.util.List;

public interface DataSourceDao {
	/**
	 * Create a new DataSource
	 * @param ds
	 */
	public void create(DataSource ds);

	/**
	 * @param dsId
	 * @return DataSource
	 */
	public DataSource get(String dsId);

	public List<DataSource> listDataSourceByApp(String appId);

	public void update(DataSource ds);

	public void remove(String dsId);
}
