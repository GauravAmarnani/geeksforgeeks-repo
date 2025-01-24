//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int a;
            a = Integer.parseInt(br.readLine());

            int b;
            b = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int[] ans = obj.lcmAndGcd(a, b);
            System.out.println(ans[0] + " " + ans[1]);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        int gcdValue = gcd(a, b);
        int lcmValue = lcm(a, b, gcdValue);

        // Create a list to return the results
        int[] result = new int[2];
        result[0] = lcmValue;
        result[1] = gcdValue;
        return result;
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b, int gcd) {
        return (a / gcd) * b; // Formula: LCM(a, b) = (a * b) / GCD(a, b)
    }
}

//{ Driver Code Starts.

// } Driver Code Ends