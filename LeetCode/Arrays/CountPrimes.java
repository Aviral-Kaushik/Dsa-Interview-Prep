package LeetCode.Arrays;

import java.util.Arrays;

public class CountPrimes {

    /**
     * Time Complexity: O(n * sqrt(n))
     * */
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int totalPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                totalPrimes++;
            }
        }

        return totalPrimes;
    }
}
