package com.siddhugraphql.java.siddhuuserdetails.resolvers;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.siddhugraphql.java.siddhuuserdetails.publishers.UserPublisher;

@Component
public class UserSubscription implements GraphQLSubscriptionResolver {

    private UserPublisher userPublisher;

    public UserSubscription(UserPublisher userPublisher) {
        this.userPublisher = userPublisher;
    }

    public  Publisher<User> newUser() {
        return userPublisher.getPublisher();
    }

}
