package IOFile;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOProducts {
    File file = new File("C:\\CodeGym\\KiemTra_Module_2\\data\\products.csv");

    public void writeFile(List<Product> productList) throws IOException {
        String data = "";
        for (Product product : productList) {
            data += product.getProductId() + "," +
                    product.getProductName() + "," +
                    product.getPrice() + "," +
                    product.getQuantity() + "," +
                    product.getDetail() + "\n";
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public List<Product> readFile() throws IOException {
        List<Product> list = new ArrayList<>();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Product(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), data[4]));
        }
        bufferedReader.close();
        return list;
    }
}
