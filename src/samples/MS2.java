package samples;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));

        sc.close();
    }

    static int solve(int[] arr) {
        Map<Integer, Integer> sortedMap = IntStream.range(0, arr.length).boxed()
                .collect(Collectors.toMap(i -> arr[i], i -> i));

        int swapNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int indexToSwap = sortedMap.get(i + 1);

                sortedMap.put(arr[i], indexToSwap);
                sortedMap.put(i + 1, i);

                int temp = arr[i];
                arr[i] = arr[indexToSwap];
                arr[indexToSwap] = temp;

                swapNum++;
            }
        }
        return swapNum;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
