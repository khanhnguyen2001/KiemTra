package menu;

import check.Check;

public class MainMenu {
    private Check check = new Check();
    private ProductMenu productMenu = new ProductMenu();

    public void mainMenu() {
        int choice = -1;
        do {
            String menu = "==== CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM ====\n" +
                    "1. Xem danh sách\n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhật\n" +
                    "4. Xóa\n" +
                    "5. Sắp xếp\n" +
                    "6. Tìm sản phẩm có giá đắt nhất\n" +
                    "0. Thoát\n";

            System.out.println(menu);
            System.out.println("----------");
            String str = "Mời bạn nhập lựa chọn: ";
            choice = check.checkInputNumber(str);
            System.out.println("\n");

            switch (choice) {
                case 1:
                    productMenu.showAllProducts();
                    break;
                case 2:
                    productMenu.addProduct();
                    break;
                case 3:
                    productMenu.updateProduct();
                    break;
                case 4:
                    productMenu.deleteProduct();
                    break;
                case 5:
                    productMenu.sortProduct();
                    break;
                case 6:
                    productMenu.mostExpensiveProduct();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn!!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != 0);
    }
}
