import java.util.Scanner;

public class Cart {
    private final String cartId;
    private int[] prices;
    private int count;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new int[capacity];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cartId = sc.next();
        int capacity = sc.nextInt();
        Cart cart = new Cart(cartId, capacity);
        int itemsToAdd = sc.nextInt();
        for (int i = 0; i < itemsToAdd; i++) {
            int price = sc.nextInt();
            cart.addItem(price);
        }
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
        sc.close();
    }
}