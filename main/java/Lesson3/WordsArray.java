package Lesson3;

import java.util.*;
/*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
 слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
 */
public class WordsArray {
    private ArrayList<String> wordsArray = new ArrayList<String>();
    private int lengthWordsArray;

    public WordsArray(String... _wordsArray) {
        if (_wordsArray.length == 0) System.exit(1);
        for (String str: _wordsArray) {
            wordsArray.add(str);
        }
        this.lengthWordsArray = wordsArray.size();
    }

    public ArrayList<String> getWordsArray() {
        return wordsArray;
    }

    //Функция для вывода всех уникальных слов в массиве объекта
    public void showUniqueWords() {
        System.out.println(getUniqueWords());
    }

    //Функция для вывода сколько раз встречается каждое слово
    public void showNumberOfWordInstance(){
        HashMap<String, Integer> hm = this.getNumberOfWordInstance();
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        for (Map.Entry<String, Integer> o: set) {
            System.out.println("Слово \"" + o.getKey() + "\" встречается " + o.getValue() + " раз;");
        }
    }

    //Функция для отбора всех уникальных слов в массиве объекта.
    //Отбираем путём создания HashSet на основе исходных данных
    public HashSet<String> getUniqueWords() {
        HashSet<String> uniqueWords = new HashSet<>(this.wordsArray);
        return uniqueWords;
    }

    //Функция для подсчёта сколько раз встречается каждое слово.
    //Подсчитываем путём создания HashMap, где ключами являются уникальные слова, а значениями - количество повторов.
    public HashMap<String, Integer>  getNumberOfWordInstance(){
        HashMap<String, Integer> numberOfWordsInstances = new HashMap<>();
        for (String strUnique: this.getUniqueWords()) {
            int i = 0;                              //Счётчик повторов слов
            for (String strAll: this.wordsArray) {
                if (strUnique.equals(strAll)) i++;
            }
            numberOfWordsInstances.put(strUnique,i);
        }
        return numberOfWordsInstances;
    }
}
