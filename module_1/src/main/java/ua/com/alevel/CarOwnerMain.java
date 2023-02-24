package ua.com.alevel;

import ua.com.alevel.entity.Car;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.storage.EntityStorage;

public class CarOwnerMain {

    public static void main(String[] args) {
        EntityStorage storage = new EntityStorage();

        Car car = new Car();
        car.setCarBrand("BMW");
        car.setCarModel("X7");
        car.setVinCode("VinCode1");
        storage.addCar(car);

        car = new Car();
        car.setCarBrand("BMW");
        car.setCarModel("X6");
        car.setVinCode("VinCode2");
        storage.addCar(car);

        car = new Car();
        car.setCarBrand("BMW");
        car.setCarModel("X5");
        car.setVinCode("VinCode3");
        storage.addCar(car);

        Car[] cars = storage.findAllCars();
        for (Car car1 : cars) {
            if (car1 != null) {
                System.out.println("car = " + car1);
            }
        }

        Owner owner = new Owner();
        owner.setFirstName("Owner1");
        owner.setLastName("Owner2");
        storage.addOwner(owner);

        Owner[] owners = storage.findAllOwners();

        for (Owner owner1 : owners) {
            if (owner1 != null) {
                System.out.println("owner = " + owner1);
            }
        }

        storage.attachCarToOwner(1, 1);
        storage.attachCarToOwner(3, 1);

        Car[] carsByOwner = storage.findCarsByOwner(1);

        for (Car car1 : carsByOwner) {
            if (car1 != null) {
                System.out.println("car by owner = " + car1);
            }
        }
    }
}