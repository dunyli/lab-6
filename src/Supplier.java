public class Supplier {
    private String name;
    private String phone;
    private String address;
    private Product[] products;
    private int num_products;

    public Supplier() {
    }
    //Конструктор с параметрами класса Supplier
    public Supplier(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    //Добавление класса Product в класс Supplier
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
    public String getName() {
        return name;
    }
    //Вывод данных класса
    public String getPhone() {
        return phone;
    }
    //Вывод данных класса
    public String getAddress() {
        return address;
    }
    //Получение данных класса
    public void set(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
