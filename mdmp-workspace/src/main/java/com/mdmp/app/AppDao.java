/**
 * 
 */
package com.mdmp.app;

import java.util.List;

/**
 * @author zhefang
 *
 */
public interface AppDao {
	
	public void create(App app);
	
	public App get(String appId);
	
	public List<App> listAppByMember(String memberId);

	public List<App> listAppByOrg(String orgId);
	
	public void update (App app);
	
	public void remove(String appId);
}
