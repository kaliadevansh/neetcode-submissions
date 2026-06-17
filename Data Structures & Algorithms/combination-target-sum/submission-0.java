class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, target, new ArrayList<>(), result);
        return result;

    }

    public void dfs(
        int[] nums,
        int startingIndex,
        int remaining,
        List<Integer> path,
        List<List<Integer>> result) {
            if (remaining == 0) {
                result.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i= startingIndex; i<nums.length; i++) {
                int x = nums[i];
                if (x > remaining) {
                    break;
                }

                path.add(x);

                dfs(nums, i, remaining - x, path, result);

                path.remove(path.size() - 1);
            }
    } 

    
}
