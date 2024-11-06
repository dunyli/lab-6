public class Product {
    private String name;
    private int price;
    private int count;
    private int category_id;
    private int supplier_id;
    //Конструктор класса Product
    public Product() {
        price = 0;
        count = 0;
        category_id = 0;
        supplier_id = 0;
    }

    public void set(String name, int price, int count, int category_id, int supplier_id) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    //Вывод данных класса
    public String getName() {
        return name;
    }
    //Вывод данных класса
    public int getPrice() {
        return price;
    }
    //Вывод данных класса
    public int getCount() {
        return count;
    }
    //Вывод данных класса
    public int getCategory_id() {
        return category_id;
    }
    //Вывод данных класса
    public int getSupplier_id() {
        return supplier_id;
    }
}
