package OOPS;

public class Abstraction {
    
}

abstract class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract method (no body)
    abstract void startEngine();

    void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}
