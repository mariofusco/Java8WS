package mf.java8ws.talk.example13;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll"),
                                                   new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });


    public List<String> findPriceSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getName() + " price is " + shop.getPriceFor(product))
                .collect(Collectors.<String>toList());
    }

    public List<String> findPriceParallel(String product) {
        return null;
    }

    public List<String> findPrice(String product) {
        return null;
    }
}
