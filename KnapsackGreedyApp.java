import java.util.*;

class Item {
    int weight;
    int profit;
    double ratio;
    Item(int w, int p) {
        weight = w;
        profit = p;
        ratio = (double)p / w;
    }
}

public class KnapsackGreedyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            int w = sc.nextInt();
            int p = sc.nextInt();
            items[i] = new Item(w, p);
        }
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double totalProfit = 0.0;
        int currentWeight = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalProfit += item.profit;
            } else {
                int remain = capacity - currentWeight;
                totalProfit += item.profit * ((double) remain / item.weight);
                break;
            }
        }
        System.out.println("\nMaximum Profit = " + totalProfit);
        sc.close();
    }
}
