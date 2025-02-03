//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printGfg(n);
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {

    void printGfg(int n) {
        if (n == 0) {
            return; // Base case: stop when n reaches 0
        }
        System.out.print("GFG "); // Print "GFG" before recursive call
        printGfg(n - 1); // Recursive call to print remaining times
    }
}