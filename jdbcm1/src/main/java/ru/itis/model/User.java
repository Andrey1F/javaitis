package ru.itis.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private String city;
    private List<Auto> autos;

    //region   Getters <------------

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public String getCity() {
        return city;
    }

//endregion


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", autos=" + autos +
                '}';
    }



    // Time for builder pattern!!!

    private User(int id, String name, int age, String city, List<Auto> autos) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.autos = autos;
    }


    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String city;
        private List<Auto> autos = new ArrayList<Auto>();

        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setCity(String  city) {
            this.city = city;
            return this;
        }
        public Builder setAutos(List<Auto> autos) {
            this.autos = autos;
            return this;
        }

        public User build() {
            return new User(this.id, this.name, this.age, this.city, this.autos);
        }
    }



}
