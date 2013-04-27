/**
 * 
 */
package com.mdmp.model;

import java.util.List;

/**
 * @author zhefang
 *
 */
public interface ModelDao {
	
	
	public List<Model> listReportByUser(String userId);
	
	public void create(Model model);
	
	public void remove(String modelId);
	
	public void update(Model model);
	
	public Model get(String modelId);
}
