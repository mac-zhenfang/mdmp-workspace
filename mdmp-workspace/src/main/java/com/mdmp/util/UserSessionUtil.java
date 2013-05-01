package com.mdmp.util;

import com.mdmp.member.Member;

public class UserSessionUtil {
	private static ThreadLocal<Member> localUser = new ThreadLocal<Member>();
	//set the user by servlet filter
	public static void setUser(Member user){
		localUser.set(user);
	}

	public static Member getUser(){
		return localUser.get();
	}
}
