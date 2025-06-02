class Car{
    String make;
    String model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("car make: " + make);
        System.out.println("Car model: " + model);
        System.out.println("year: " + year);
    }

}
public class Task17 {
    public static void main(String[] args) {
        Car obj = new Car("Ford", "Alcazar", 2028);
        obj.displayDetails();
    }
}
