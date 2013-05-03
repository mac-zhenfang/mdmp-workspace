package com.mdmp.datasource;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {
	@Resource(name = "dataSourceDao")
	private DataSourceDao dsDAO;
	
	@Override
	public DataSource create(DataSource dataSource) {
		dataSource.setId(UUID.randomUUID().toString());
		dsDAO.create(dataSource);
		return get(dataSource.getId());
	}

	@Override
	public DataSource get(String id) {
		return dsDAO.get(id);
	}

	@Override
	public List<DataSource> listDataSourceByApp(String appId) {
		return dsDAO.listDataSourceByApp(appId);
	}

}
