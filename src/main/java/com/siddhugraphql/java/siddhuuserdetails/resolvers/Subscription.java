package com.siddhugraphql.java.siddhuuserdetails.resolvers;
import java.util.List;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.siddhugraphql.java.siddhuuserdetails.publishers.StockTickerPublisher;

//@Component
public class Subscription implements GraphQLSubscriptionResolver {

    private StockTickerPublisher stockTickerPublisher;

    public Subscription(StockTickerPublisher stockTickerPublisher) {
        this.stockTickerPublisher = stockTickerPublisher;
    }

    /*public  Publisher<StockPriceUpdate> stockQuotes(List<String> stockCodes) {
        return stockTickerPublisher.getPublisher(stockCodes);
    }*/
    
    public  Publisher<StockPriceUpdate> stockQuotes(List<String> stockCodes) {
        return stockTickerPublisher.getPublisher(stockCodes);
    }

}
