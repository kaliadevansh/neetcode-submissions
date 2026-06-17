class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // if i fix a number, problem becomes two sum.
        Set<List<Integer>> result = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            int fixedNumber = nums[i];
            int[] numsFromI = Arrays.copyOfRange(nums, i+1, nums.length);
            List<List<Integer>> resultForI = twoSum(numsFromI, -fixedNumber);
            for(List<Integer> l : resultForI) {
                List<Integer> triplet = new ArrayList<>(l);
                triplet.add(fixedNumber);
                Collections.sort(triplet);
                result.add(triplet);
            }
            
        }
        return new ArrayList<>(result);

    }
    public List<List<Integer>> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complimentMap = new HashMap<>();
        List<List<Integer>> possibleSolutions = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (complimentMap.containsKey(nums[i])) {
                possibleSolutions.add(Arrays.asList(nums[i], complimentMap.get(nums[i])));
            } else {
                complimentMap.put(target-nums[i], nums[i]);
            }
        }

        return possibleSolutions;
    }
}
