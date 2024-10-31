package varvara.laba2;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class UserService {
    // Метод для вывода всех пользователей, отсортированных по lastName
    public List<User> getUsersSortedByLastName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .collect(Collectors.toList());
    }

    // Метод для вывода всех пользователей, отсортированных по age
    public List<User> getUsersSortedByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    // Метод для проверки, что для всех пользователей age > 7
    public boolean areAllAgesGreaterThanSeven(List<User> users) {
        return users.stream().allMatch(user -> user.getAge() > 7);
    }

    // Метод для вычисления среднего возраста всех пользователей
    public OptionalDouble calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average();
    }

    // Метод для вывода количества разных стран проживания для пользователей с переданным id
    public long countDistinctCountriesById(List<User> users, List<Integer> userIds) {
        return users.stream()
                .filter(user -> userIds.contains(user.getId()))
                .map(User::getCountry)
                .toList()
                .stream()
                .distinct()
                .count();
    }
}
