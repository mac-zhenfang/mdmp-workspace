/**
 * 
 */
package com.mdmp.model;

import java.util.List;

/**
 * @author zhefang
 * 
 */
public interface ModelService {

	public Model create(Model model);
	
	public Model get(String modelId);
	
	public List<Model> listModelByUser(String userId);
	
	public Model update(Model model);
	
	public void remove(String modelId);
}
