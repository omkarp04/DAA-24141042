import java.util.Scanner;

public class QuickSortApp {

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void display(int arr[]) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int marks[] = new int[n];
        System.out.println("Enter marks of students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Marks[" + (i + 1) + "]: ");
            marks[i] = sc.nextInt();
        }
        System.out.println("\nMarks before sorting:");
        display(marks);
        quickSort(marks, 0, n - 1);
        System.out.println("\nMarks after sorting (Ascending):");
        display(marks);
        sc.close();
    }
}
