public class Main {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        Shirt shirt1 = new Shirt("Blue Cotton Shirt", "BrandS",14.99,"Blue","M");
        cashier.newShirt(shirt1);

        Shirt shirt2 = new Shirt("White Cotton Shirt", "BrandS",15.99,"White","M");
        cashier.newShirt(shirt2);

        JacketsTrousers trousers1 = new JacketsTrousers("Black Cotton Trousers", "BrandT",29.99,"Black",50);
        cashier.newJacketsTrousers(trousers1);

        Shoes shoes1 = new Shoes("Black Leather Shoes", "BrandS",59.99,"Black",43);
        cashier.newShoes(shoes1);

        JacketsTrousers jacket1 = new JacketsTrousers("Black Cotton Suit Jacket", "BrandJ",99.99,"Black",50);
        cashier.newJacketsTrousers(jacket1);

        cashier.print();

    }
}
