package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public int count(List<Car> cars) {
        int count = 0;
        for (Car car : cars) {
            count++;
        }
        return count;
    }
}
