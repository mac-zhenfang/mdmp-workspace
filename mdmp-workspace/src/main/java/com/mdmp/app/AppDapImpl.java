/**
 * 
 */
package com.mdmp.app;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.mdmp.app.AppDao;

/**
 * @author zhefang
 * 
 */
@Service("appDao")
public class AppDapImpl extends SqlSessionDaoSupport implements AppDao {

	@Override
	public void create(App app) {
		getSqlSession().insert("App.create", app);
	}

	@Override
	public App get(String appId) {
		return getSqlSession().selectOne("App.get", appId);
	}

	@Override
	public List<App> listAppByMember(String memberId) {
		return getSqlSession().selectList("App.listAppByMember", memberId);
	}

	@Override
	public List<App> listAppByOrg(String orgId) {
		return getSqlSession().selectList("App.listAppByOrg", orgId);
	}

	@Override
	public void update(App app) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(String appId) {
		// TODO Auto-generated method stub

	}

}
