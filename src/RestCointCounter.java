import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RestCointCounter {

    public static void main(String[] args) {
        Map<Integer, Integer> bilon = new HashMap<>();
        bilon.put(500, 1);
        bilon.put(200, 3);
        bilon.put(100, 5);
        bilon.put(50, 10);
        bilon.put(20, 20);
        bilon.put(10, 200);
        bilon.put(5, 100);
        bilon.put(2, 100);
        bilon.put(1, 10000);

        counter(1.25, bilon);
        counter(6.79, bilon);
        counter(100, bilon);
        counter(55, bilon);


    }

    public static void counter(double rest, Map<Integer, Integer> bilon) {

        int rest1 = (int) (rest * 100);
        int[] arr = new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1};
        Map<Integer, Integer> ans = new HashMap<>();
        ans.put(500, 0);
        ans.put(200, 0);
        ans.put(100, 0);
        ans.put(50, 0);
        ans.put(20, 0);
        ans.put(10, 0);
        ans.put(5, 0);
        ans.put(2, 0);
        ans.put(1, 0);

        if (countRest(0, arr, rest1, ans, bilon)) {

            System.out.println("Dla reszty: " + rest);
            ans.forEach((key, value) -> {
                switch (key) {
                    case 1 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 1 groszy");
                    }
                    case 2 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 2 grosze");
                    }
                    case 5 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 5 groszy");
                    }
                    case 10 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 10 groszy");
                    }
                    case 20 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 20 groszy");
                    }
                    case 50 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 50 groszy");
                    }
                    case 100 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 1 Złoty");
                    }
                    case 200 -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 2 Złote");
                    }
                    default -> {
                        if (value > 0) System.out.println("Wydaj " + value + " x 5 Zotych");
                    }
                }
            });
        }
    }

    public static boolean countRest(int index, int[] arr, int rest,
                                    Map<Integer, Integer> ans, Map<Integer, Integer> bilon) {

        if (rest == 0 && index < arr.length) {
            return true;
        } else if (rest != 0 && index >= arr.length) {
            System.out.println("-----Dla kolejnej reszty za mało monet!----");
            return false;
        }

        if (index == 8 && arr[index] * 100 <= rest && bilon.get(arr[index]) > 100) {
            ans.put(arr[index], ans.get(arr[index]) + 100);
            bilon.put(arr[index], (bilon.get(arr[index]) - 100));
            return countRest(index, arr, rest - arr[index] * 100, ans, bilon);
        } else if ((arr[index] <= rest) && bilon.get(arr[index]) > 0) {
            ans.put(arr[index], ans.get(arr[index]) + 1);
            bilon.put(arr[index], (bilon.get(arr[index]) - 1));
            return countRest(index, arr, rest - arr[index], ans, bilon);
        } else {
            return countRest(index + 1, arr, rest, ans, bilon);
        }
    }
}