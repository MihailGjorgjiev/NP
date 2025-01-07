package VtorKolokviumVezbi.OnlineShop_25;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineShop {
    private Map<String, Product> products;

    OnlineShop() {
        products = new HashMap<>();
    }

    void addProduct(String category, String id, String name, LocalDateTime createdAt, double price) {
        products.put(id,new Product(category, id, name, createdAt, price));
    }

    double buyProduct(String id, int quantity) throws ProductNotFoundException {
        Product product=products.getOrDefault(id,null);
        if(product == null){
            throw new ProductNotFoundException("");
        }
        return product.buy(quantity);
    }

    private Comparator<Product> getComparator(String category){
        Comparator<Product> newestFirst=Comparator.comparing(Product::getCreatedAt,Comparator.reverseOrder());
        Comparator<Product> oldestFirst=Comparator.comparing(Product::getCreatedAt);
        Comparator<Product> lowestPrice=Comparator.comparing(Product::getPrice);
        Comparator<Product> highestPrice=Comparator.comparing(Product::getPrice,Comparator.reverseOrder());
        Comparator<Product> mostSold=Comparator.comparing(Product::getQuantitySold,Comparator.reverseOrder());
        Comparator<Product> leastSold=Comparator.comparing(Product::getQuantitySold);

        if(COMPARATOR_TYPE.NEWEST_FIRST.name().equals(category)){
            return newestFirst;
        }
        if(COMPARATOR_TYPE.OLDEST_FIRST.name().equals(category)){
            return oldestFirst;
        }
        if(COMPARATOR_TYPE.LOWEST_PRICE_FIRST.name().equals(category)){
            return lowestPrice;
        }
        if(COMPARATOR_TYPE.HIGHEST_PRICE_FIRST.name().equals(category)){
            return highestPrice;
        }if(COMPARATOR_TYPE.MOST_SOLD_FIRST.name().equals(category)){
            return mostSold;
        }if(COMPARATOR_TYPE.LEAST_SOLD_FIRST.name().equals(category)){
            return leastSold;
        }
        return Comparator.comparing(p->0);



    }

    List<List<Product>> listProducts(String category, COMPARATOR_TYPE comparatorType, int pageSize) {

        Comparator<Product> productComparator=getComparator(category);

//        products.values().stream()
//                .sorted(productComparator)
//                .collect(Collectors.)

        List<List<Product>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        return result;
    }

}
