import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products=new ArrayList<>();
        products.add(new Product(1,"Nothing 4a","Mobile","Nothing",33000,5,4.6,10,true));
        products.add(new Product(2,"Iphone 17","Mobile","Apple",175000,10,4.8,15,true));
        products.add(new Product(3,"Google Pixel 10","Mobile","Google Pixel",70000,2,4.9,5,true));
        products.add(new Product(4,"Oneplus 13s","Mobile","Oneplus",65000,0,4.8,10,false));
        products.add(new Product(5,"Samsung S26","Mobile","Samsung",88000,8,4.7,15,true));
        products.add(new Product(6,"Iphone 17 Pro","Mobile","Apple",185000,5,5,10,true));
        products.add(new Product(7,"Basmati Rice 30Kg bag","Grocery","India Gate",4500,5,5,5,true));
        products.add(new Product(8,"Nike AIR","Fashion","Nike",12000,10,4.7,5,true));

        products.forEach(x-> System.out.println(x.productName));
        System.out.println("Products Greater than 5000");
        products.stream().filter(x->x.price>5000).forEach(System.out::println);

        System.out.println("Mobile Products:");
        products.stream().filter(x->x.category.equals("Mobile")).forEach(System.out::println);

        System.out.println("Products in Stock:");
        products.stream().filter(x->x.inStock).forEach(System.out::println);

        System.out.println("Products in Ascending price:");
        Collections.sort(products,(a,b)->(int)(a.price-b.price));
        products.forEach(System.out::println);

        System.out.println("Products in Descending price:");
        Collections.sort(products,(a,b)->(int)(b.price-a.price));
        products.forEach(System.out::println);

        System.out.println("Products in Highest to lowest rating:");
        Collections.sort(products,(a,b)->(int)(b.rating-a.rating));
        products.forEach(System.out::println);

        System.out.println("Products in Ascending price:");
        Collections.sort(products,(a,b)->a.productName.compareTo(b.productName));
        products.forEach(System.out::println);

        boolean available=products.stream().anyMatch(x->x.price>70000);
        System.out.println("Any product price above 70000:"+ available);

        boolean Rating=products.stream().allMatch(x->x.rating>3.5);
        System.out.println("Are all products rating more than 3.5?"+Rating);

        boolean medical=products.stream().noneMatch(x->x.category.equals("Medical"));
        System.out.println("Any Medical Product Available:"+medical);

        Product max=products.stream().max((a,b)->(int)(a.price-b.price)).get();
        System.out.println(max);

        Product min=products.stream().min((a,b)->(int)(a.price-b.price)).get();
        System.out.println(min);

        System.out.println("Mobile items price increase by 5%:");
        products.forEach(x-> { if(x.category.equals("Mobile")) {
            x.price = x.price * 1.05;
        }
        });

        System.out.println("10% Discount to Fashion");
        products.forEach(x->{
            if(x.category.equals("Fashion")){
                x.discountPercentage+=10;
            }
        });

        System.out.println("Marking stock 0 as out of stock:");
        products.forEach(x->{if(x.stock==0){
            x.inStock=false;
        }
        });

        long fashionCount=products.stream().filter(x->x.category.equals("Fashion")).count();
        System.out.println("Fashion Products Count:"+fashionCount);

        long ratingCount=products.stream().filter(x->x.rating>=4.5).count();
        System.out.println("Rating above 4.5 Count:"+ratingCount);

        long outOfStock=products.stream().filter(x->!x.inStock).count();
        System.out.println("Out Of Product Stocks:"+outOfStock);
    }
}