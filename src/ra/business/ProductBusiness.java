package ra.business;

import ra.entity.Product;
import ra.valuedate.valueDateProduct;

import java.io.OptionalDataException;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import static ra.presentation.Main.productList;

public class ProductBusiness {
    public static void displayListProduct(){
        for(Product product : productList){
            product.displayData();
        }
    }
    public static void addProduct(Scanner scanner){
        Product product = new Product();
        product.inputData(scanner);
        productList.add(product);
    }
    public static void updateProduct(Scanner scanner){
        System.out.print("Nhập vào mã sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        OptionalInt optIndex = IntStream.range(0,productList.size()).filter(index -> productList.get(index).getId() == id).findFirst();
        if(optIndex.isPresent()){
            boolean Exit = false;
            do {
                System.out.println("***********************MENU UPDATE**********************");
                System.out.println("1. Sửa tên sản phẩm");
                System.out.println("2. Sửa giá sản phẩm");
                System.out.println("3. Sửa danh mục sản phẩm");
                System.out.println("4. Thoát");
                System.out.print("Nhập lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        productList.get(optIndex.getAsInt()).setProductName(valueDateProduct.inputNameProduct(scanner));
                        break;
                    case 2:
                        productList.get(optIndex.getAsInt()).setPrice(valueDateProduct.inputPriceProduct(scanner));
                        break;
                    case 3:
                        System.out.print("Nhập tên danh mục: ");
                        productList.get(optIndex.getAsInt()).setCategory(scanner.nextLine());
                        break;
                    case 4:
                        Exit = true;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!");
                }
            }while (!Exit);
        }else {
            System.out.println("Không tồn tại mã phản phẩm");
        }
    }
    public static void deleteProduct(Scanner scanner){
        System.out.print("Nhập vào mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        OptionalInt optIndex = IntStream.range(0,productList.size()).filter(index -> productList.get(index).getId() == id).findFirst();
        if(optIndex.isPresent()){
            productList.remove(optIndex.getAsInt());
            System.out.println("Đã xóa sản phẩm thành công!");
        }else {
            System.out.println("Không tồn tại mã phản phẩm");
        }
    }
    public static void searchProduct(Scanner scanner){
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String productName = scanner.nextLine();
        Optional<Product> product = productList.stream().filter(pro -> pro.getProductName().equals(productName)).findFirst();
        if(product.isPresent()){
            product.get().displayData();
        }else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }
    public static void filterProduct(Scanner scanner){
        System.out.println("1. Lọc sản phẩm có giá lớn hơn X");
        System.out.println("2. Lọc sản phẩm theo danh mục");
        System.out.print("Lựa chọn của bạn");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice == 1){
            System.out.print("Nhập giá sản phẩm cần lọc: ");
            float price = Float.parseFloat(scanner.nextLine());
            System.out.println("Các sản phẩm có giá lớn hơn " + price + ": ");
            productList.stream().filter(product -> product.getPrice() > price).forEach(Product::displayData);
        } else if (choice == 2) {
            System.out.print("Nhập danh mục sản phẩm cần lọc: ");
            String category = scanner.nextLine();
            System.out.println("Các sản phẩm có danh mục là " + category + ": ");
            productList.stream().filter(product -> product.getCategory().equalsIgnoreCase(category)).forEach(Product::displayData);
        }else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }
    public static void sortProduct(Scanner scanner){
        System.out.println("1. Sắp xếp theo giá tăng dần");
        System.out.println("2. Sắp xếp theo giá giảm dần");
        System.out.print("Lựa chọn của bạn");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice == 1){
            productList.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(Product::displayData);
        }else if(choice == 2){
            productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).forEach(Product::displayData);
        }else {
            System.out.println("Lựa chon không hợp lệ!");
        }
    }
}
