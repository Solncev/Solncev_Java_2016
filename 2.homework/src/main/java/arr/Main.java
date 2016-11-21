package arr;

/**
 * Created by Марат on 15.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 1, 0, 3, 0};
        int result = 0;
        for (int x : a) {
            result = result ^ x;
        }
        System.out.println(result);
    }
}
