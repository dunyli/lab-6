public class Storehouse {
    private Product[] products;
    private int num_products;

    //Конструктор класса Storehouse
    public Storehouse() {
        num_products = 0;
    }

    //Добавление класса Product в класс Storehouse
    public void addProduct(Product product) {
        Product[] newProducts = new Product[num_products + 1];
        for (int i = 0; i < num_products; i++) {
            newProducts[i] = products[i];
        }
        newProducts[num_products] = product;
        products = newProducts;
        num_products++;
    }

    public void editProduct(int product_id, String name, int price, int volume, int category_id, int supplier_id) {
        products[product_id].set(name, price, volume, category_id, supplier_id);
    }

    public Product listProducts(int count) {
        for (int i = 0; i < num_products; i++) {
            if (i == count) return products[i];
        }
        return null;
    }

    //Вывод данных класса
    public int getNum_products() {
        return num_products;
    }
}
