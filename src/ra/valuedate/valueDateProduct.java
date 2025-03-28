package ra.valuedate;


import java.util.Optional;
import java.util.Scanner;

import static ra.presentation.Main.productList;

public class valueDateProduct {
    public static String inputNameProduct(Scanner scanner){
        while (true){
            System.out.print("Nhập vào tên sản phẩm:");
            String name = scanner.nextLine();
            if(name.length() >= 30 && name.length() <= 100){
                Optional nameProduct = productList.stream().filter(product -> product.getProductName().equals(name)).findFirst();
                if(nameProduct.isPresent()){
                    System.out.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                }else {
                    return name;
                }
            }else {
                System.out.println("Tên không hợp lệ vui lòng nhập lại!");
            }
        }
    }
    public static float inputPriceProduct(Scanner scanner){
        while (true){
            System.out.print("Nhập vào giá sản phẩm");
            float price = Float.parseFloat(scanner.nextLine());
            if(price > 0){
                return price;
            }
            System.out.println("Giá không hợp lệ vui lòng nhập lại!");
        }
    }

}
