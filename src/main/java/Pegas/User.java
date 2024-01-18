package Pegas;

public class User {
    private final String name;
    private final String country;
    private final int age;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public User(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }
}
