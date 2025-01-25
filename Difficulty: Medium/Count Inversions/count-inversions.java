//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int inversionCount(int arr[]) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Merge Sort and count inversions
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, inversionCount = 0;

        if (left < right) {
            mid = (left + right) / 2;

            // Count inversions in the left and right halves
            inversionCount += mergeSortAndCount(arr, temp, left, mid);
            inversionCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count inversions during the merge process
            inversionCount += mergeAndCount(arr, temp, left, mid, right);
        }

        return inversionCount;
    }

    // Merge two sorted halves and count inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left; // Starting index to store merged result
        int inversionCount = 0;

        // Merge the two halves
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // Inversion found
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements of left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversionCount;
    }

}