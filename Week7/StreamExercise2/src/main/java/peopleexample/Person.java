package peopleexample;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String homeState;

    public Person(String firstName, String lastName, int age, String homeState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeState = homeState;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
