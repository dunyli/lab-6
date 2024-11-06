public class Store {
    private Client[] clients;
    private int num_clients;
    private Category[] categories;
    private int num_categories;
    private Supplier[] suppliers;
    private int num_suppliers;

    //Конструктор класса Store
    public Store() {
        num_clients = 0;
        num_categories = 0;
        num_suppliers = 0;
    }
    //Добавление класса Client в класс Store
    public void addClient(Client client) {
        Client[] newClients = new Client[num_clients + 1];
        for (int i = 0; i < num_clients; i++) {
            newClients[i] = clients[i];
        }
        newClients[num_clients] = client;
        clients = newClients;
        num_clients++;
    }
    //Добавление класса Category в класс Store
    public void addCategory(Category category) {
        Category[] newCategories = new Category[num_categories + 1];
        for (int i = 0; i < num_categories; i++) {
            newCategories[i] = categories[i];
        }
        newCategories[num_categories] = category;
        categories = newCategories;
        num_categories++;
    }
    //Добавление класса Supplier в класс Store
    public void addSupplier(Supplier supplier) {
        Supplier[] newSuppliers = new Supplier[num_suppliers + 1];
        for (int i = 0; i < num_suppliers; i++) {
            newSuppliers[i] = suppliers[i];
        }
        newSuppliers[num_suppliers] = supplier;
        suppliers = newSuppliers;
        num_suppliers++;
    }

    //Вывод данных класса
    public int getNum_suppliers() {
        return num_suppliers;
    }
    //Вывод данных класса
    public int getNum_categories() {
        return num_categories;
    }
    //Вывод данных класса
    public int getNum_clients() {
        return num_clients;
    }

    public Client listClients(int count) {
        for (int i = 0; i < num_clients; i++) {
            if (i == count) return clients[i];
        }
        return null;
    }

    public Supplier listSuppliers(int count) {
        for (int i = 0; i < num_suppliers; i++) {
            if (i == count) return suppliers[i];
        }
        return null;
    }

    public Category listCategories(int count) {
        for (int i = 0; i < num_categories; i++) {
            if (i == count) return categories[i];
        }
        return null;
    }
}
