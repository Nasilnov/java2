package lesson2;

import javax.swing.*;
import java.net.SocketOption;
import java.sql.Array;

public class Main {

    public static void main(String[] args) {
//        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] arrStr  = new String[4][4];
        System.out.println("Создаем массив");
        try {
            arrStr = StringToArray(str);
            for (int i = 0; i < arrStr.length; i++  ) {
                for (int j = 0; j < arrStr[i].length; j++ ) {
                    System.out.printf("%5s ", arrStr[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Складываем и делим");
        try {
            System.out.println(convertAndManipulateArr(arrStr));
        } catch (Exception e) {
            e.printStackTrace();
        }


        // write your code here
    };

    public static String[][] StringToArray( String str ) throws Exception {

        String[][] arr = new String[4][4];

        String[] arr1 = str.split("\\n");

        if (arr1.length != 4) throw new Exception("the number of rows should be 4");

        for ( int i = 0; i < arr1.length; i++ ) {
            String[] arr2 = arr1[i].split(" ");
            if (arr2.length != 4) throw new Exception("the number of columns should be 4");
            for (int j = 0; j < arr2.length; j ++ ) {
                arr[i][j] = arr2[j];
            }
        }
        return arr;
    };

    public static float convertAndManipulateArr(String[][] arr) throws Exception {
        float resultArray = 0;
        for (int i = 0; i < arr.length; i++ ) {
            for (int j = 0; j < arr.length; j++ ) {
                try {
                    resultArray += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    throw new Exception("the array element is not a number");
                }
            }
        }
        return (float) resultArray / 2;
    }
}