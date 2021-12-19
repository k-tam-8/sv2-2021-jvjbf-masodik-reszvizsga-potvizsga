package filemanipulation;

public class Product {
    private int idNumber;
    private String name;
    private int price;

    public Product(int idNumber, String name, int price) {
        this.idNumber = idNumber;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return idNumber + ";" + name + ";" + price;
    }
}
