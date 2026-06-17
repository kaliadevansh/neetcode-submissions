class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complementToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complementToIndexMap.containsKey(nums[i])) {
                return new int[]{complementToIndexMap.get(nums[i]), i};
            }

            int compliment = target - nums[i];
            complementToIndexMap.put(compliment, i);
        }
        return new int[]{};
    }
}
