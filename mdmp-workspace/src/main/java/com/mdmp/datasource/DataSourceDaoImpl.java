package com.mdmp.datasource;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

@Service("dataSourceDao")
public class DataSourceDaoImpl extends SqlSessionDaoSupport implements
		DataSourceDao {

	@Override
	public void create(DataSource ds) {
		getSqlSession().insert("DataSource.create", ds);
	}

	@Override
	public DataSource get(String dsId) {
		return getSqlSession().selectOne("DataSource.get", dsId);
	}

	@Override
	public List<DataSource> listDataSourceByApp(String appId) {
		return getSqlSession().selectList("DataSource.listDataSourceByApp", appId);
	}

	@Override
	public void update(DataSource ds) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(String dsId) {
		// TODO Auto-generated method stub
	}
}
