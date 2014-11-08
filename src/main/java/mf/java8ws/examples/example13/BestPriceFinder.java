package mf.java8ws.examples.example13;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import static mf.java8ws.examples.example13.Util.sequence;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   /*new Shop("111"),
                                                   new Shop("222"),
                                                   new Shop("333"),
                                                   new Shop("444"),*/
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
        return shops.parallelStream()
                .map(shop -> shop.getName() + " price is " + shop.getPriceFor(product))
                .collect(Collectors.<String>toList());
    }

    public List<String> findPrice(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPriceFor(product), executor))
                .collect(Collectors.toList());

        return sequence(priceFutures).join();
    }
/*/
    public List<String> findPriceSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getDiscountedPriceFor(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.<String>toList());
    }

    public List<String> findPriceParallel(String product) {
        return shops.parallelStream()
                .map(shop -> shop.getDiscountedPriceFor(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.<String>toList());
    }

    public List<String> findPrice(String product) {
        List<CompletableFuture<String>> priceFutures = findPriceStream(product)
                .collect(Collectors.<CompletableFuture<String>>toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.<String>toList());
    }

    public Stream<CompletableFuture<String>> findPriceStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getDiscountedPriceFor(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }

    public void printPricesStream() {
        long start = System.nanoTime();
        CompletableFuture[] futures = findPriceStream("myPhone")
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
    }
*/
}
