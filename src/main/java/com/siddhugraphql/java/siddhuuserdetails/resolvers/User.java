package com.siddhugraphql.java.siddhuuserdetails.resolvers;


public class User {
	
	 public User(String id, String name, int age) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	    }
	  

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [age=" + age + ", id=" + id + ", name=" + name + "]";
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	

	private final String id;
    private final String name;
    private final int age;
   
   
}
