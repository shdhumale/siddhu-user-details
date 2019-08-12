package com.siddhugraphql.java.siddhuuserdetails.publishers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.siddhugraphql.java.siddhuuserdetails.resolvers.User;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

@Component
public class UserPublisher {

	private static final Logger LOG = LoggerFactory.getLogger(UserPublisher.class);

	public  Flowable<User> publisher;
	static int i = 0;
	public User objUser, objUser1 = new User("UserPublisher","UserPublishernmame",1);
	public boolean flag = false;

	private ObservableEmitter<User> emitter;

	//public static ObservableList<User> observableList = new ObservableList<>();

	/*
    private static final UserPublisher instance = new UserPublisher();

    public static UserPublisher getInstance(){
        return instance;
    }    

	 */  
	public void setUser(User user)
	{
		flag = true;
		this.objUser = user;
	}

	public User getUser()
	{
		return this.objUser;
	}

	public UserPublisher(){

	Observable<User> commentUpdateObservable = Observable.create(emitter -> {
			this.emitter = emitter;
		});

		ConnectableObservable<User> connectableObservable = commentUpdateObservable.share().publish();
		connectableObservable.connect();


		publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	}



	/*public void emitEvent(User objUser)
	{
		Observable<User> stockPriceUpdateObservable = Observable.create(emitter -> {

			ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
			executorService.scheduleAtFixedRate(newStockTick(emitter, objUser), 0, 2, TimeUnit.MILLISECONDS);

		});

		//ConnectableObservable<User> connectableObservable = observableList.getObservable().share().publish();
		ConnectableObservable<User> connectableObservable = stockPriceUpdateObservable.share().publish();
		connectableObservable.connect();
		publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);   
	}
	public  Runnable newStockTick(ObservableEmitter<User> emitter) {
		System.out.println("Inside newStockTick");
		return () -> {
			List<User> userUpdate = new ArrayList<>();
			i = i + 1;
			if(flag)
			{
				System.out.println("Inside if(flag) XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				objUser = this.getUser(); 
			}
			else
			{
				System.out.println("Inside else >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				objUser = new User("Sid hard code ["+i+"]", "sid dhu", 5);

			}
			//objUser = new User("Sid hard code ["+i+"]", "sid dhu", 5);
			userUpdate.add(objUser);   
			System.out.println("Inside newStockTick emitStocks");
			emitStocks(emitter, userUpdate);

		};
	}
	public  Runnable newStockTick(ObservableEmitter<User> emitter, User objUser) {
		System.out.println("Inside newStockTick");
		return () -> {
			List<User> userUpdate = new ArrayList<>();
			System.out.println("newStockTick XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			userUpdate.add(objUser);   
			System.out.println("Inside newStockTick emitStocks");
			emitStocks(emitter, userUpdate);

		};
	}

	private void emitStocks(ObservableEmitter<User> emitter, List<User> userUpdates) {
		for (User userUpdate : userUpdates) {
			try {
				System.out.println("Inside emitStocks onNext");
				emitter.onNext(userUpdate);
			} catch (RuntimeException e) {
				LOG.error("Cannot send StockUpdate", e);
			}
		}
	}*/

	public Flowable<User> getPublisher() {
		return publisher;
	}
	
	public void publish(final User user) {
		emitter.onNext(user);
	}



}
