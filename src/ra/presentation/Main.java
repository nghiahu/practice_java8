package ra.presentation;

import ra.business.ProductBusiness;
import ra.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> productList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************************MENU**************************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3 Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductBusiness.displayListProduct();
                    break;
                case 2:
                    ProductBusiness.addProduct(scanner);
                    break;
                case 3:
                    ProductBusiness.updateProduct(scanner);
                    break;
                case 4:
                    ProductBusiness.deleteProduct(scanner);
                    break;
                case 5:
                    ProductBusiness.searchProduct(scanner);
                    break;
                case 6:
                    ProductBusiness.filterProduct(scanner);
                    break;
                case 7:
                    ProductBusiness.sortProduct(scanner);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại!");
            }
        }while (true);
    }
}
