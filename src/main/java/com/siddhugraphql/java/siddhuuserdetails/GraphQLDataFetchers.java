package com.siddhugraphql.java.siddhuuserdetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siddhugraphql.java.siddhuuserdetails.publishers.UserPublisher;

import graphql.GraphQL;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {
	
	public com.siddhugraphql.java.siddhuuserdetails.resolvers.User objUser;

	List<Map<String, String>> users =  new ArrayList<>();
	List<Map<String, String>> address =  new ArrayList<>();
	private GraphQL graphQL;

	
	private List<Map<String, String>> getUserList()
	{
		Map<String, String> objMap1 = new HashMap();
		objMap1.put("id", "sid-1");
		objMap1.put("name", "Siddharatha dhumale 1");
		objMap1.put("age", "1");
		objMap1.put("addressId", "address-1");

		Map<String, String> objMap2 = new HashMap();
		objMap2.put("id", "sid-2");
		objMap2.put("name", "Siddharatha dhumale 2");
		objMap2.put("age", "2");
		objMap2.put("addressId", "address-2");

		Map<String, String> objMap3 = new HashMap();
		objMap3.put("id", "sid-3");
		objMap3.put("name", "Siddharatha dhumale 3");
		objMap3.put("age", "3");
		objMap3.put("addressId", "address-3");

	
		users = Arrays.asList(objMap1, objMap2, objMap3);
		return users;
	}

	private void addUserList(Map<String, String> objMap) {
		users.add(objMap);		
		users = Arrays.asList(objMap);		
	}

	private List<Map<String, String>> getAddressList()
	{
		Map<String, String> objMap1 = new HashMap();
		objMap1.put("id", "address-1");
		objMap1.put("houseName", "Siddharatha Dhumale House Name 1");
		objMap1.put("country", "Australia");

		Map<String, String> objMap2 = new HashMap();
		objMap2.put("id", "address-2");
		objMap2.put("houseName", "Siddharatha Dhumale House Name 2");
		objMap2.put("country", "UK");

		Map<String, String> objMap3 = new HashMap();
		objMap3.put("id", "address-3");
		objMap3.put("houseName", "Siddharatha Dhumale House Name 3");
		objMap3.put("country", "India");

		address = Arrays.asList(objMap1, objMap2, objMap3);
		return address;
	}

	private void addAddressList(Map<String, String> objMap) {
		address.add(objMap);		
		address = Arrays.asList(objMap);

	}

	

	public DataFetcher getUserByIdDataFetcher() {    	
		return dataFetchingEnvironment -> {
			String userId = dataFetchingEnvironment.getArgument("id");            
			System.out.println("here reached..userId.........."+userId);
			return getUserList()
					.stream()
					.filter(user -> user.get("id").equals(userId))
					.findFirst()
					.orElse(null);
		};
	}
	public DataFetcher getUserDataFetcher() {    	
		return dataFetchingEnvironment -> {
			Map<String, String> user = dataFetchingEnvironment.getSource();
			String addressId = user.get("addressId");
			return getAddressList()
					.stream()
					.filter(address -> address.get("id").equals(addressId))
					.findFirst()
					.orElse(null);
		};
	}

	//by siddhu for Mutation start[
	public DataFetcher createUserDataFetcher() {
		System.out.println("here reached............");

		return dataFetchingEnvironment -> {
			String name = dataFetchingEnvironment.getArgument("name");
			System.out.println("here reached..name.........."+name);
			int age = dataFetchingEnvironment.getArgument("age");
			System.out.println("here reached..age.........."+""+age);
			objUser = new com.siddhugraphql.java.siddhuuserdetails.resolvers.User("sid-41",name,age);
			SiddhuGraphqlPublisher.STOCK_TICKER_PUBLISHER.publish(objUser);
			return objUser;
		};

	}    
	//by siddhu for Mutaion end]

	
	public DataFetcher newUserDataFetcher() {
		return dataFetchingEnvironment -> {
			//String userId = dataFetchingEnvironment.getArgument("id");			
			System.out.println("here reached userId newUserDataFetcher ............");
			//return objUserSubscription.newUser();
			SiddhuGraphqlPublisher objSiddhuGraphqlPublisher =  new SiddhuGraphqlPublisher();
			return objSiddhuGraphqlPublisher.stockQuotesSubscriptionFetcher();
			
		};
	}


	//by siddhu for Subscription end]

}
