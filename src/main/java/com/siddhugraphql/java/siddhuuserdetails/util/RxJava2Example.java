package com.siddhugraphql.java.siddhuuserdetails.util;
import com.siddhugraphql.java.siddhuuserdetails.resolvers.User;

import io.reactivex.Observable;
 
public class RxJava2Example
{
      public static void main(String[] args)
      {    
    	   User obj = new User("One","two",3);
            //producer
            Observable<User> observable = Observable.just(obj);
 
            //consumer
            //Consumer<? super String> consumer = System.out::println;
            SiddhuConsumer objSiddhuConsumer = new SiddhuConsumer();
            //Attaching producer to consumer
            observable.subscribe(objSiddhuConsumer);
      }
}