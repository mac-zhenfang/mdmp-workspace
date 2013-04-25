/**
 * 
 */
package com.mdmp.data;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * @author zhefang
 *
 */
public class UserDaoImpl implements UserDao {
	
	MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(ObjectId arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(ObjectId arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll(Iterable<ObjectId> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(ObjectId arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(user);
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, User.class);
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(User.class);
	}
	
	public List<User> findUser(long startUserId, long endId){
		return mongoTemplate.find(new Query(Criteria.where("userid").gte(startUserId).lte(endId)), User.class);
	}

}
