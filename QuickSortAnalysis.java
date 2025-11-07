import java.util.*;

public class QuickSortAnalysis {

    // Function to perform Deterministic Quick Sort
    public static void deterministicQuickSort(int arr[], int low, int high) {
        //If array has 1 or 0 elements → already sorted (low < high check)
        if (low < high) {
            //If array has 1 or 0 elements → already sorted (low < high check)
            int pi = partition(arr, low, high);
            //for lower-1
            deterministicQuickSort(arr, low, pi - 1);
            //for higher +1
            deterministicQuickSort(arr, pi + 1, high);
        }
    }

    // Deterministic partition (last element as pivot)
    public static int partition(int arr[], int low, int high) {
        //pivot = arr[high]; → Choose last element as pivot
        int pivot = arr[high];
        //i = low - 1; → Keeps track of last element smaller than pivot
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                //If element < pivot → move it left of pivot
//Swap arr[i+1] and arr[high] → Put pivot in correct sorted position
//Return i+1 → Index of pivot after partition
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Function to perform Randomized Quick Sort
    public static void randomizedQuickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    // Randomized partition (random pivot)
    public static int randomPartition(int arr[], int low, int high) {
        Random rand = new Random();
        int randomPivot = low + rand.nextInt(high - low + 1);

        // Swap random pivot with last element
        int temp = arr[randomPivot];
        arr[randomPivot] = arr[high];
        arr[high] = temp;

        return partition(arr, low, high);
    }

    // Function to display array
    public static void display(int arr[]) {
        for (int num : arr)  //for each num in array
            System.out.print(num + " ");
        System.out.println();
    }

    // Main Function (Menu Driven)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n----- Quick Sort Analysis -----");
            System.out.println("1. Deterministic Quick Sort");
            System.out.println("2. Randomized Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of elements: ");
                    int n1 = sc.nextInt();
                    int arr1[] = new int[n1];
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n1; i++)
                        arr1[i] = sc.nextInt();

                    System.out.println("Before Sorting:");
                    display(arr1);

                    long start1 = System.nanoTime();
                    deterministicQuickSort(arr1, 0, n1 - 1);
                    long end1 = System.nanoTime();

                    System.out.println("After Deterministic Quick Sort:");
                    display(arr1);
                    System.out.println("Time Taken (ns): " + (end1 - start1));
                    break;

                case 2:
                    System.out.print("Enter number of elements: ");
                    int n2 = sc.nextInt();
                    int arr2[] = new int[n2];
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n2; i++)
                        arr2[i] = sc.nextInt();

                    System.out.println("Before Sorting:");
                    display(arr2);

                    long start2 = System.nanoTime();
                    randomizedQuickSort(arr2, 0, n2 - 1);
                    long end2 = System.nanoTime();

                    System.out.println("After Randomized Quick Sort:");
                    display(arr2);
                    System.out.println("Time Taken (ns): " + (end2 - start2));
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);
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