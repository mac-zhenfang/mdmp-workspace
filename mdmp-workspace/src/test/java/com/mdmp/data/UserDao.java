/**
 * 
 */
package com.mdmp.data;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @author zhefang
 * 
 */
public interface UserDao extends MongoRepository<User, ObjectId> {
	
	public void addUser(User user);
	
	public User getUser(String id);
	
	public List<User> listUsers();
	
	public List<User> findUser(long startUserId, long endId);

}
