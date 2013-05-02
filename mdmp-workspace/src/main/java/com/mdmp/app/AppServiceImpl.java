/**
 * 
 */
package com.mdmp.app;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author zhefang
 * 
 */
@Service("appService")
public class AppServiceImpl implements AppService {

	@Resource(name = "appDao")
	private AppDao appDao;

	@Override
	public App create(App app) {
		// TODO verification
		app.setId(UUID.randomUUID().toString());
		appDao.create(app);
		return app;
	}

	@Override
	public App get(String appId) {
		// TODO Auto-generated method stub
		return appDao.get(appId);
	}

	@Override
	public List<App> listAppByMember(String memberId) {
		// TODO Auto-generated method stub
		return appDao.listAppByMember(memberId);
	}

	@Override
	public List<App> listAppByOrg(String orgId) {
		// TODO Auto-generated method stub
		return appDao.listAppByOrg(orgId);
	}

}
