
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {

    private static final Customer customer = new Customer("C01", "Tuấn Thành", "0386957821");
    private static final List<CartItem> cart = new ArrayList<>();
    private static final Product p1 = new Product("P01", "Áo thun", 150000, 20);
    private static final Product p2 = new Product("P02", "Bình nước", 50000, 10);
    private static final Scanner scanner = new Scanner(System.in);

    static void printMenu() {
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }

    static void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        cart.add(item);
    }

    static void removeItem(int index) {
        cart.remove(index);
    }

    static double calcutotal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            total += item.getTotal();
        }
        return total;
    }


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("======== MENU ======== ");
            printMenu();
            System.out.println("======================");
            System.out.print("=> Chọn :");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--- Danh sách sản phẩm ---");
                    System.out.println(p1.getId() + " - " + p1.getName());
                    System.out.println(p2.getId() + " - " + p2.getName());

                    System.out.print("Mã sản phẩm: ");
                    scanner.nextLine();
                    String id_product = scanner.nextLine();

                    System.out.print("Số lượng: ");
                    int quantity_product = scanner.nextInt();
                    //====== DK SP =======

                    if (quantity_product <= 0) {
                        System.out.println("Số lượng không hợp lệ! Phải lớn hơn 0.");
                    }
                    else {

                        if (id_product.equals("P01")) {

                            if (quantity_product <= p1.getStock()) {
                                addItem(p1, quantity_product);
                                System.out.println("Đã Thêm > Nhấn 3 để xem Giỏ !");
                            } else {
                                System.out.println("Thất bại! Kho P01 chỉ còn " + p1.getStock());
                            }
                        }
                        else if (id_product.equals("P02")) {
                            if (quantity_product <= p2.getStock()) {
                                addItem(p2, quantity_product);
                                System.out.println("Đã Thêm > Nhấn 3 để xem Giỏ !");
                            } else {
                                System.out.println("Thất bại! Kho P02 chỉ còn " + p2.getStock());
                            }
                        }
                        else {
                            System.out.println("Mã sản phẩm không tồn tại!");
                        }
                    }
                    break;

                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("Giỏ Hàng Trống !");
                    }
                    System.out.print("Vị trí muốn xoá :");
                    int displayNumber = scanner.nextInt();
                    int index = displayNumber - 1;
                    removeItem(index);
                    System.out.println("Đã Xoá > Nhấn 3 để xem Giỏ !");
                case 3:
                    System.out.println("======Khách Hàng======");
                    System.out.println( customer.toString());
                    System.out.println("======================");
                    for (int i = 0; i < cart.size(); i++) {
                        CartItem item = cart.get(i); // item nó bao gồm product và quantity.
                        Product p = item.getProduct(); // lấy ra sản phần không có quantity.
//                        item.getQuantity();   => lấy ra sô lượng.
                        System.out.printf("%d. %s || %s || %.1f || SL : %d || Thành Tiền : %.1f\n", i + 1, p.getId(), p.getName(), p.getPrice(), item.getQuantity(), item.getTotal());
                    }
                    break;
                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Giỏ Trống !");
                        return;
                    }
                    System.out.println("Tổng tiên các mặt hàng là  : " + calcutotal());
                    break;
                case 0:
                    System.out.println("kết thúc");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while (choice != 0);
    }
}
