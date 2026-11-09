public class CartItem {
    private Product product;
    private int quantity;
    public CartItem (Product product , int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct (){
        return product;
    }
    public int getQuantity (){
        return quantity;
    }
    public void setQuantity (int quantity){
        if (quantity <= 0 || quantity > product.getStock() ){
            System.out.println("So Luong Khong Hop Le !");
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }
    public double getTotal (){
        return product.getPrice() * getQuantity();
    }
}
