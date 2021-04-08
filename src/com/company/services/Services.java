package com.company.services;

import com.company.enums.AbonentStatus;
import com.company.models.People;
import com.company.models.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Services {

    List<Person> personList = new ArrayList<>();
    public void createPerson() {
        Person stalin = new Person("Сталин", AbonentStatus.ACTIVE, 21);
        Person lenin = new Person("Ленин", AbonentStatus.ACTIVE, 11);
        Person brezhnev = new Person("Брежнев", AbonentStatus.ACTIVE, 50);
        Person yeltsin = new Person("Ельцин", AbonentStatus.ACTIVE, 100);
        Person zhyldyzbek = new Person("Жылдызбек", AbonentStatus.ACTIVE, 85);
        Person gorbachev = new Person("Горбачев", AbonentStatus.ACTIVE, 15);
        Person malinkov = new Person("Малинков", AbonentStatus.INACTIVE, 23);
        Person khrushchev = new Person("Хрущев", AbonentStatus.INACTIVE, -2);
        Person akaev = new Person("Акаев", AbonentStatus.INACTIVE, 22);
        personList.add(stalin);
        personList.add(lenin);
        personList.add(brezhnev);
        personList.add(yeltsin);
        personList.add(zhyldyzbek);
        personList.add(gorbachev);
        personList.add(malinkov);
        personList.add(khrushchev);
        personList.add(akaev);
        System.out.println("----------------Работа с map, filter------------------");

        System.out.println("----------------Полный список---------------- ");
        for (Person item: personList) {
            System.out.println(item.getName()+" - "+item.getMoneyOnPhone()+" - "+item.getAbonentStatus());
        }

        System.out.println("----------------После фильтра----------------");
        System.out.println("Фильтр проходил на основе денег на телефоне > 20" +
                ". Статус абонента ACTIVE: ");

        List<Person> personListFilterMap = personList.stream()
                .filter(person -> person.getMoneyOnPhone() >= 20)
                .filter(person -> person.getAbonentStatus()==AbonentStatus.ACTIVE)
                .collect(Collectors.toList());

        for (Person item: personListFilterMap) {
            System.out.println(item.getName()+" - "+item.getMoneyOnPhone()+" - "+item.getAbonentStatus());
        }
        System.out.println("----------------Всем нашим активным абонентам к балансу +50----------------");
        List<Double> personMoney = personListFilterMap.stream()
                .map(person -> person.getMoneyOnPhone()+50)
                .collect(Collectors.toList());

        Map<String , Double> personDoubleMap = new LinkedHashMap<>();
        for (int i = 0; i<personListFilterMap.size(); i++){
            personDoubleMap.put(personListFilterMap.get(i).getName(), personMoney.get(i));
        }
        for (Map.Entry entry: personDoubleMap.entrySet()){
            System.out.println(entry.getKey()+ " - "+entry.getValue());
        }


        System.out.println("----------------Работа с flatMap------------------");
        List<People> peoples = new ArrayList<>();
        People stalin1 = new People("Сталин", AbonentStatus.ACTIVE, List.of("MI", "Apple"));
        People lenin1 = new People("Ленин", AbonentStatus.ACTIVE, List.of("ASUS", "Fly"));
        People brezhnev1 = new People("Брежнев", AbonentStatus.ACTIVE, List.of("Huawei", "Iphone"));
        People yeltsin1 = new People("Ельцин", AbonentStatus.ACTIVE, List.of("Lenovo", "Meizu"));
        People zhyldyzbek1 = new People("Жылдызбек", AbonentStatus.ACTIVE, List.of("Microsoft", "Nokia"));
        peoples.add(stalin1);
        peoples.add(lenin1);
        peoples.add(brezhnev1);
        peoples.add(yeltsin1);
        peoples.add(zhyldyzbek1);

        System.out.println("Все марки телефонов заменены на их числовую длинну");
        List<String> ownersTelephones = peoples.stream()
                .flatMap(people -> people.getAbonentTelephones().stream())
                .collect(Collectors.toList());
        System.out.println(ownersTelephones);

        List<Integer> list = ownersTelephones.stream()
                .map(i -> i.length())
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
