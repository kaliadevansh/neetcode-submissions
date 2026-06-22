class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int i =0; i<nums.length; i++) {
            visited.add(nums[i]);
        }
        Map<Integer, Integer> elementToMaxLength = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i<nums.length; i++) {
            int countOfElementsFromIthElement;
            int ithElement = nums[i];
            int runningIthElement = ithElement;
            
            while(visited.contains(runningIthElement)) {
                if (elementToMaxLength.containsKey(runningIthElement)) {
                    runningIthElement += elementToMaxLength.get(runningIthElement);
                    break;
                }
                runningIthElement++;
            }
            runningIthElement--;

            countOfElementsFromIthElement = runningIthElement- ithElement+1;
            int localCount = 0;
            while(runningIthElement >= ithElement  && !elementToMaxLength.containsKey(runningIthElement)) {
                localCount++;
                elementToMaxLength.put(runningIthElement, localCount);
                runningIthElement--;
            }
            maxLength = Math.max(maxLength, countOfElementsFromIthElement);
        }
        return maxLength;
    }
}
