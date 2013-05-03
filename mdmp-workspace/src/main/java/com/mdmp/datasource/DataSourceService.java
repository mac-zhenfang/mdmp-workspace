package com.mdmp.datasource;

import java.util.List;

public interface DataSourceService {

	public DataSource create(DataSource dataSource);

	public DataSource get(String id);

	public List<DataSource> listDataSourceByApp(String appId);

}
