import java.util.Scanner;

class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();  // Input the size of the array
        
        int[] arr = new int[n];  // Declare an array of size n
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Input array elements
        }
        
        int[] sortedArr = mergeSort(arr);  // Call mergeSort method
        for (int i = 0; i < n; i++) { 
            System.out.print(sortedArr[i] + " ");  // Output the sorted array
        }
    }

    // MergeSort function
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;  // Base case: If the array has one or fewer elements, it's already sorted
        }
        
        // Split the array into two halves
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        System.arraycopy(arr, 0, left, 0, mid);  // Copy the left half of the array
        System.arraycopy(arr, mid, right, 0, arr.length - mid);  // Copy the right half of the array
        
        // Recursively sort the left and right halves
        left = mergeSort(left);
        right = mergeSort(right);
        
        // Merge the sorted halves
        return merge(left, right);
    }

    // Merge two sorted arrays
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        
        // Merge the arrays while both have elements left
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        
        // If there are any elements left in the left array, add them
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        
        // If there are any elements left in the right array, add them
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        
        return merged;
    }
}
