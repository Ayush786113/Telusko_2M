package Day2;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Service {
    private List<Product> productList ;
    public Service(){
        productList = new LinkedList<Product>();
    }
    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public  List<Product> getProductByName(String name){
        return productList.stream().filter(new ProductByName(name)).toList();
    }

    public List<Product> getProductWithText(String text){
        return productList.stream().filter(new ProductWithSuppliedString(text)).toList();
    }

    public List<Product> getProductByPlace(String place){
        return productList.stream().filter(new ProductByPlace(place)).toList();
    }

    public List<Product> getProductsOutOfWarranty(int year){
        return productList.stream().filter(new ProductOutOfWarranty(year)).toList();
    }
}

class ProductWithSuppliedString implements Predicate<Product> {
    String text;
    public ProductWithSuppliedString(String text){
        this.text = text.toLowerCase();
    }
    @Override
    public boolean test(Product product) {
        return product.getName().toLowerCase().contains(text) || product.getType().toLowerCase().contains(text) || product.getPlace().toLowerCase().contains(text);
    }
}

class ProductByPlace implements Predicate<Product>{
    String place;
    public ProductByPlace(String place) {
        this.place = place.toLowerCase();
    }
    @Override
    public boolean test(Product product) {
        return product.getPlace().toLowerCase().contains(place);
    }
}

class ProductByName implements Predicate<Product>{
    String name;
    public ProductByName(String name) {
        this.name = name.toLowerCase();
    }
    @Override
    public boolean test(Product product) {
        return product.getName().toLowerCase().contains(name);
    }
}

class ProductOutOfWarranty implements Predicate<Product>{
    int year;
    public ProductOutOfWarranty(int year){
        this.year = year;
    }
    @Override
    public boolean test(Product product) {
        return product.getWarranty() < year;
    }
}