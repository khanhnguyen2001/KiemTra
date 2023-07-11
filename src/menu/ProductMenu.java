package menu;

import check.Check;
import management.ProductManagement;
import model.Product;

import java.util.Scanner;

public class ProductMenu {
    private ProductManagement productManagement = new ProductManagement();
    private Check check = new Check();

    public void showAllProducts() {
        System.out.println("==== Danh Sách Sản Phẩm ====");

        int start = 1;
        int count = 0;

        while (count < 5 && start <= productManagement.getAll().size()) {
            int num = start;
            while (num <= start + 4 && num <= productManagement.getAll().size()) {
                System.out.println(productManagement.getAll().get(num - 1));
                System.out.println("--------------");
                num++;
            }
            System.out.println("Nhấn Enter để tiếp tục hiển thị!");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            start += 5;
            count++;
        }

    }

    public void addProduct() {
        System.out.println("==== Thêm Sản Phẩm ====");
        String productId;
        while (true) {
            String str = "Nhập ID sản phẩm: ";
            productId = check.checkRegex(str, Check.PRODUCT_ID);
            if (productManagement.findIndexById(productId) == -1) {
                break;
            }
            System.out.println("ID sản phẩm đã tồn tại!!!");
        }

        String productName;
        while (true) {
            String str = "Nhập tên sản phẩm: ";
            productName = check.checkRegex(str, Check.STRING);
            break;
        }

        double price;
        while (true) {
            String str = "Nhập giá sản phẩm: ";
            price = check.checkInputNumber(str);
            break;
        }

        int quantity;
        while (true) {
            String str = "Nhập số lượng sản phẩm: ";
            quantity = check.checkInputNumber(str);
            break;
        }

        String detail;
        while (true) {
            String str = "Nhập mô tả sản phẩm: ";
            detail = check.checkRegex(str, Check.STRING);
            break;
        }

        Product product = new Product(productId, productName, price, quantity, detail);
        productManagement.add(product);

    }

    public void updateProduct() {
        System.out.println("==== Sửa Sản Phẩm ====");

        String str = "Nhập ID sản phẩm cần sửa: ";
        String productId = check.checkRegex(str, Check.PRODUCT_ID);
        if (productManagement.findIndexById(productId) == -1) {
            System.out.println("Không tìm thấy sản phẩm !!!");
        } else {
            System.out.println("----------");
            System.out.println(productManagement.getAll().get(productManagement.findIndexById(productId)).toString());
            System.out.println("----------");

            String productName;
            while (true) {
                String str1 = "Nhập tên mới của sản phẩm: ";
                productName = check.checkRegex(str1, Check.STRING);
                break;
            }

            double price;
            while (true) {
                String str2 = "Nhập giá mới của sản phầm: ";
                price = check.checkInputNumber(str2);
                break;
            }

            int quantity;
            while (true) {
                String str3 = "Nhập số lượng của sản phẩm: ";
                quantity = check.checkInputNumber(str3);
                break;
            }

            String detail;
            while (true) {
                String str4 = "Nhập mô tả của sản phẩm: ";
                detail = check.checkRegex(str4, Check.STRING);
                break;
            }

            Product product = new Product(productId, productName, price, quantity, detail);
            productManagement.edit(productId, product);

        }
    }

    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Xóa Sản Phẩm ====");

        String str = "Nhập ID sản phẩm muốn xóa: ";
        String productId = check.checkRegex(str, Check.PRODUCT_ID);
        if (productManagement.findIndexById(productId) != -1) {
            System.out.print("Bạn Có Muốn Xóa? (Y/N): ");
            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("y")) {
                productManagement.delete(productId);
            }
        }
    }

    public void sortProduct() {
        int choice = -1;
        do {
            String menu = "===== SẮP XẾP SẢN PHẨM =====\n" +
                    "1. Sắp Xếp Tăng Dần Theo Giá\n" +
                    "2. Sắp Xếp Giảm Dần Theo Giá\n" +
                    "3. Thoát";

            System.out.println(menu);
            System.out.println("----------");
            String str = "Mời bạn nhập lựa chọn: ";
            choice = check.checkInputNumber(str);

            switch (choice) {
                case 1:
                    System.out.println("\nDanh Sách Sau Khi Đã Sắp Xếp Tăng Dần:\n");
                    for (Product product : productManagement.sortAscProduct()) {
                        System.out.println(product.toString());
                        System.out.println("*************");
                    }
                    break;
                case 2:
                    System.out.println("Danh Sách Sau Khi Đã Sắp Xếp Giảm Dần");
                    for (Product product : productManagement.sortDecProduct()) {
                        System.out.println(product.toString());
                        System.out.println("*************");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != 3);
    }

    public void mostExpensiveProduct() {
        System.out.println("===== Tìm Sản Phẩm Có Giá Đắt Nhất =====");
        for (Product product : productManagement.getAll()) {
            if (product.getPrice() == productManagement.sortDecProduct().get(0).getPrice()) {
                System.out.println(product.toString());
                System.out.println("----------");
            }
        }
    }
}

