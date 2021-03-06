package Lesson3;

/**
 * Java. Level 2. Lesson 3.
 *
 * @author Ivan Dudorov
 *
 Задание:
 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
 слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.

 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер
 телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.

 Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять
 еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
 Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 */

public class Main {
    public static void main(String[] args) {
        //Задание 1
        System.out.println("\nЗадание 1!");
        WordsArray wa = new WordsArray("Земля", "Земля", "Луна", "Луна", "Венера", "Марс", "Меркурий", "Плутон");
        System.out.println("Исходный массив слов: " + wa.getWordsArray());
        System.out.print("Массив уникальных записей:");
        wa.showUniqueWords();
        System.out.println("В исходном массиве:");
        wa.showNumberOfWordInstance();


        //Задание 2
        System.out.println("\nЗадание 2!");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.showPhoneBook();
        phoneBook.add("Иванов", "+79246014850");
        phoneBook.add("Иванов", "");
        phoneBook.add("", "5522");
        phoneBook.showPhoneBook();
        phoneBook.add("Петров", "650025");
        phoneBook.showPhoneBook();
        phoneBook.add("Сидоров", "524895");
        phoneBook.add("Иванов", "524895");
        phoneBook.showPhoneBook();
        System.out.println("\nРабота метода \"get\":");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Сусанин"));
        System.out.println(phoneBook.get(""));
    }


}
