import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Store store = new Store();
        Storehouse storehouse = new Storehouse();
        OrderHistory orderhistory = new OrderHistory();
        Order newOrder = new Order();
        int choice;
        String name, phone, address;
        int category_id, supplier_id, price, count;
        int client_id, product_id, volume, count_product_volume;
        int num_products_order = 0, total_price = 0, num_products = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            info();
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка входного потока
            switch (choice) {
                case 1: {
                    System.out.print("Введите имя клиента: ");
                    name = scanner.nextLine();
                    System.out.print("Введите телефон клиента: ");
                    phone = scanner.nextLine();
                    System.out.print("Введите адрес клиента: ");
                    address = scanner.nextLine();
                    Client new_client = new Client(name, phone, address);
                    store.addClient(new_client);
                    System.out.println("Клиент добавлен! ");
                    break;
                }
                case 2: {
                    System.out.print("Введите название категории: ");
                    name = scanner.nextLine();
                    Category new_category = new Category(name);
                    store.addCategory(new_category);
                    System.out.println("Категория добавлена! ");
                    break;
                }
                case 3: {
                    System.out.print("Введите название поставщика: ");
                    name = scanner.nextLine();
                    System.out.print("Введите адрес поставщика: ");
                    address = scanner.nextLine();
                    System.out.print("Введите телефон поставщика: ");
                    phone = scanner.nextLine();
                    Supplier newSupplier = new Supplier(name, phone, address);
                    store.addSupplier(newSupplier);
                    System.out.println("Поставщик добавлен! ");
                    break;
                }
                case 4: {
                    do {
                        System.out.print("Введите ID категории (или 0 для выхода): ");
                        category_id = scanner.nextInt();
                        if (category_id < 0 || category_id > store.getNum_categories()) {
                            System.out.print("Неверный ID категории! ");
                        }
                    } while (category_id < 0 || category_id > store.getNum_categories());
                    if (category_id != 0) {
                        do {
                            System.out.print("Введите ID поставщика (или 0 для выхода): ");
                            supplier_id = scanner.nextInt();
                            if (supplier_id < 0 || supplier_id > store.getNum_suppliers()) {
                                System.out.print("Неверный ID поставщика! ");
                            }
                        } while (supplier_id < 0 || supplier_id > store.getNum_suppliers());
                        if (supplier_id != 0) {
                            scanner.nextLine(); // Очистка входного потока
                            System.out.print("Введите название товара: ");
                            name = scanner.nextLine();
                            System.out.print("Введите цену товара: ");
                            price = scanner.nextInt();
                            System.out.print("Введите количество товара: ");
                            count = scanner.nextInt();
                            Product newProduct = new Product();
                            newProduct.set(name, price, count, category_id, supplier_id);
                            storehouse.addProduct(newProduct);
                            System.out.print("Товар добавлен! ");
                        }
                    }
                    break;
                }
                case 5: {
                    num_products_order = 0;
                    total_price = 0;
                    do {
                        System.out.print("Введите ID клиента (или 0 для выхода): ");
                        client_id = scanner.nextInt();
                        if (client_id < 0 || client_id > store.getNum_categories())
                            System.out.print("Неверный ID клиента! ");
                    } while (client_id < 0 || client_id > store.getNum_clients());
                    if (client_id!=0){
                        System.out.print("Введите ID товара (или 0 для завершения): ");
                        product_id = scanner.nextInt();
                        while (product_id != 0) {
                            if (product_id > 0 && product_id <= storehouse.getNum_products()) {
                                Product newProduct = new Product();
                                newProduct = storehouse.listProducts(product_id - 1);
                                System.out.print("Введите количество товара: ");
                                volume = scanner.nextInt();
                                if (volume > 0 && volume <= newProduct.getCount()) {
                                    total_price += newProduct.getPrice() * volume;
                                    name = newProduct.getName();
                                    price = newProduct.getPrice();
                                    count = newProduct.getCount();
                                    category_id = newProduct.getCategory_id();
                                    supplier_id = newProduct.getSupplier_id();
                                    count_product_volume = count - volume;
                                    storehouse.editProduct(product_id - 1, name, price, count_product_volume, category_id, supplier_id);
                                    newProduct.set(name, price, volume, category_id, supplier_id);
                                    newOrder.addProduct(newProduct);
                                    num_products_order++;
                                } else System.out.println("Неверное количество товара!");
                            } else System.out.println("Неверный ID товара!");
                            System.out.println("Введите ID нового товара (или 0 для завершения): ");
                            product_id = scanner.nextInt();
                        }
                    }
                    if (num_products_order > 0) {
                        newOrder.set(client_id, num_products_order, total_price);
                        orderhistory.addOrder(newOrder);
                        System.out.println("Заказ создан!");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Список клиентов:");
                    for (int j = 0; j < store.getNum_clients(); j++) {
                        System.out.println("ID клиента: " + (j + 1));
                        Client newClient = new Client();
                        newClient = store.listClients(j);
                        name = newClient.getName();
                        phone = newClient.getPhone();
                        address = newClient.getAddress();
                        System.out.println("Имя клиента: " + name + ", Телефон: " + phone + ", Адрес: " + address);
                    }
                    break;
                }
                case 7: {
                    System.out.println("Список категорий:");
                    for (int j = 0; j < store.getNum_categories(); j++) {
                        System.out.print("ID категории: " + (j + 1) + "  ");
                        Category newCategory = new Category();
                        newCategory = store.listCategories(j);
                        name = newCategory.get();
                        System.out.println("Название категории: " + name);
                    }
                    break;
                }
                case 8: {
                    System.out.println("Список поставщиков:");
                    for (int j = 0; j < store.getNum_suppliers(); j++) {
                        System.out.print("ID поставщика: " + (j + 1) + "  ");
                        Supplier newSupplier = new Supplier();
                        newSupplier = store.listSuppliers(j);
                        name = newSupplier.getName();
                        phone = newSupplier.getPhone();
                        address = newSupplier.getAddress();
                        System.out.println("Название поставщика: " + name + ", Телефон: " + phone + ", Адрес: " + address);
                    }
                    break;
                }
                case 9: {
                    System.out.println("Список товаров:");
                    for (int j = 0; j < storehouse.getNum_products(); j++) {
                        System.out.print("ID товара: " + (j + 1) + "  ");
                        Product newProduct = new Product();
                        newProduct = storehouse.listProducts(j);
                        name = newProduct.getName();
                        price = newProduct.getPrice();
                        count = newProduct.getCount();
                        System.out.println("Название продукта: " + name + ", Цена: " + price + ", Количество: " + count);
                    }
                    break;
                }
                case 10: {
                    System.out.println("История заказов:");
                    for (int j = 0; j < orderhistory.getOrderCount(); j++) {
                        System.out.print("ID заказа: " + (j + 1) + "  ");
                        newOrder = orderhistory.listOrders(j);
                        client_id = newOrder.getClient_id();
                        num_products = newOrder.getNum_products();
                        total_price = newOrder.getTotal_price();
                        System.out.print(" ID клиента: " + client_id);
                        for (int a = 0; a < num_products; a++) {
                            System.out.print(" Товары: ");
                            System.out.print((a+1) + ". ");
                            Product newProduct = new Product();
                            newProduct = newOrder.listProducts(a);
                            name = newProduct.getName();
                            price = newProduct.getPrice();
                            count = newProduct.getCount();
                            System.out.println("Название продукта: " + name + ", Цена: " + price + ", Количество: " + count);
                        }
                        System.out.println("Общая стоимость: " + total_price);
                    }
                    break;
                }
                case 0: {
                    System.out.println("Выход...");
                    break;
                }
                default:
                    System.out.println("Неверный ввод. Пожалуйста, попробуйте еще раз.");
            }
        } while(choice != 0);
    }

    public static void info() {
        System.out.println("\nЗоомагазин Собачий Патруль");
        System.out.println("1. Добавить клиента");
        System.out.println("2. Добавить категорию");
        System.out.println("3. Добавить поставщика");
        System.out.println("4. Добавить товар");
        System.out.println("5. Создать заказ");
        System.out.println("6. Вывести список клиентов");
        System.out.println("7. Вывести список категорий");
        System.out.println("8. Вывести список поставщиков");
        System.out.println("9. Вывести список товаров");
        System.out.println("10. Вывести список заказов");
        System.out.println("0. Выход");
        System.out.println("Выберите действие: ");
    }
}
