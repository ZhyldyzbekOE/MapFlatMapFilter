package com.company.models;

import com.company.enums.AbonentStatus;


public class Person {

    // для map, filter
   private String name;
   private AbonentStatus abonentStatus;
   private double moneyOnPhone;

    public Person(String name, AbonentStatus abonentStatus, double moneyOnPhone) {
        this.name = name;
        this.abonentStatus = abonentStatus;
        this.moneyOnPhone = moneyOnPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbonentStatus getAbonentStatus() {
        return abonentStatus;
    }

    public void setAbonentStatus(AbonentStatus abonentStatus) {
        this.abonentStatus = abonentStatus;
    }

    public double getMoneyOnPhone() {
        return moneyOnPhone;
    }

    public void setMoneyOnPhone(double moneyOnPhone) {
        this.moneyOnPhone = moneyOnPhone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", abonentStatus=" + abonentStatus +
                ", moneyOnPhone=" + moneyOnPhone +
                '}';
    }
}
