import java.util.Scanner;

public class Fibonacci {

    // Counter for recursive calls
    static int countRecursive = 0;

    // Recursive Fibonacci method
    static int fibRecursive(int n) {
        countRecursive++;
        if (n <= 1)
            return n;
        else
            return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Iterative (Non-Recursive) Fibonacci method
    static int fibIterative(int n) {
        int steps = 0;
        if (n <= 1) {
            System.out.println("Steps required using Counter (Iterative): " + steps);
            return n;
        }

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            steps++;
        }

        System.out.println("Steps required using Counter (Iterative): " + steps);
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n---------------------------");
            System.out.println("Fibonacci Program - DAA Assignment");
            System.out.println("1. Recursive Fibonacci");
            System.out.println("2. Iterative (Non-Recursive) Fibonacci");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Input validation
            if (sc.hasNextInt()) {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the term number (n): ");
                        if (sc.hasNextInt()) {
                            int nRec = sc.nextInt();
                            countRecursive = 0; // reset counter
                            System.out.println("\nUsing Recursive Fibonacci:");
                            System.out.println("Fibonacci number at position " + nRec + " is: " + fibRecursive(nRec));
                            System.out.println("Steps required using Counter (Recursive): " + countRecursive);
                            System.out.println("Time Complexity: O(2^n)");
                            System.out.println("Space Complexity: O(n) (stack memory)");
                        } else {
                            System.out.println("Invalid input! Please enter a valid number.");
                            sc.next(); // clear invalid input
                        }
                        break;

                    case 2:
                        System.out.print("Enter the term number (n): ");
                        if (sc.hasNextInt()) {
                            int nIter = sc.nextInt();
                            System.out.println("\nUsing Iterative Fibonacci:");
                            System.out.println("Fibonacci number at position " + nIter + " is: " + fibIterative(nIter));
                            System.out.println("Time Complexity: O(n)");
                            System.out.println("Space Complexity: O(1)");
                        } else {
                            System.out.println("Invalid input! Please enter a valid number.");
                            sc.next(); // clear invalid input
                        }
                        break;

                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Enter 1, 2, or 3.");
                }

            } else {
                System.out.println("Invalid input! Please enter a number (1-3).");
                sc.next(); // consume invalid input
            }

        } while (choice != 3);

        sc.close();
    }
}



/* recursive - all same fun repeat all fun itself agai agin slow stack use lifo 
 * use exponential timr complexity bc (n-1)(n-2)
 * Time: O(2^n), Space: O(n) (due to recursion stack).
 * 
 * 2^n+1
 * 
 * 
 * 
 * for iterative use loop
 * Time and space complexity of iterative approach: O(n) and O(1).
 * use 1 loop
 * linear approch output according to input
 * for iterative count (n-1)
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
  */