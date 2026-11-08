


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
    //===Hàm có VAT SHIPPING FEE===//
    static void printbill (){
        double VAT = 0.1 , SHIPPING_FEE = 20000;
        double cal = calculateTotal();
        double MoneyVAT = VAT * cal;
        double shipping;
        if (names.isEmpty()){
            shipping = 0;
        } else{
            shipping = SHIPPING_FEE;
        }
        System.out.println("Tổng Tiền Hàng : "+ cal);
        System.out.println("Tính Thuế : "+ MoneyVAT) ;
        System.out.println("Tiền SHIP :" + shipping);
       double Sum = cal + MoneyVAT + shipping;
        System.out.println("Tổng Thanh Toán : "+Sum);
    }
    //===Hàm In sản phẩm===//
    static void printItems (){
        if (names.isEmpty()){
            System.out.println("Không tìm thấy mặt hàng nào !");
            return;
        }
        for (int i = 0 ;i < names.size();i++){
            double linetotal ;
            linetotal = prices.get(i) * quantites.get(i);
            System.out.printf("%d. %s || %.1f || Sl : %d || Thành Tiền : %.1f%n",i+1 ,names.get(i),prices.get(i),quantites.get(i) ,linetotal);
        }
    }
    static void printMenu(){
        System.out.println("1.Thêm Mặt Hàng");
        System.out.println("2.Xoá mặt hàng (nhập)");
        System.out.println("3.Xem giỏ");
        System.out.println("4.Xem tổng tiền");
        System.out.println("5.Tìm Tên Sản phẩm");
        System.out.println("0.Kết Thúc");
    }
//====Hàm tìm tên===//
   static void searchName(Scanner sc) {
       String keyword;
       System.out.print("Tên Sản phẩm bạn muốn tìm :");
       keyword = sc.nextLine();
       boolean found = false;
       for (int i = 0; i < names.size(); i++) {
           if (names.get(i).equalsIgnoreCase(keyword)) {
               double linetotal ;
               linetotal = prices.get(i) * quantites.get(i);
               System.out.printf("%d. %s || %.1f || Sl : %d || Thành Tiền : %.1f%n", i + 1, names.get(i), prices.get(i), quantites.get(i), linetotal);
               found = true;
           }
       }
       if (!found){
           System.out.println("Không tìm thấy sản phẩm nào tên là " + keyword);
       }
   }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                case 4 -> printbill();
                case 5 -> searchName(sc);
                case 0 -> System.out.println("Kết Thúc !");
                default -> System.out.println("Vui Lòng chọn đúng !");

            }
        }while(choice != 0);
        sc.close();
    }
}


