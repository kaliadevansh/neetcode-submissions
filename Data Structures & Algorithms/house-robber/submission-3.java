class Solution {
    public int rob(int[] nums) {
        /* let us store max array.
         * where max[i] means maximum recovery from ith house.
        */
        int maxSum = 0;
        int memory[] = new int[nums.length];
        for(int i=0; i<memory.length; i++) {
            memory[i]=-1;
        }
        return Math.max(getMemory(nums, memory, 0), getMemory(nums,memory, 1));
    }
    int getMemory(int[] nums, int[] memory, int s) {
        if (s>=nums.length) {
            return 0;
        }

        if(s==nums.length-1 || s==nums.length-2) {
            return nums[s];
        }
        if (memory[s] == -1) {
            memory[s] = Math.max(nums[s] + getMemory(nums, memory, s+2), getMemory(nums, memory, s+1));
        }
        return memory[s];
    }
}
