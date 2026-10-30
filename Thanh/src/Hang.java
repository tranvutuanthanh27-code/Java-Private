package Thanh.src;
import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Hang {
    static List<String> names = new ArrayList<>();
    static List<Double> prices = new ArrayList<>();
    static List<Integer> quantities = new ArrayList<>();
    // Hàm main
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int choice;
        do{
            System.out.println("=========Menu=========");
            printMenu();
            System.out.println("======================");
            System.out.print("-Chọn :");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    addItems(sc);
                    break;
                case 2:
                    removeItems(sc);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tổng tiền các mặt hàng cộng lại là :" + calculateTotal());
                    break;
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ !");
            }
        } while (choice != 0);
        sc.close();
    }
    static void printMenu (){
        System.out.println("1.Thêm Mặt Hàng");
        System.out.println("2.Xoá Giỏ Hàng");
        System.out.println("3.Xem Giỏ Hàng");
        System.out.println("4.Tính Tổng");
        System.out.println("0.Thoát");
    }

    //Hàm in từng sản phầm ra màn hình
    static void printItems (){
        if (prices.isEmpty()){
            System.out.println("Giỏ Hàng Trống !");
            return;
        }
        for (int i = 0 ; i < names.size() ;i++){
            double linetotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s || %.1f || Sl: %d || Thành Tiền : %.1f%n", i + 1 ,names.get(i) , prices.get(i), quantities.get(i),linetotal);
        }
    }

    // Hàng thêm sp
    static void addItems (Scanner sc){
        String name;
        do {
            System.out.print("Nhập tên mặt hàng :");
             name = sc.nextLine();
            if (name.isBlank()){
                System.out.println("Không để Tên Rỗng !");
            }
        }while (name.isBlank());

        System.out.print("Nhập giá tiền của mặt hàng :");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng mặt hàng :");
        int quantity = Integer.parseInt(sc.nextLine());

        names.add(name);
        prices.add(price);
        quantities.add(quantity);

        printItems();

    }

    //Hàm Xoá sản phẩm
    static void removeItems (Scanner sc){
        System.out.print("Bạn muốn xoá sản phầm ở vị trí thứ mấy :");
        int index =Integer.parseInt(sc.nextLine());
        if (index <= 0 || index > names.size()){
            System.out.println("Không có sản phầm !");
            return;
        }
        names.remove(index -1);
        prices.remove(index -1);
        quantities.remove(index -1);

        printItems();
    }

    static double calculateTotal (){
        double Total = 0 ;
        for (int i = 0 ;i < names.size();i++){
            Total += prices.get(i) * quantities.get(i);
        }
        return Total;
    }
}

