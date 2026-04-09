package RevConnect.model;

public class Products {

    private int userId;
    private String name;
    private String description;
    private double price;

    public Products(int userId, String name, String description, double price) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice(){
        return price;
    }
}