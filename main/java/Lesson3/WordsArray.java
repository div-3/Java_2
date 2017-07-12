package Lesson3;

import java.util.*;

/**
 * Created by Dudorov on 12.07.2017.
 */
public class WordsArray {
    private ArrayList<String> wordsArray = new ArrayList<String>();
    private int lengthWordsArray;

    public WordsArray(String... _wordsArray) {
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

    //Функция для отбора всех уникальных слов в массиве объекта
    public HashSet<String> getUniqueWords() {
        HashSet<String> uniqueWords = new HashSet<String>(this.wordsArray);
        return uniqueWords;
    }

    //Функция для подсчёта сколько раз встречается каждое слово
    public HashMap<String, Integer>  getNumberOfWordInstance(){
        HashMap<String, Integer> numberOfWordsInstances = new HashMap<>();
        for (String strUnique: this.getUniqueWords()) {
            int i = 0;  //Счётчик повторов слов
            for (String strAll: this.wordsArray) {
                if (strUnique.equals(strAll)) i++;
            }
            numberOfWordsInstances.put(strUnique,i);
        }
        return numberOfWordsInstances;
    }
}
