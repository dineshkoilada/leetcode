/**
 * The BucketSort class provides an implementation of the Bucket Sort algorithm.
 * This algorithm sorts an array of non-negative integers by distributing the elements
 * into "buckets" based on their values, counting the occurrences, and then reconstructing
 * the sorted array.
 *
 * <p>Time Complexity:
 * - Best Case: O(n + k), where n is the number of elements in the array and k is the range of input values.
 * - Worst Case: O(n + k), assuming the range of input values is not excessively large.
 *
 * <p>Space Complexity: O(k), where k is the range of input values.
 *
 * <p>Limitations:
 * - This implementation works only for non-negative integers.
 * - It is not suitable for datasets with a large range of values due to memory constraints.
 *
 * <p>Example Usage:
 * <pre>
 * int[] arr = {2, 0, 2, 1, 1, 2, 0, 1, 0, 2};
 * int[] sortedArr = BucketSort.bucketSort(arr);
 * // Output: 0 0 0 1 1 1 2 2 2 2
 * </pre>
 */
public class BucketSort {

    /**
     * Sorts the given array of non-negative integers using the Bucket Sort algorithm.
     *
     * @param arr The array of non-negative integers to be sorted.
     * @return The sorted array.
     */
    public static int[] bucketSort(int[] arr) {
        // Find the maximum value in the array to determine the range of buckets.
        int max = 0;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Create a bucket array to count occurrences of each number.
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        // Reconstruct the sorted array using the bucket counts.
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[index++] = i;
            }
        }

        return arr;
    }

    /**
     * The main method demonstrates the usage of the Bucket Sort algorithm.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example input array
        int[] arr = {2, 0, 2, 1, 1, 2, 0, 1, 0, 2};

        // Sort the array using Bucket Sort
        int[] sortedArr = bucketSort(arr);

        // Print the sorted array
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }
}
