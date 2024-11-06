public class Category {
    private String name;
    private Product[] products;
    private int num_products;

    public Category() {
        num_products = 0;
    }
    //Конструктор с параметрами класса Category
    public Category(String name) {
        this.name = name;
        num_products = 0;
    }
    //Добавление класса Product в класс Category
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
    public String get() {
        return name;
    }
    //Получение данных класса
    public void set(String name) {
        this.name = name;
    }
}
