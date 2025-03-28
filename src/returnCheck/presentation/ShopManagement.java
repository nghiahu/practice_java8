package returnCheck.presentation;

import returnCheck.bussniess.CustomerBusiness;
import returnCheck.bussniess.IOrderBusiness;
import returnCheck.bussniess.OrderBusiness;
import returnCheck.entity.Customer;
import returnCheck.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static final List<Customer> listCustomers = new ArrayList<Customer>();
    public static final List<Order> listOrders = new ArrayList<>();
    public static final IOrderBusiness orderBusiness = new OrderBusiness();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*******************************SHOP MENU****************************");
            System.out.println("1. Quản lý khác hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean EXit = false;
                    do {
                        System.out.println("****************************CUSTOMER MENU***********************");
                        System.out.println("1. Danh sách khách hàng");
                        System.out.println("2. Thêm mới khách hàng");
                        System.out.println("3. Thoát");
                        System.out.print("Lựa chọn của bạn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                CustomerBusiness.displayCustomers();
                                break;
                            case 2:
                                CustomerBusiness.addCustomer(scanner);
                                break;
                            case 3:
                                EXit = true;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
                        }
                    }while (!EXit);
                    break;
                case 2:
                    EXit = false;
                    do {
                        System.out.println("****************************ORDER MENU***********************");
                        System.out.println("1. Danh sách đơn hàng");
                        System.out.println("2. Thêm mới đơn hàng");
                        System.out.println("3. Cập nhật trạng thái đơn hàng");
                        System.out.println("4. Danh sách đơn hàng quá hạn");
                        System.out.println("5. Thống kê số lượng đơn hàng đã giao");
                        System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
                        System.out.println("7. Thoát");
                        System.out.print("Lựa chọn của bạn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                orderBusiness.displayOrders();
                                break;
                            case 2:
                                orderBusiness.addOrder(scanner);
                                break;
                            case 3:
                                orderBusiness.updateOrderStatus(scanner);
                                break;
                            case 4:
                                orderBusiness.getOrderOverdue();
                                break;
                            case 5:
                                orderBusiness.getOrderDelivied();
                                break;
                            case 6:
                                orderBusiness.getTotalRevenue();
                                break;
                            case 7:
                                EXit = true;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại!");
                        }
                    }while (!EXit);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!");
            }
        }while (true);
    }
}