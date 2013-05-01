/**
 * 
 */
package com.mdmp.model;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhefang
 * 
 */
@Service("modelService")
public class ModelServiceImpl implements ModelService {

	@Resource(name = "modelDao")
	private ModelDao modelDao;

	@Transactional
	@Override
	public Model create(Model model) {
		model.setId(UUID.randomUUID().toString());
		modelDao.create(model);
		return model;
	}

	@Override
	public Model get(String modelId) {
		return modelDao.get(modelId);
	}

	@Override
	public List<Model> listModelByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model update(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String modelId) {
		// TODO Auto-generated method stub

	}

}
