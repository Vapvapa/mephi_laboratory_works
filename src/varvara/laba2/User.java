package varvara.laba2;
import java.util.*;

class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    public User(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age + ", country='" + country + '\'' + '}';
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User(1, "John", "Doe", 30, "USA"),
                new User(2, "Jane", "Smith", 25, "Canada"),
                new User(3, "Alice", "Johnson", 10, "USA"),
                new User(4, "Bob", "Brown", 20, "UK"),
                new User(5, "Charlie", "Davis", 40, "Canada")
        ));

        System.out.println("Sorted by last name:");
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);

        System.out.println("\nSorted by age:");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);

        boolean allAgeAbove7 = users.stream()
                .allMatch(user -> user.getAge() > 7);
        System.out.println("\nAll users are older than 7: " + allAgeAbove7);

        double averageAge = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage age: " + averageAge);

        long distinctCountries = users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
        System.out.println("\nNumber of different countries: " + distinctCountries);
    }
}