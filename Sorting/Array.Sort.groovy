Array.sort():
    *Arrays.sort() is a built-in method from java.util.Arrays that sorts arrays in ascending order by default.
        Syntax:
                Arrays.sort(array);
                Arrays.sort(array, fromIndex, toIndex);
                Arrays.sort(array, Comparator);
    *The implementation depends on data type:

            A. Primitive types (int[], double[], etc.)
                Algorithm used: Dual-Pivot Quicksort (introduced in Java 7).
                Time complexity:
                Average: O(n log n)
                Worst: O(n log n) (due to pivoting improvements — unlike normal quicksort which can be O(n²) in worst case).
                Stability: ❌ Not stable — equal elements may change their relative order.
                ex:If stability matters (e.g., sorting employees by salary but keeping names in the same order), Arrays.sort(int[]) won’t guarantee it.

            B. Object types (Integer[], String[], custom objects)
                Algorithm used: TimSort (hybrid of Merge Sort and Insertion Sort).
                Time complexity:
                Best: O(n) (nearly sorted data)
                Average/Worst: O(n log n)
                Stability: ✅ Stable — equal elements keep their relative order.

    Fixed Sorting Order for Primitive Types:
        You cannot directly use a custom comparator with int[] or double[].
        If you need descending order or custom rules, you must convert to object wrappers (Integer[]) first.
        Example:
            Integer[] arr = {5, 1, 3};
            Arrays.sort(arr, Collections.reverseOrder());
        
    When NOT to Use Arrays.sort():
        When you need stable sort for primitives → Convert to objects first.
        When you have extremely large arrays and memory is critical → Consider in-place sorting.
        When you want custom rules for primitives → Must box into objects.
    
In Java, Arrays.sort() has no direct built-in reverse option for primitive types (like int[], double[]).
You can only do Arrays.sort(..., Collections.reverseOrder()) for objects (e.g., Integer[]), not primitives.
    Why?
        Collections.reverseOrder() works with comparators — but primitive arrays use a highly optimized dual-pivot quicksort without comparator support.
        This means you must either:
            1.Convert to a wrapper array (Integer[]) and sort with reverseOrder()
                code:   import java.util.*;
                        class Main {
                            public static void main(String[] args) {
                                Integer[] arr = {5, 2, 8, 1};
                                Arrays.sort(arr, Collections.reverseOrder());
                                System.out.println(Arrays.toString(arr)); // [8, 5, 2, 1]
                            }
                        }

            2.Sort normally and then manually reverse the array.
                code:   import java.util.*;
                        class Main {
                            public static void main(String[] args) {
                                int[] arr = {5, 2, 8, 1};
                                Arrays.sort(arr); // Ascending
                                for (int i = 0; i < arr.length / 2; i++) {
                                    int temp = arr[i];
                                    arr[i] = arr[arr.length - 1 - i];
                                    arr[arr.length - 1 - i] = temp;
                                }
                                System.out.println(Arrays.toString(arr)); // [8, 5, 2, 1]
                            }
                        }
