package LeetCode.Arrays;

public class GasStation {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0;
        int currentGas = 0;
        int totalGas = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startIndex = i + 1;
            }
        }

        if (totalGas < 0)
            return -1;

        return startIndex;
    }
}
