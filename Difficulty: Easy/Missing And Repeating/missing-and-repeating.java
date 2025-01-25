//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(); // result[0] = repeating, result[1] = missing

        // Step 1: Iterate through the array and mark visited indices as negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1; // Find the index for the current number
            if (arr[index] < 0) {
                result.add(0, Math.abs(arr[i])); // If already negative, it's the repeating number
            } else {
                arr[index] = -arr[index]; // Mark the number as visited
            }
        }

        // Step 2: Iterate through the array again to find the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                result.add(1, i + 1); // The index + 1 is the missing number
            }
        }

        return result;
    }
}
