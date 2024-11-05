package com.mycompany.l6_mockito;

public class Person {

    private int id;
    private String name;
    private int age;

    public static Person scannedPerson(PersonDataReader pdr)
    {
        int id;
        String name;
        int age;

        id = pdr.getID();
        name = pdr.getName();
        age = pdr.getAge();

        return new Person(id, name, age);
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)  return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        final Person other = (Person) obj;

        if(other.id != this.id) return false;
        if(other.name != this.name) return false;
        if(other.age != this.age) return false;

        return true;
    }
}
