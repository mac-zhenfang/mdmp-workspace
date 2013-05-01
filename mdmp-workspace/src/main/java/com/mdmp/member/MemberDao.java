/**
 * 
 */
package com.mdmp.member;

import java.util.List;

/**
 * @author zhefang
 *
 */
public interface MemberDao {
	
	public Member create(Member member);
	
	public Member get(String memberId);
	
	public List<Member> listMemberByOrg(String orgId);
	
	public Member update(Member member);
	
	public void remove(String memberId);
}
