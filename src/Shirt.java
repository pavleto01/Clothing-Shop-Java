import java.util.ArrayList;

public class Shirt extends Product{
    private String size; //xs,s,m,l,xl,2xl

    public Shirt(String name, String brand, double price, String color, String size) {
        super(name, brand, price, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
