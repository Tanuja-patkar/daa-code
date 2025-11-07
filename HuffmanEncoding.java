import java.util.*;

// Node class for Huffman Tree
class HuffmanNode {
    int data;     //frequency  ener ferequecy
    char c;       //enter char
    HuffmanNode left, right;
}

// Comparator for PriorityQueue (min-heap)
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;    //x and y for compare two frequency   find to small one
    }
}

public class HuffmanEncoding {
    // Method to print Huffman Codes
    public static void printCode(HuffmanNode root, String s) {  //
        //isLetter(char ch) is a static method in the Character class.

//It checks if the given character is a letter (A–Z or a–z).
/*
 * true → if root.c is a letter

false → if it is not a letter (like '-', '1', etc.)
 */
So:
        if (root.left == null && root.right == null && Character.isLetter(root.c)) { //Means we reached a leaf node (a character)
            System.out.println(root.c + " : " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Huffman Encoding Menu ===");
            System.out.println("1. Enter Characters and Frequencies");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of characters: ");
                    int n = sc.nextInt();

                    char[] charArray = new char[n];   //store char
                    int[] charfreq = new int[n];       //store frequency

                    System.out.println("Enter characters and their frequencies:");
                    for (int i = 0; i < n; i++) {
                        System.out.print("Character " + (i + 1) + ": ");
                        charArray[i] = sc.next().charAt(0);
                        System.out.print("Frequency of " + charArray[i] + ": ");
                        charfreq[i] = sc.nextInt();
                    }

                    PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());  //create object 

                    // Create leaf nodes for all characters
                    for (int i = 0; i < n; i++) {
                        HuffmanNode hn = new HuffmanNode();
                        hn.c = charArray[i];
                        hn.data = charfreq[i];
                        hn.left = null;     //this is foe leaf node login
                        hn.right = null;
                        q.add(hn);    //plete node (character + frequency),
                    }

                    // Construct Huffman Tree
                    HuffmanNode root = null;
                    while (q.size() > 1) {
                        HuffmanNode x = q.poll();
                        HuffmanNode y = q.poll();
                      //q.poll() removes and returns the smallest element.
                        HuffmanNode f = new HuffmanNode();
                        f.data = x.data + y.data;
                        f.c = '-';    //Character = ‘-’ (internal node, not a letter)
                        f.left = x;
                        f.right = y;
 
                        root = f;      //final node
                        q.add(f);   ///insert to queue
                    }

                    // Print Huffman Codes
                    System.out.println("\nHuffman Codes are:");
                    printCode(root, "");
                    break;

                case 2:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
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



/*
 * 1️⃣ Queue (Normal Queue)

Definition: Linear data structure that works FIFO (First In, First Out).

Operations:

Enqueue: Add element at the rear

Dequeue: Remove element from the front

Example: Printer queue, ticket line

Time Complexity: O(1) for enqueue/dequeue (simple array/linked list)

2️⃣ Priority Queue

Definition: Each element has a priority. Elements with highest priority are served first.

Implementation: Often with Min-Heap (or Max-Heap)

Operations:

Insert (add) → O(log n)

Extract-Min / Extract-Max → O(log n)

Peek → O(1)

Example in Huffman Encoding: Pick two smallest frequency nodes to build tree

Time Complexity: O(n log n) for building Huffman tree

Space Complexity: O(n) (for nodes and heap)

3️⃣ Min Heap

Definition: Complete binary tree where parent ≤ children

Use: Efficiently get smallest element in O(1) and insert/remove in O(log n)

Relation to Priority Queue: Min-Heap is a type of priority queue

4️⃣ Huffman Encoding Algorithm

Type: Greedy Algorithm (always pick the best local choice)

Steps:

Count frequency of each character

Create leaf nodes and insert into Min-Heap

Extract two smallest nodes, combine, insert back

Repeat until one node (root) remains

Traverse tree to assign codes (left = 0, right = 1)

Properties:

Prefix-free codes (no code is prefix of another)

Variable-length binary codes (frequent char → shorter code)

Time Complexity: O(n log n) 
Time Complexity of Huffman Encoding
Step-by-step logic:

Build Leaf Nodes and Insert into Priority Queue

There are n characters.

Inserting each node into a Min Heap takes O(log n) time.

For n nodes → O(n log n)

Building the Huffman Tree

While the queue has more than 1 node:

Extract two smallest nodes → poll() → O(log n) each

Combine them → O(1)

Insert the combined node back → O(log n)

We do this n-1 times (because tree has n leaf nodes → n-1 internal nodes)

Total time = (n-1) × (2 * O(log n) + O(1)) ≈ O(n log n)

Traversing the Huffman Tree to Print Codes

Tree has 2n-1 nodes

Traversing all nodes recursively → O(n)

✅ Overall Time Complexity:

O(n log n) + O(n) ≈ O(n log n)

2️⃣ Space Complexity of Huffman Encoding
Step-by-step logic:

Storing nodes in Min Heap

Heap contains at most n leaf nodes + n-1 internal nodes → O(n)

Huffman Tree Storage

Tree has 2n-1 nodes, each node stores:

character, frequency, left pointer, right pointer → O(1) per node

Total → O(n)

Recursive Traversal Stack

Maximum recursion depth = height of tree = O(n) in worst case

✅ Overall Space Complexity:

O(n)

Space Complexity: O(n)
 */



 /* NO PREFIX CODE 
  * 
  */