package ra.entity;

import ra.valuedate.valueDateProduct;

import java.time.LocalDate;
import java.util.Scanner;

public class Product implements IProduct {
    private static int idSequence = 0;
    private int id;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.id = ++idSequence;
        this.createdDate = LocalDate.now();
    }

    public Product(String productName, float price, String category, LocalDate createdDate) {
        this.id = ++idSequence;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.productName = valueDateProduct.inputNameProduct(scanner);
        this.price = valueDateProduct.inputPriceProduct(scanner);
        System.out.print("Nhập danh mục sản phẩm: ");
        this.category = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - Giá sản phẩm: %.2f - Danh mục: %s - Ngày tạo: %s\n",id,productName,price,category,createdDate);
    }
}
