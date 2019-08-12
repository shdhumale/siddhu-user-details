package com.siddhugraphql.java.siddhuuserdetails.util;

import com.siddhugraphql.java.siddhuuserdetails.resolvers.User;

import io.reactivex.functions.Consumer;

public class SiddhuConsumer implements Consumer<User> {

	@Override
	public void accept(User t) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------------"+t.toString());
	}
	
	

}
