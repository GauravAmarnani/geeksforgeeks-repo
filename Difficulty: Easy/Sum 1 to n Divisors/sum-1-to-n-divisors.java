//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            int ans = ob.sumOfDivisors(N);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int sumOfDivisors(int n) {
        int sum = 0;

        // Iterate from 1 to n to calculate F(i) for each i
        for (int i = 1; i <= n; i++) {
            sum += calculateDivisorsSum(i);
        }

        return sum;
    }

    // Helper function to calculate the sum of divisors for a single number
    public static int calculateDivisorsSum(int num) {
        int divisorSum = 0;

        // Find all divisors of num
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                divisorSum += i; // Add the divisor

                // If i is not the same as num / i (to avoid double counting)
                if (i != num / i) {
                    divisorSum += num / i;
                }
            }
        }

        return divisorSum;
    }
}