
import java.util.Arrays;
import java.util.Scanner;

public class Question2_ArrayOperations {

    static void display(int[] arr, int n) {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int insert(int[] arr, int n, int pos, int value) {
        if (n == arr.length || pos < 0 || pos > n) {
            System.out.println("Invalid position or array is full.");
            return n;
        }
        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        return n + 1;
    }

    static int delete(int[] arr, int n, int pos) {
        if (pos < 0 || pos >= n) {
            System.out.println("Invalid position.");
            return n;
        }
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return n - 1;
    }

    static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static int binarySearch(int[] arr, int n, int key) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) return mid;
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array capacity: ");
        int capacity = sc.nextInt();

        if (capacity <= 0) {
            System.out.println("Capacity must be positive.");
            sc.close();
            return;
        }

        int[] arr = new int[capacity];
        int n;

        System.out.print("Enter number of elements (0 to "
                         + capacity + "): ");
        n = sc.nextInt();

        if (n < 0 || n > capacity) {
            System.out.println("Invalid number of elements.");
            sc.close();
            return;
        }

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n--- ARRAY MENU ---");
            System.out.println("1. Display");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Find Maximum");
            System.out.println("7. Count Even and Odd");
            System.out.println("8. Insertion Sort");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    display(arr, n);
                    break;

                case 2:
                    System.out.print("Enter index (0 to " + n + "): ");
                    int ip = sc.nextInt();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    n = insert(arr, n, ip, value);
                    break;

                case 3:
                    System.out.print("Enter index to delete: ");
                    int dp = sc.nextInt();
                    n = delete(arr, n, dp);
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    int lk = sc.nextInt();
                    int li = linearSearch(arr, n, lk);
                    System.out.println(li == -1 ? "Not found"
                            : "Found at index " + li);
                    break;

                case 5:
                    System.out.print("Enter value to search: ");
                    int bk = sc.nextInt();
                    insertionSort(arr, n);
                    int bi = binarySearch(arr, n, bk);
                    System.out.println(bi == -1 ? "Not found"
                            : "Found at sorted index " + bi);
                    break;

                case 6:
                    if (n == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        int max = arr[0];
                        for (int i = 1; i < n; i++) {
                            if (arr[i] > max) max = arr[i];
                        }
                        System.out.println("Maximum: " + max);
                    }
                    break;

                case 7:
                    int even = 0, odd = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0) even++;
                        else odd++;
                    }
                    System.out.println("Even: " + even);
                    System.out.println("Odd: " + odd);
                    break;

                case 8:
                    insertionSort(arr, n);
                    System.out.println("Sorted array:");
                    display(arr, n);
                    break;

                case 9:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);

        sc.close();
    }
}
