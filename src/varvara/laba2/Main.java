package varvara.laba2;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Иван", "Иванов", 25, "Россия");
        User user2 = new User(2, "Даниил", "Сидоров", 30, "Россия");
        User user3 = new User(3, "Надежда", "Петрова", 22, "Белоруссия");
        User user4 = new User(4, "Кирилл", "Рогожкин", 35, "Армения");
        User user5 = new User(5, "Мария", "Лебедева", 5, "Грузия");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        UserService userService = new UserService();

        // Вывод пользователей, отсортированных по lastName
        System.out.println("Пользователи, отсортированные по имени: " + userService.getUsersSortedByLastName(users));

        // Вывод пользователей, отсортированных по age
        System.out.println("Пользователи, отсортированные по возрасту: " + userService.getUsersSortedByAge(users));

        // Проверка, что для всех пользователей age > 7
        boolean allOlderThan7 = userService.areAllAgesGreaterThanSeven(users);
        System.out.println("Возраст всех пользователей больше 7: " + allOlderThan7);

        // Вывод среднего возраста всех пользователей
        OptionalDouble averageAge = userService.calculateAverageAge(users);
        averageAge.ifPresent(avg -> System.out.println("Средний возраст: " + avg));

        // Вывод количества разных стран проживания (country) среди заданных пользователей
        long distinctCountries = userService.countDistinctCountriesById(users, Arrays.asList(1, 3, 4));
        System.out.println("Количество разных стран проживания для заданных пользователей: " + distinctCountries);
    }
}
