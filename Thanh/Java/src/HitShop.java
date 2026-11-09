
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {

    private static final Customer customer = new Customer("C01", "Tuấn Thành", "0386957821");
    private static final List<CartItem> cart = new ArrayList<>();
//    private static final Product p1 = new Product("P01", "Áo thun", 150000, 20);
//    private static final Product p2 = new Product("P02", "Bình nước", 50000, 10);
   private static final List<Product> products = new ArrayList<>();
   static {
       products.add(new Product("P01", "Áo thun", 150000, 20));
       products.add(new Product("P02", "Bình nước", 50000, 10));
   }
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
                  for (int i = 0 ;i < products.size();i++){
                      Product pro = products.get(i);
                      System.out.println(pro.toString());
                  }

                    System.out.print("Mã sản phẩm :");
                    scanner.nextLine();
                    String id_product = scanner.nextLine();
                    Product found_product = null;
                    for (int i =0 ; i < products.size() ;i++){
                        Product p = products.get(i);
                        if (p.getId().equals(id_product)){
                            found_product = p;
                            break;
                        }
                    }
                    System.out.print("Số lượng: ");
                    int quantity_product = scanner.nextInt();
                    CartItem it = new CartItem(found_product , quantity_product);
                    if (quantity_product > 0){
                        cart.add(it);
                        System.out.println("Đã Thêm => Nhấn 3 để xem Giỏ !");
                    }


                    break;

                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("Giỏ Hàng Trống !");
                    } else {
                        System.out.println("Vi trí muốn xoá từ 1 - " + cart.size() + " : ");
                        int displayNumber = scanner.nextInt();
                        int index = displayNumber - 1;
                        if (index >= 0 && index < cart.size()){
                            cart.remove(index);
                            System.out.println("Đã Xoá => Nhấn 3 để xem Giỏ !");
                        } else {
                            System.out.println(" Vi Tri Xoa Khong Hop Le !");
                        }
                    }
                    break;
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
