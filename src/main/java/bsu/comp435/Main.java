package bsu.comp435;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        // Call the radixSort function
        radixSort(array);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));
    }
    public static void radixSort(int[] A) {
        // Find the maximum number to know the number of digits
        if (A.length == 0) {
            return;
        }
        int max = getMax(A);

        // Do Insertion Sort for every digit (place: 1 for ones, 10 for tens, etc.)
        for (int place = 1; max / place > 0; place *= 10) {
            insertionSortByDigit(A, place);
        }
    }

    // Function to perform Insertion Sort based on the digit represented by 'place'
    private static void insertionSortByDigit(int[] A, int place) {
        int n = A.length;

        // Traverse through elements in the array
        for (int i = 1; i < n; i++) {
            int current = A[i];
            int digit = (current / place) % 10;
            int j = i - 1;

            // Move elements of A[0..i-1] that are greater than current digit
            while (j >= 0 && ((A[j] / place) % 10) > digit) {
                A[j + 1] = A[j];
                j = j - 1;
            }

            // Insert the current element at the found location
            A[j + 1] = current;
        }
    }

    // Function to get the maximum element from the array
    private static int getMax(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
}
