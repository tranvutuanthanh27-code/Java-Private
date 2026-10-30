package Thanh.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class HitShop {
    static List<String> names = new ArrayList<>();
    static List<Double> prices = new ArrayList<>();
    static List<Integer> quantites = new ArrayList<>();
//===Hàm main===//
    static void addItem (Scanner sc){
      String name;
      double price;
      int quantity;
        do {
            System.out.print("Tên Hàng :");
            name = sc.nextLine();
            if (name.isBlank()){
                System.out.println("Không để Trống Tên && Yêu cầu nhập đúng tên sản phẩm !");
            }
        } while (name.isBlank());
        do{
            System.out.print("Giá :");
            price = Double.parseDouble(sc.nextLine());
            if (price <= 0 ){
                System.out.println("Không Nhập giá Nhỏ hơn 0 && Nhâp Lại !");
            }
        } while (price <=0);
        do{
            System.out.print("Số lượng :");
            quantity = Integer.parseInt(sc.nextLine());
            if (quantity < 0 ){
                System.out.println("Số lượng phải lớn hơn 0 && Nhập lại !");
            }
        } while (quantity < 0);
        names.add(name);
        prices.add(price);
        quantites.add(quantity);

        System.out.println("<---Đã Thêm vào giỏ . Nhấn 3 để xem !--->");
    }

    //===Hàm xoá===//
    static void removeItem(Scanner sc){
        if (names.isEmpty()){
            System.out.println("Không có mặt hàng nào !");
        }
        System.out.print("Vị trí bạn muốn xoá :");
        int index = Integer.parseInt(sc.nextLine());
        if (index <= 0 || index > prices.size()){
            System.out.println("Vị trí Xoá không tồn tại !");
            return;
        }
        names.remove(index -1);
        prices.remove(index-1);
        quantites.remove(index-1);

        System.out.println("<---Đã Xoá SP . Nhấn 3 để xem !--->");
    }

    //===Hàm tính tổng của Tổng từng sản phẩm====//
    static double calculateTotal (){
        double total = 0;
        for (int i = 0 ;i < names.size();i++){
            total += prices.get(i) * quantites.get(i);
        }
        return total;
    }
    //===Hàm In sản phẩm===//
    static void printItems (){
        if (names.isEmpty()){
            System.out.println("Không tìm thấy mặt hàng nào !");
            return;
        }
        for (int i = 0 ;i < names.size();i++){
            double linetotal =0;
            linetotal = prices.get(i) * quantites.get(i);
            System.out.printf("%d. %s || %.1f || Sl : %d || Thành Tiền : %.1f%n",i+1 ,names.get(i),prices.get(i),quantites.get(i) ,linetotal);
        }
    }
    static void printMenu(){
        System.out.println("1.Thêm Mặt Hàng");
        System.out.println("2.Xoá mặt hàng (nhập)");
        System.out.println("3.Xem giỏ");
        System.out.println("4.Xem tổng tiền");
        System.out.println("0.Kết Thúc");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double VAT_Rate = 0.10 , SHIPPING_FEE = 20000;
        int choice;
        do {
            System.out.println("=========Menu=========");
            printMenu();
            System.out.println("======================");
            System.out.print("||Chọn :");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1 -> addItem(sc);
                case 2 -> removeItem(sc);
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền :" + calculateTotal());
                case 0 -> System.out.println("Kết Thúc !");
                default -> System.out.println("Vui Lòng chọn đúng !");

            }
        }while(choice != 0);
        sc.close();
    }
}


