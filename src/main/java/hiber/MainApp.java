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

      User user1 = new User("Tony", "Gemar", "s.antonina.g@gmail.com");
      User user2 = new User("Adam", "Gemar", "a.j.gemar@gmail.com");
      User user3 = new User("Kate", "Black", "kate.in.black@gmail.com");
      User user4 = new User("Valentin", "Kulakov", "v.kulakov@gmail.com");

      user1.setCar(new Car("Model1", 123456));
      user2.setCar(new Car("Model2", 654321));
      user3.setCar(new Car("Model3", 254163));
      user4.setCar(new Car("Model4", 145236));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      for (User user : users) {
         System.out.println(userService.getUserByCar(user.getCar()));
      }

      context.close();
   }

}
