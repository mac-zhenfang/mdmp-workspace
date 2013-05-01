/**
 * 
 */
package com.mdmp.org;

import java.util.List;

/**
 * @author zhefang
 *
 */
public interface OrgDao {
	
	public Org create(Org org);
	
	public Org get(String orgId);
	
	public List<Org> list();
	
	public Org update(Org org);
	
	public void remove(String orgId);
}
