class Solution {
    public int climbStairs(int n) {
        int i = 1;
        int[] memory = new int[n];
        
        while(i<=n) {
            if (i==1) {
                memory[0] = 1;
            } else if (i==2) {
                memory[1] = 2;
            } else {
                int waysToReachI = memory[i-2] + memory[i-3];
                memory[i-1] = waysToReachI;
            }
            i++;
        }
        return memory[n-1];
    }
}