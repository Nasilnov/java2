package lesson3;

import lesson3teach.Main;

import java.util.*;

public class phone {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addAbonent(new Person("Иванов","Иван","jhjhj@mail.ru","+792199966998"));
        phoneBook.addAbonent(new Person("Иванов","Василий","aakkkaa@ail.ru","+791188866998"));
        phoneBook.addAbonent(new Person("Петров","Сергей","assaaa@ail.ru","+793188866998"));
        phoneBook.addAbonent(new Person("Петров","Серж","addd@ail.ru","+793188866998"));
        phoneBook.addAbonent(new Person("Семенов","Николай","dfdfdf@ail.ru","+71865666998"));

        System.out.println("Телефоны на фамилию - Иванов");
        for (String phone : phoneBook.getPhones("Иванов")){
            System.out.println(phone);
        };

        System.out.println("Телефоны на фамилию - Петров");
        for (String phone : phoneBook.getPhones("Петров")){
            System.out.println(phone);
        };

        System.out.println("Адреса email на фамилию - Иванов");
        for (String email : phoneBook.getEmail("Иванов")){
            System.out.println(email);
        };

    }

    public static class PhoneBook {
        Map<String, Set<Person>> phonebook = new HashMap<>();

        public void addAbonent(Person person) {
            if (phonebook.containsKey(person.surname)) {
                int count  = 0;
                for (Person persphonebook :  phonebook.get(person.surname)) {
                    if (!person.equals(persphonebook)) {
                        count++;
                    }
                }
                if (count > 0) {
                    phonebook.get(person.surname).add(person);
                }
            }
            else {
                this.phonebook.put(person.surname, new HashSet<>());
                this.phonebook.get(person.surname).add(person);
            }
        }

        public ArrayList<String> getPhones(String surname) {
            ArrayList<String> arr =  new ArrayList<>();

            for (Person person  : this.phonebook.get(surname)) {
                arr.add(person.phone);
            }
            return arr;
        }

        public ArrayList<String> getEmail(String surname) {
            ArrayList<String> arr =  new ArrayList<>();

            for (Person person  : this.phonebook.get(surname)) {
                arr.add(person.email);
            }
            return arr;
        }
    }

    public static class Person {
        String surname;
        String name;
        String email;
        String phone;

        public Person(String surname, String name, String email, String phone) {
            this.surname = surname;
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Person)) return false;
            Person p = (Person) obj;
            return this.surname == p.surname && this.phone == p.phone && this.email == p.email;
        }
    }
}
