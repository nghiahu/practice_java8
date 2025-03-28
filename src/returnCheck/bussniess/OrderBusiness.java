package returnCheck.bussniess;


import returnCheck.entity.Order;
import returnCheck.presentation.ShopManagement;


import java.time.LocalDate;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class OrderBusiness implements IOrderBusiness {
    @Override
    public void addOrder(Scanner scanner) {
        System.out.println("Nhập vào số đơn hàng cần nhập thông tin:");
        int sizeOrder = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeOrder; i++) {
            Order order = new Order();
            order.inputData(scanner);
            ShopManagement.listOrders.add(order);
        }
    }

    @Override
    public void displayOrders() {
        ShopManagement.listOrders.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {
        System.out.println("Nhập vào mã đơn hàng cần cập nhật:");
        int id = Integer.parseInt(scanner.nextLine());
        OptionalInt optIndex = IntStream.range(0, ShopManagement.listOrders.size())
                .filter(index -> ShopManagement.listOrders.get(index).getId() == id).findFirst();
        if (optIndex.isPresent()) {
            System.out.println("Nhập vào trạng thái cần cập nhật:");
            ShopManagement.listOrders.get(optIndex.getAsInt()).setStatus(Boolean.parseBoolean(scanner.nextLine()));
        } else {
            System.err.println("Không tồn tại mã hóa đơn");
        }
    }

    @Override
    public List<Order> getOrderOverdue() {
        return ShopManagement.listOrders.stream()
                .filter(order -> !order.isStatus() && order.getOrderDate().isBefore(LocalDate.now()))
                .toList();
    }

    @Override
    public List<Order> getOrderDelivied() {
        return ShopManagement.listOrders.stream().filter(Order::isStatus).toList();
    }
}