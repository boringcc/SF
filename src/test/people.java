package test;

public class people {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public people() {
    }

    public people(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int age;
    private String name;


}
