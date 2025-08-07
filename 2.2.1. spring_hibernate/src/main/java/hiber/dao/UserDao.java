package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
    @SuppressWarnings("unchecked")
    List<Car> listCar();
    User getUserByCar(String model, int serias);
}
