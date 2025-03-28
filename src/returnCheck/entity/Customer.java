package returnCheck.entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private static int idSequence = 0;
    private int id;
    private String name;
    private Optional<String> email;

    public Customer() {
        this.id = ++idSequence;
    }

    public Customer(String name, Optional<String> email) {
        this.id = ++idSequence;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên khách hàng:");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào email khách hàng:");
        String inputEmail = scanner.nextLine().trim();
        this.email = inputEmail.isEmpty() ? Optional.empty() : Optional.of(inputEmail);
    }

    @Override
    public String toString() {
        return "Mã khách hàng: " + this.id + ", Tên khách hàng: " + this.name + ", Email: " + this.email.orElse("Không có email");
    }
}