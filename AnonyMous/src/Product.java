public class Product {
    int productId;
    String productName;
    String category;
    String brand;
    double price;
    int stock;
    double rating;
    double discountPercentage;
    boolean inStock;

    Product(int productId,String productName, String category, String brand, double price, int stock, double rating, double discountPercentage, boolean inStock){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
        this.brand=brand;
        this.price=price;
        this.stock=stock;
        this.rating=rating;
        this.discountPercentage=discountPercentage;
        this.inStock=inStock;
    }

    public String toString() {
        return "ProductId"+productId+","+"ProductName"+productName+","+"Category"+category+","+ "Brand"+brand+","+"Price"+price+","
                +"Stock"+stock+","+"Rating"+rating+","+ "Discount"+discountPercentage+","+"INStock"+inStock;
    }
}
