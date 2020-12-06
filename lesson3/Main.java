package lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str = "Машина  едет  по горам, по горам, по горам, везет лекарство докторам, докторам. Будут все здоровы, здоровы, здоровы. Радуются люди и даже коровы.";
        String strNew = str.toLowerCase().replaceAll("[^a-zA-ZА-Яа-я0-9]", " ");


//        Найти список слов, из которых состоит текст (дубликаты не считать);
        Set<String> set = new HashSet<>(Arrays.asList(strNew.split("\\s+")));
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println("\n");

//        Посчитать сколько раз встречается каждое слово (использовать HashMap);

        Map<String, Integer> map = new HashMap<>();
        String[] arr = strNew.split("\\s+");

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
             map.put(arr[i], map.get(arr[i]) +1);
            }
            else {
            map.put(arr[i],  1);
            }
        }

        Iterator<Map.Entry<String, Integer>> itermap = map.entrySet().iterator();
        while (itermap.hasNext()) {
            Map.Entry<String, Integer> entry = itermap.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
