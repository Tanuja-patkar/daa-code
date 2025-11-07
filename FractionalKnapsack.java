import java.util.Scanner;

class Item {
    int weight;
    int value;
    double ratio;  // value/weight ratio

    Item(int value, int weight) { //Constructor to initialize an Item with value and weight.
        this.value = value;  //Refers to the current object’s value and weight.
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {

    static void fractionalKnapsack(Item[] items, int n, int capacity) {
        // Sort items by value/weight ratio in descending order (Greedy Step)
        //Nested loops → Compare each item with others to sort.
        //swapping
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (items[i].ratio < items[j].ratio) {
                    Item temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }

        double totalValue = 0.0;
        int remainingCapacity = capacity;
        /* items[i].weight <= remainingCapacity → Check if whole item can be added.

totalValue += items[i].value → Add full value to total.

remainingCapacity -= items[i].weight → Reduce remaining capacity.

Print statement → Shows item taken completely (1 (Full)).*/

        System.out.println("\nItem\tWeight\tValue\tTaken");
        for (int i = 0; i < n; i++) {
            if (items[i].weight <= remainingCapacity) {
                // take whole item
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
                System.out.println((i + 1) + "\t" + items[i].weight + "\t" + items[i].value + "\t1 (Full)");
            } else {
                // take fractional part
                //(double) remainingCapacity → This is called type casting.
                double fraction = (double) remainingCapacity / items[i].weight;
                totalValue += (items[i].value * fraction);
                System.out.println((i + 1) + "\t" + items[i].weight + "\t" + items[i].value + "\t" + String.format("%.2f", fraction));
                remainingCapacity = 0;
                break;
            }
        }
        //String.format("%.2f", totalValue) → Round value to 2 decimal places.

        System.out.println("\nMaximum value in Knapsack = " + String.format("%.2f", totalValue));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Fractional Knapsack Problem ---");
            System.out.println("1. Enter Items and Solve");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of items: ");
                    int n = sc.nextInt();
                    Item[] items = new Item[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter value and weight of item " + (i + 1) + ": ");
                        int value = sc.nextInt();
                        int weight = sc.nextInt();
                        items[i] = new Item(value, weight);
                    }

                    System.out.print("Enter knapsack capacity: ");
                    int capacity = sc.nextInt();

                    fractionalKnapsack(items, n, capacity);
                    break;

                case 2:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 2);

        sc.close();
    }
}


//So constructor = a method that builds and initializes an object.
/*
 * ✅ Key Points to Remember for Viva:

Implicit Casting → automatic, no data loss, small → big

Explicit Casting → manual, may lose data, big → small

Why used in Fractional Knapsack: To get a decimal result when dividing integers.
Type casting is the process of converting a variable from one data type to another.

Example: Converting an int to a double or a double to an int.

In Java, this is done either automatically (implicit) or manually (explicit).
Fractional Knapsack Problem using Greedy Method – Short Theory for Viva

1. Knapsack Problem:

Optimization problem: Given a knapsack of limited capacity and a set of items with weight and value, select items to maximize total value without exceeding capacity.

2. Variants:

0/1 Knapsack: Take the whole item or none.

Fractional Knapsack: Can take fraction of an item if full item does not fit.

3. Greedy Method:

Strategy that selects the best option at each step based on a criterion (here, value-to-weight ratio).

Works for Fractional Knapsack to maximize total value efficiently.

Steps:

Calculate value/weight ratio for all items.

Sort items in descending order of ratio.

Pick items one by one: take full if fits, else take fractional part.

4. Formula for Fraction:

fraction
=
remaining capacity
item weight
fraction=
item weight
remaining capacity
	​


5. Time Complexity:

Sorting → O(n log n) (or O(n²) for simple loops)

Selection → O(n)

6. Real-Life Applications:

Truck loading

Resource allocation

Stock investment optimization

7. Example (Short):

Items: A(60,10), B(100,20), C(120,30)

Capacity = 50

Take A, B fully, and 2/3 of C → Maximum value = 240

8. Key Points for Viva:

Fractional knapsack = divisible items

Greedy algorithm = select highest value/weight first

Constructor initializes Item objects

Type casting (double) ensures decimal result for fractions
 */

 /*| Algorithm          | Time Complexity (Best / Avg / Worst) | Space Complexity | Stability | Logic / Why Complexity                                                                                                              |
| ------------------ | ------------------------------------ | ---------------- | --------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| **Bubble Sort**    | O(n) / O(n²) / O(n²)                 | O(1)             | Yes       | Best case O(n) if array already sorted (one pass). Worst case: each element swapped repeatedly.                                     |
| **Selection Sort** | O(n²) / O(n²) / O(n²)                | O(1)             | No        | Always selects min element and swaps → same steps regardless of input.                                                              |
| **Insertion Sort** | O(n) / O(n²) / O(n²)                 | O(1)             | Yes       | Best case: already sorted → only comparisons. Worst case: reverse sorted → max shifts.                                              |
| **Merge Sort**     | O(n log n) / O(n log n) / O(n log n) | O(n)             | Yes       | Divides array into halves recursively, merges in sorted order. Extra O(n) for temporary arrays.                                     |
| **Quick Sort**     | O(n log n) / O(n log n) / O(n²)      | O(log n)         | No        | Divide & conquer using pivot. Best/avg: balanced partition. Worst: already sorted + bad pivot → degenerate recursion.               |
| **Heap Sort**      | O(n log n) / O(n log n) / O(n log n) | O(1)             | No        | Builds max-heap, extracts max repeatedly. Consistent log n operations.                                                              |
| **Counting Sort**  | O(n+k) / O(n+k) / O(n+k)             | O(n+k)           | Yes       | Non-comparison sort, uses counts. k = range of input. Linear time if k is small.                                                    |
| **Radix Sort**     | O(nk) / O(nk) / O(nk)                | O(n+k)           | Yes       | Processes digits from LSB to MSB. Linear if digit count small. Stable.                                                              |
| **Bucket Sort**    | O(n+k) / O(n+k) / O(n²)              | O(n+k)           | Yes       | Distributes elements into buckets then sorts individually (usually insertion sort). Worst case: all elements in one bucket → O(n²). |
| **Shell Sort**     | O(n log n) / O(n^(3/2)) / O(n²)      | O(1)             | No        | Gap-based insertion sort. Complexity depends on gap sequence.                                                                       |
| **Tim Sort**       | O(n) / O(n log n) / O(n log n)       | O(n)             | Yes       | Hybrid of merge & insertion sort. Best for partially sorted arrays. Used in Java/Python.                                            |
 */

  /* loop - o(n)
  * nested i into j  --o(n)^2
    sorin --- o(nlog n)
  *

  /*2 TYPE 0/1 Dyanamic  brute force
   * 2)fractional - greedy - ration weight profit ake large one 
   * 
   * 2 loop 1 for for n num 2 nd for sortingn
   */
  