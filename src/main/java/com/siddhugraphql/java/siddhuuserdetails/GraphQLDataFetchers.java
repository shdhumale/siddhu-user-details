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

	/*@Autowired
	com.siddhugraphql.java.siddhuuserdetails.resolvers.Subscription  objSubscription;
*/
	/*@Autowired
	com.siddhugraphql.java.siddhuuserdetails.resolvers.UserSubscription objUserSubscription;
*/
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

		/*	users.add(objMap1);
		users.add(objMap2);
		users.add(objMap3);*/

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

		/*address.add(objMap1);
		address.add(objMap2);
		address.add(objMap3);*/

		address = Arrays.asList(objMap1, objMap2, objMap3);
		return address;
	}

	private void addAddressList(Map<String, String> objMap) {
		address.add(objMap);		
		address = Arrays.asList(objMap);

	}

	/*@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    MappingJackson2HttpMessageConverter converter = 
	        new MappingJackson2HttpMessageConverter(mapper);
	    return converter;
	}*/

	/* private static List<Map<String, String>> users = Arrays.asList(
            ImmutableMap.of("id", "sid-1",
                    "name", "Siddharatha dhumale 1",
                    "age", "1",
                    "addressId", "address-1"),
            ImmutableMap.of("id", "sid-1",
                    "name", "Siddharatha dhumale 2",
                    "age", "2",
                    "addressId", "address-2"),
            ImmutableMap.of("id", "sid-3",
                    "name", "Siddharatha dhumale 3",
                    "age", "3",
                    "addressId", "address-3")
    );*/

	/* private static List<Map<String, String>> address = Arrays.asList(
            ImmutableMap.of("id", "address-1",
                    "houseName", "Siddharatha Dhumale House Name 1",
                    "country", "Australia"),
            ImmutableMap.of("id", "address-2",
                    "houseName", "Siddharatha Dhumale House Name 2",
                    "country", "UK"),
            ImmutableMap.of("id", "address-3",
                    "houseName", "Siddharatha Dhumale House Name 3",
                    "country", "India")
    );*/

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
			/*Map<String, String> objMap4 = new HashMap();
			objMap4.put("id", "sid-4");
			objMap4.put("name", name);
			objMap4.put("age", ""+age);
			objMap4.put("addressId", "address-4");    
			
			users = Arrays.asList(objMap4);
			return users
					.stream()
					.filter(user -> user.get("id").equals("sid-4"))
					.findFirst()
					.orElse(null);*/
			objUser = new com.siddhugraphql.java.siddhuuserdetails.resolvers.User("sid-41",name,age);
			
			//UserPublisher objStockTickerPublisher =  new UserPublisher(objUser);
			//objStockTickerPublisher.setUser(objUser);
			return objUser;
		};

	}    
	//by siddhu for Mutaion end]

	//by siddhu for Subscription start[
	/*public DataFetcher newUserDataFetcher() {
    	System.out.println("here reached newUserDataFetcher ............");
    	 return dataFetchingEnvironment -> {
    		 //String userId = dataFetchingEnvironment.getArgument("id");
    		 System.out.println("here reached userId newUserDataFetcher ............");
             return getUserList()
                     .stream()
                     .filter(user -> user.get("id").equals("sid-1"))
                     .findFirst()
                     .orElse(null);
    		 //return users;
    	 };
    }*/

	/*public DataFetcher stockQuotesDataFetcher() {
		System.out.println("here reached stockQuotesDataFetcher ............");
		return dataFetchingEnvironment -> {

			System.out.println("here reached userId stockQuotesDataFetcher ............");
			List<String> stockCodes =  new ArrayList<>();
			stockCodes.add("IBM");
			return objSubscription.stockQuotes(stockCodes);	
		};
	}    
*/
	/*public DataFetcher newUserDataFetcher() {
		return dataFetchingEnvironment -> {
			//String userId = dataFetchingEnvironment.getArgument("id");			
			System.out.println("here reached userId newUserDataFetcher ............");
			//return objUserSubscription.newUser();
			SiddhuGraphqlPublisher objSiddhuGraphqlPublisher =  new SiddhuGraphqlPublisher();
			return objSiddhuGraphqlPublisher.stockQuotesSubscriptionFetcher();
			
		};
	}*/


	//by siddhu for Subscription end]

}
