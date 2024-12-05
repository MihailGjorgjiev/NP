package VtorKolokviumVezbi.Discounts_3;

import java.util.Arrays;

public class Item{
    private int discountPrice;
    private int fullPrice;

    public Item(){
        discountPrice=0;
        fullPrice=0;
    }
    public Item(String itemString) {
        int[] intPrices = Arrays.stream(itemString.split(":")).mapToInt(Integer::parseInt).toArray();
        discountPrice=intPrices[0];
        fullPrice=intPrices[1];
    }

    public Item(int discountPrice, int fullPrice) {
        this.discountPrice = discountPrice;
        this.fullPrice = fullPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public double discount(){
        return 1- (double) discountPrice /fullPrice;
    }
    public int integerDiscount(){
        return (int)(discount()*100);
    }

    public int absoluteDiscount(){
        return fullPrice-discountPrice;
    }
}
