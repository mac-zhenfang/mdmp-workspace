/**
 * 
 */
package com.mdmp.app;

import java.util.List;

/**
 * @author zhefang
 *
 */
public interface AppService {
	
	public App create(App app);
	
	public App get(String appId);
	
	public List<App> listAppByMember(String memberId);
	
	public List<App> listAppByOrg(String orgId);
}
