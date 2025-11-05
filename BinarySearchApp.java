import java.util.Scanner;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}

public class BinarySearchApp {

    // Binary Search method
    static int binarySearch(Student[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid].rollNo == key)
                return mid;
            else if (arr[mid].rollNo < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] s = new Student[n];

        System.out.println("\nEnter student roll number (in sorted order) and name:");
        for (int i = 0; i < n; i++) {
            System.out.print("Roll No: ");
            int r = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String nm = sc.nextLine();
            s[i] = new Student(r, nm);
        }

        System.out.print("\nEnter roll number to search: ");
        int key = sc.nextInt();

        int result = binarySearch(s, key);

        if (result == -1)
            System.out.println("\nStudent not found!");
        else
            System.out.println("\nStudent found: Roll No " + s[result].rollNo + " - Name: " + s[result].name);
        
        sc.close();
    }
}
