import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String carId;
    private String brand;
    private boolean isAvailable;

    public Car(String carId, String brand) {
        this.carId = carId;
        this.brand = brand;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class RentalSystem {
    private List<Car> cars;

    public RentalSystem() {
        cars = new ArrayList<>();
    }

    public void addCar(String carId, String brand) {
        Car car = new Car(carId, brand);
        cars.add(car);
        System.out.println("Car " + carId + " (" + brand + ") has been added to the rental system.");
    }

    public void rentCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.setAvailable(false);
                System.out.println("Car " + carId + " has been rented.");
                return;
            }
        }
        System.out.println("Car " + carId + " is not available for rent.");
    }

    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.setAvailable(true);
                System.out.println("Car " + carId + " has been returned.");
                return;
            }
        }
        System.out.println("Invalid car ID or car was not rented from this rental system.");
    }
}

public class carRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalSystem rentalSystem = new RentalSystem();

        while (true) {
            System.out.println("1. Add Car\n2. Rent Car\n3. Return Car\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter car ID: ");
                    String carId = scanner.nextLine();
                    System.out.print("Enter car brand: ");
                    String brand = scanner.nextLine();
                    rentalSystem.addCar(carId, brand);
                    break;
                case 2:
                    System.out.print("Enter car ID to rent: ");
                    carId = scanner.nextLine();
                    rentalSystem.rentCar(carId);
                    break;
                case 3:
                    System.out.print("Enter car ID to return: ");
                    carId = scanner.nextLine();
                    rentalSystem.returnCar(carId);
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}