import java.util.Scanner;

public class NQueens {
    static int N;
    static int[][] board;
    /*2D array representing the chessboard:
1 → queen placed
0 → empty cell */

    // Function to print the board
    static void printBoard() {
        /*Nested loops:
Outer loop → rows
Inner loop → columns
Prints 1 for queen and 0 for empty cell. */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // Check if a queen can be placed at board[row][col]
    static boolean isSafe(int row, int col) {
        // Check this row on left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve N Queen using Backtracking
    static boolean solveNQ(int col) {
        if (col >= N)
            return true; // all queens placed

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                // Recur to place rest of the queens
                if (solveNQ(col + 1))
                    return true;

                // Backtrack
                board[i][col] = 0;
            }
        }
        return false; // No place for this column
    }

    // Function to start solving N-Queens
    static void solve() {
        /*}
Explanation:
If solveNQ(1) returns false, it means no valid configuration exists with the first queen at the given position.
Then program prints “Solution does not exist”.
Example:
Board size N = 4
First queen placed at row 3, column 0
It may happen that no valid placement exists for the other 3 queens → solution does not exist. */
        if (!solveNQ(1)) { // since first queen already placed
            System.out.println("Solution does not exist");
            return;
        }
        printBoard();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== N-Queens Problem (Backtracking) ===");
            System.out.println("1. Place Queens");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of Queens (N): ");
                    N = sc.nextInt();
                    board = new int[N][N];

                    // Place first Queen manually
                    System.out.print("Enter row position for first Queen (0 to " + (N - 1) + "): ");
                    int r = sc.nextInt();
                    board[r][0] = 1;

                    System.out.println("Initial board with first Queen placed:");
                    printBoard();

                    System.out.println("\nSolving using Backtracking...");
                    solve();
                    break;

                case 2:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 2);
        sc.close();
    }
}


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