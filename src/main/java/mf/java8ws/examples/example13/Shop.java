package mf.java8ws.examples.example13;

import java.util.Random;

import static mf.java8ws.examples.example13.Util.delay;
import static mf.java8ws.examples.example13.Util.format;

public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getDiscountedPriceFor(String product) {
        double price = getPriceFor(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double getPriceFor(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public String getName() {
        return name;
    }
}
