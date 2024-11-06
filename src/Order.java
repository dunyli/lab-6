public class Order {
    private int client_id;
    private Product[] products;
    private int num_products;
    private int total_price;

    //Конструктор класса Order
    public Order() {
        client_id = 0;
        num_products = 0;
        total_price = 0;
    }

    //Добавление класса Product в класс Order
    public void addProduct(Product product) {
        Product[] newProducts = new Product[num_products + 1];
        for (int i = 0; i < num_products; i++) {
            newProducts[i] = products[i];
        }
        newProducts[num_products] = product;
        products = newProducts;
        num_products++;
    }
    //Вывод данных класса
    public int getClient_id() {
        return client_id;
    }
    //Вывод данных класса
    public int getNum_products() {
        return num_products;
    }
    //Вывод данных класса
    public int getTotal_price() {
        return total_price;
    }

    public void set(int client_id, int num_products, int total_price) {
        this.client_id = client_id;
        this.num_products = num_products;
        this.total_price = total_price;
    }

    public Product listProducts(int count) {
        for (int i = 0; i < num_products; i++) {
            if (i == count) return products[i];
        }
        return null;
    }
}
