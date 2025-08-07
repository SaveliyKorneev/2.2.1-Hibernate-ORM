package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Name1", "LastName1", "user1@mail.ru");
        Car car1 = new Car("Ford", 777);
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("Name2", "LastName2", "user2@mail.ru");
        Car car2 = new Car("Haval", 999);
        user1.setCar(car2);
        userService.add(user2);

        User user3 = new User("Name3", "LastName3", "user3@mail.ru");
        Car car3 = new Car("BMW", 555);
        user1.setCar(car3);
        userService.add(user3);

        User user4 = new User("Name4", "LastName4", "user4@mail.ru");
        Car car4 = new Car("Subaru", 333);
        user1.setCar(car4);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        //позвотели по машине
        User userByCar = userService.getUserByCar("Ford", 777);
        System.out.println("User by car " + userByCar.getCar().getModel() + " " + userByCar.getCar().getSeries() + " " + userByCar);

        context.close();
    }
}
