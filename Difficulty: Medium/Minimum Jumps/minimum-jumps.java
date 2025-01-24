//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;

        // Edge case: if the array has one element, no jumps are needed
        if (n <= 1) return 0;

        // If the first element is 0, it's not possible to move forward
        if (arr[0] == 0) return -1;

        // Variables to track the current jump range and next jump range
        int maxReach = arr[0]; // Maximum index reachable
        int steps = arr[0];    // Steps we can take in the current range
        int jumps = 1;         // Number of jumps made

        for (int i = 1; i < n; i++) {
            // If we've reached the end of the array, return the jump count
            if (i == n - 1) return jumps;

            // Update maxReach to the furthest point we can jump to
            maxReach = Math.max(maxReach, i + arr[i]);

            // Decrease the steps for the current jump range
            steps--;

            // If no steps remain in the current range
            if (steps == 0) {
                // Increment the jump count
                jumps++;

                // If the current index is beyond maxReach, return -1
                if (i >= maxReach) return -1;

                // Reinitialize steps for the next jump range
                steps = maxReach - i;
            }
        }

        // If we exit the loop without reaching the last index, return -1
        return -1;
    }
}