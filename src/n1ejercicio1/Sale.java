package n1ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Product> products;
    private double total;

    public Sale() {
        this.products = new ArrayList<>();
        this.total = 0;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double getTotal() {
        return total;
    }

    public List<Product> getProducts() {
        return List.copyOf(this.products);
    }

    //Checked exception
    public void calculateTotal() {
        try {
            if(products.isEmpty()) {
                throw new EmptySaleException();
            }
            for (Product product : products) {
                total += product.getPrice();
            }
            total = (double) Math.round(total * 100) / 100;
        } catch (EmptySaleException e) {
            System.out.println(e);
        }
    }

    //Unchecked exception
    public void calculateTotal2() {
        if(products.isEmpty()) {
            throw new EmptySaleUncheckedException();
        }
        for (Product product : products) {
            total += product.getPrice();
        }
        total = (double) Math.round(total * 100) / 100;
    }
}
