package Lesson3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *  2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер
 телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneBook {
    HashMap<String, LinkedList<String>> phoneBook = new HashMap<>();

    //Получение списка телефонов по указанному имени
    public LinkedList<String> get(String _name){
        LinkedList<String> phones = new LinkedList<>();
        if (_name == null || _name == "") return phones;

        //Получаем список телефонов для данного абонента
        if(this.phoneBook.containsKey(_name)) {
            phones = this.phoneBook.get(_name);
        }
        return phones;
    }

    //Функция для добавления новой записи в телефонную книгу
    public void add(String _name, String _phone){
        if (_name == null || _name == "" || _phone == null || _phone == "") return;

        LinkedList<String> phones;
        phones = this.get(_name);            //Получаем список телефонов для данного абонента
        phones.addLast(_phone);     //Добавляем к списку телефонов абонента новый телефон
        this.phoneBook.put(_name, phones);  //Обновляем запись в телефонной книге
    }

    //Вывод всей телефонной книги
    public void showPhoneBook(){
        HashMap<String, LinkedList<String>> hm = this.phoneBook;
        Set<Map.Entry<String, LinkedList<String>>> set = hm.entrySet();
        System.out.println("ТЕЛЕФОННАЯ КНИГА");
        System.out.println("_________________________________________________________");
        System.out.println("|   Имя         |                 Телефон                |");
        for (Map.Entry<String, LinkedList<String>> o: set) {
            System.out.println("| " + o.getKey() + " | " + o.getValue() + ";");
        }
        System.out.println("_________________________________________________________");
    }
}