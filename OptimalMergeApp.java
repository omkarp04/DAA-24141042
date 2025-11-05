import java.util.*;

public class OptimalMergeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of files: ");
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("Enter sizes of files:");
        for (int i = 0; i < n; i++)
            pq.add(sc.nextInt());
        int totalCost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int mergeCost = first + second;
            totalCost += mergeCost;
            pq.add(mergeCost);
        }
        System.out.println("\nMinimum total merge cost: " + totalCost);
        sc.close();
    }
}
