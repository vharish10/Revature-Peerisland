import java.util.*;

public class OnlineStore {

    private final int productId;
    private String productName;
    private double originalPrice;
    private float discountPercentage;
    private int stockQuantity;

    OnlineStore(int productId,String productName,double originalPrice,float discountPercentage,int stockQuantity){
        this.productId=productId;
        setProductName(productName);
        setStockQuantity(stockQuantity);
        setOriginalPrice(originalPrice);
        setDiscountPercentage(discountPercentage);
    }

    public int getProductId(){
        return productId;
    }

    public void setProductName(String productName){
        if(productName==null || productName.isEmpty()){
            System.out.println("Enter Valid Name");
        }
        else{
            this.productName=productName;
        }
    }

    public String getProductName(){
        return productName;
    }

    public void setOriginalPrice(double originalPrice) {
        if(originalPrice<0){
            System.out.println("Enter valid price");
        }
        else{
            this.originalPrice=originalPrice;
        }
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setDiscountPercentage(float discountPercentage) {
        if(discountPercentage<0 || discountPercentage>60){
            System.out.println("Enter some genuine Discount ");
        }
        else{
            this.discountPercentage = discountPercentage;
        }
    }

    public double getDiscountPercentage(){
        return discountPercentage;
    }

    public void setStockQuantity(int stockQuantity){
        if(stockQuantity<0){
            System.out.println("Enter some valid stocks");
        }
        else{
            this.stockQuantity=stockQuantity;
        }
    }

    public int getStockQuantity(){
        return stockQuantity;
    }

    public double calculateDiscountAmount(){
        return (getOriginalPrice()*getDiscountPercentage()/100);
    }

    public void calculateFinalPrice(){
        double price=getOriginalPrice()-calculateDiscountAmount();
        if(price<0){
            System.out.println(" ");
        }
        else{
            System.out.println("Final Price"+price);
        }
    }

    public void sellProduct(int quantity){
        int currentQuantity=getStockQuantity();
        if(currentQuantity>quantity){
            System.out.println("Required amount of stock unavailable");
        }
        else{
            setStockQuantity(getStockQuantity()-quantity);
        }
    }

    public void displayProductDetails(){
        System.out.println("Product ID:"+getProductId());
        System.out.println("Product Name:"+getProductName());
        System.out.println("Product Original Price:"+getOriginalPrice());
        System.out.println("Product Stock Quantity:"+getStockQuantity());
        System.out.println("Discount Percentage:"+getDiscountPercentage());
    }
}
