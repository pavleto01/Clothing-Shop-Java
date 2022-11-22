import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Cashier {
    private LocalDateTime fdate = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
    String date = fdate.format(myFormatObj);

    private ArrayList<Product> products = new ArrayList<>();

    public void newShirt(Product product){
        products.add(product);
    }
    public void newShoes(Product product){
        products.add(product);
    }
    public void newJacketsTrousers(Product product){
        products.add(product);
    }

    public double shirtDiscount(){
        double discount = 0;
        String thu = "Thu";
        boolean val = date.contains(thu);
        for(int i = 0; i < products.size(); i++) {
            if(products.size()>=3){
                discount = 0.2;
            }
            else if(products.get(i).getClass().getName() == "Shirt" && val == true){
                discount = 0.1;
            }
            else if (products.get(i).getClass().getName() == "Shirt"){
                discount = 0;
            }
        }
        return discount;
    }
    public double shirtPrice(){
        double shirtprice = 0;
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getClass().getName() == "Shirt") {
                shirtprice += products.get(i).getPrice();
                shirtprice = shirtprice - shirtprice*shirtDiscount();
            }
        }
        return shirtprice;
    }

    public double shoesDiscount(){
        double discount = 0;
        String thu = "Thu";
        boolean val = date.contains(thu);
        for(int i = 0; i < products.size(); i++) {
            if(products.size()>=3){
                discount = 0.2;
            }
            else if(products.get(i).getClass().getName() == "Shoes" && val == true){
                discount = 0.25;
            }
            else if(products.get(i).getClass().getName() == "Shoes" && val == true && products.size()>=3){
                discount = 0.25;
            }
            else if (products.get(i).getClass().getName() == "Shoes"){
                discount = 0;
            }
        }
        return discount;
    }
    public double shoesPrice(){
        double shoesprice = 0;
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getClass().getName() == "Shoes") {
                shoesprice += products.get(i).getPrice();
                shoesprice = shoesprice - shoesprice*shoesDiscount();
            }
        }
        return shoesprice;
    }

    public double jacktrouDiscount(){
        double discount = 0;
        for(int i = 0; i < products.size(); i++) {
            if(products.size()>=3){
                discount = 0.2;
            }
        }
        return discount;
    }
    public double jacktrouPrice(){
        double jacktrouprice = 0;
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getClass().getName() == "JacketsTrousers") {
                jacktrouprice += products.get(i).getPrice();
                jacktrouprice = jacktrouprice - jacktrouprice*jacktrouDiscount();
            }
        }
        return jacktrouprice;
    }

    public double discount(){
        double discount = 0;
        discount = (shirtDiscount() + shoesDiscount() + jacktrouDiscount())/3;
        return discount;
    }

    public double subtotal(){
        double sum = 0;
        for(int i = 0; i < products.size(); i++) {
                sum +=products.get(i).getPrice();
            }
        return sum;
    }
    public double total(){
        double sum = 0;
        sum = subtotal() - subtotal()*discount();
        return sum;
    }


    public void print(){
        System.out.println("Date: " + date);
        System.out.println("----Products----");
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getClass().getName() == "Shirt") {
                System.out.println(products.get(i).getName() + " - " + products.get(i).getBrand());
                System.out.println("$" + products.get(i).getPrice());
                if(shirtDiscount()!=0) {
                    System.out.println("#discount: " + shirtDiscount() * 100 + "% - $" + (products.get(i).getPrice() - shirtPrice()));
                }
            }
            else if(products.get(i).getClass().getName() == "Shoes") {
                System.out.println(products.get(i).getName() + " - " + products.get(i).getBrand());
                System.out.println("$" + products.get(i).getPrice());
                if(shoesDiscount()!=0) {
                    System.out.println("#discount: " + shoesDiscount() * 100 + "% - $" + (products.get(i).getPrice() - shoesPrice()));
                }
            }
            else if(products.get(i).getClass().getName() == "JacketsTrousers") {
                System.out.println(products.get(i).getName() + " - " + products.get(i).getBrand());
                System.out.println("$" + products.get(i).getPrice());
                if(jacktrouDiscount()!=0) {
                    System.out.println("#discount: " + jacktrouDiscount() * 100 + "% - $" + (products.get(i).getPrice() - jacktrouPrice()));
                }
            }
        }
        System.out.println("---------------------");
        System.out.println("SUBTOTAL: $" + subtotal());
        System.out.println("DISCOUNT: $" + (subtotal()-total()));
        System.out.println("TOTAL: $" + total());
    }
}
