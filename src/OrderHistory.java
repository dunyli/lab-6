public class OrderHistory {
    private Order[] orders;
    private int orderCount;

    //Конструктор класса OrderHistory
    public OrderHistory() {
        orderCount = 0;
    }
    //Добавление класса Order в класс OrderHistory
    public void addOrder(Order order) {
        Order[] newOrders = new Order[orderCount + 1];
        for (int i = 0; i < orderCount; i++) {
            newOrders[i] = orders[i];
        }
        newOrders[orderCount] = order;
        orders = newOrders;
        orderCount++;
    }

    public Order listOrders(int count) {
        for (int i = 0; i < orderCount; i++) {
            if (i == count) return orders[i];
        }
        return null;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
