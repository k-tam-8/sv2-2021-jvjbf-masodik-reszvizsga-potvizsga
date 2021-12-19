package filemanipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    private List<Product> productList = new ArrayList<>();

    public void readProductsFromFile(Path path) {
        List<String> productReadIn;
        try {
            productReadIn = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        createProducts(productReadIn);
    }

    private void createProducts(List<String> productReadIn) {
        for (String s : productReadIn) {
            String[] tempArr = s.split(";");
            int idNumber = Integer.parseInt(tempArr[0]);
            int price = Integer.parseInt(tempArr[2]);
            productList.add(new Product(idNumber, tempArr[1], price));
        }
    }

    public List<Product> getProducts() {
        List<Product> productListCopy = productList;
        return productListCopy;
    }

    public void writePriceOverToFile(Path path, int price) throws IOException {
        List<String> filteredList = new ArrayList<>();
        for (Product p : productList) {
            if (p.getPrice() > price) {
                filteredList.add(p.toString());
            }
        }
        Files.write(path, filteredList);
    }
}
