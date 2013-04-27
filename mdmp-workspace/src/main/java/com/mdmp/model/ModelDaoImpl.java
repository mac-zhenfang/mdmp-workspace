/**
 * 
 */
package com.mdmp.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

/**
 * @author zhefang
 *
 */
@Service("modelDao")
public class ModelDaoImpl  extends SqlSessionDaoSupport implements ModelDao{

	@Override
	public List<Model> listReportByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public void create(Model model) {
		// TODO Auto-generated method stub
		getSqlSession().insert("Model.create", model);
	}

	@Override
	public void remove(String modelId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Model get(String modelId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("Model.get", modelId);
	}

}
