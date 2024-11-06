public class Client {
    private String name;
    private String phone;
    private String address;

    //Конструктор  класса Client
    public Client() {
    }
    //Конструктор с параметрами класса Client
    public Client(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    //Получение данных класса
    public void set(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
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
}
