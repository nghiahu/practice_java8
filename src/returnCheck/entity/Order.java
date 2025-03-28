package returnCheck.entity;

import returnCheck.presentation.ShopManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Order implements IApp {
    private static int idSequence = 0;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order() {
        this.id = ++idSequence;
    }

    public Order(Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = ++idSequence;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.customer = choiceCustomer(scanner);
        this.orderDate = inputOrderDate(scanner);
        System.out.println("Nhập vào tổng tiền của đơn hàng: ");
        this.totalAmount = Double.parseDouble(scanner.nextLine());
        this.status = false;
    }

    private Customer choiceCustomer(Scanner scanner) {
        System.out.println("Chọn khách hàng:");
        do {
            if (ShopManagement.listCustomers.isEmpty()) {
                return null;
            }
            ShopManagement.listCustomers
                    .forEach(customer -> System.out.printf("%d. %s\n", customer.getId(), customer.getName()));
            System.out.print("Lựa chọn của bạn:");
            int choiceId = Integer.parseInt(scanner.nextLine());
            OptionalInt indexCustomer = IntStream.range(0, ShopManagement.listCustomers.size()).filter(index -> ShopManagement.listCustomers.get(index).getId() == choiceId).findFirst();
            if (indexCustomer.isPresent()) {
                return ShopManagement.listCustomers.get(choiceId);
            }
            System.err.println("Vui lòng chọn đúng mã khách hàng");
        } while (true);
    }

    private LocalDate inputOrderDate(Scanner scanner) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nhập vào ngày nhận hàng:");
        return LocalDate.parse(scanner.nextLine(), dtf);
    }

    @Override
    public String toString() {
        return "Mã đơn hàng: " + this.id + ", Khách hàng: "
                + (this.customer == null ? "Không có khách hàng" : this.customer.getName())
                + ", Ngày đặt hàng: " + this.orderDate + ", Tổng tiền: "
                + this.totalAmount + ", Trạng thái: " + (this.status ? "Đã giao hàng" : "Chưa giao hàng");
    }
}