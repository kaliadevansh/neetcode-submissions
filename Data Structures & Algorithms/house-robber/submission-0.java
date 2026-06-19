class Solution {
    public int rob(int[] nums) {
        /* let us store max array.
         * where max[i] means maximum recovery from ith house.
        */
        int maxSum = 0;
        int memory[] = new int[nums.length];
        for (int i = 0; i<nums.length; i++) {
            memory[i]=-1;
        }

        for (int i = 0; i <nums.length; i++) {
            int localSum = rob(nums, i, memory);
            if (localSum>maxSum) {
                maxSum = localSum;
            }
        }
        return maxSum;
    }
    public int rob(int[] nums, int i, int[] memory) {
        int result;
        if (memory[i] != -1) {
            return memory[i];
        }
        if (i == nums.length-1 || i == nums.length-2) {
            result = nums[i];
        } else {
            int nextElement = i+2;
            int localMax = nums[i];
            while (nextElement<nums.length) {
                localMax = Math.max(localMax, nums[i]+rob(nums,nextElement, memory));
                nextElement++;
            }
            result = localMax;
        }
        memory[i] = result;
        return result;
    }
}
