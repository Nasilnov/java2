package lesson5my;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arrHalv1 = new float[h];
    static float[] arrHalv2 = new float[h];


    public static void main(String[] args) {

        fillByOne();

        long a = System.currentTimeMillis();
        fillArr();
        System.out.println("Простой цикл - " + (System.currentTimeMillis() - a));

        fillByOne();

        a = System.currentTimeMillis();

        Runnable r1 = Main::fillArr1;
        Runnable r2 = Main::fillArr2;
        Thread tr1 = new Thread(r1);
        Thread tr2 = new Thread(r2);
        tr1.start();
        tr2.start();
        try {
            tr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            tr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arrHalv1, 0, arr, 0, h);
        System.arraycopy(arrHalv2, 0, arr, h, h);

        System.out.println("Потоки - " + (System.currentTimeMillis() - a));

    }

    public static void fillArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void fillArr1() {
        for (int i = 0; i < h; i++) {
            arrHalv1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    public static void fillArr2() {
        for (int i = 0; i <  h; i++) {
            arrHalv2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void fillByOne() {
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }
    }
}


