package com.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String address;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setAddress(final String address) {
        this.address = address;
    }
}
