package model;

import infastructure.Pair;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Entity {

    private User customer;
    private ArrayList<Pair<Product, Integer>> products;

    public ShoppingCart(){
        super();
        products = new ArrayList<Pair<Product, Integer>>();
    }

    public List<Pair<Product, Integer>> getProducts() {
        return products;
    }

    public void insertProduct(Product product, int amount)
    {
        products.add(new Pair<Product, Integer>(product, amount));
    }

    public void changeQuantity(Product product, int amount)
    {
        Pair<Product, Integer> x = products.stream().filter((p) -> p.getKey().equals(product)).findFirst().orElseThrow();
        x.setValue(x.getValue() + amount);
    }
}
