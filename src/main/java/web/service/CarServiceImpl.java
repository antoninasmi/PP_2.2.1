package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Tesla", "Red", 123456));
        cars.add(new Car("Lexus", "Blue", 654321));
        cars.add(new Car("Mercedes", "Silver", 142563));
        cars.add(new Car("Maserati", "Black", 782569));
        cars.add(new Car("Peugeot", "White", 259146));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count > 5) {
            count = 5;
        }
        if (count < 0) {
            count = Math.abs(count);
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
