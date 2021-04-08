package com.company;
import com.company.services.Services;

public class Main {

    public static void main(String[] args) {
        Services services = new Services(); // <- это реализационный класс
        services.createPerson();
    }
}
