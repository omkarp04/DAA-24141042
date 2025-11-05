import java.io.*;
import java.util.*;

public class FileMergeApp {
    public static void main(String[] args) {
        try {
            Scanner f1 = new Scanner(new File("file1.txt"));
            Scanner f2 = new Scanner(new File("file2.txt"));
            PrintWriter f3 = new PrintWriter("merged.txt");

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            while (f1.hasNextInt())
                list1.add(f1.nextInt());
            while (f2.hasNextInt())
                list2.add(f2.nextInt());

            int i = 0, j = 0;
            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i) <= list2.get(j)) {
                    f3.print(list1.get(i) + " ");
                    i++;
                } else {
                    f3.print(list2.get(j) + " ");
                    j++;
                }
            }

            while (i < list1.size())
                f3.print(list1.get(i++) + " ");
            while (j < list2.size())
                f3.print(list2.get(j++) + " ");

            f1.close();
            f2.close();
            f3.close();

            System.out.println("Files merged successfully into merged.txt");
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
