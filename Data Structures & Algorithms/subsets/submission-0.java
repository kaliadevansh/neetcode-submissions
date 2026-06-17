class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // decision tree problem
        // need to dfs and get to a base case solution
        // declare two global variables - 1. return variable 2. local solution or path
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), result, nums, 0);
        return result;

    }
    public void dfs(
        List<Integer> path,
        List<List<Integer>> result,
        int[] nums,
        int startingIndex
    ) {
        System.out.println("Processing index - " + startingIndex 
        + " with path - " + path.toString());
        if (startingIndex == nums.length) {
            result.add(new ArrayList<>(path));
        } else {
            path.add(nums[startingIndex]);
            dfs(new ArrayList<>(path), result, nums, startingIndex+1);
            path.remove(path.size() - 1);
            dfs(new ArrayList<>(path), result, nums, startingIndex+1);
        }
    }
}
