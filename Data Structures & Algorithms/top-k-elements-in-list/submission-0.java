class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a,b) -> freqMap.get(b) - freqMap.get(a)
        );

        for (int num : freqMap.keySet()) {
            minHeap.add(num);
        }

        int[] output = new int[k];

        for (int i = 0; i < k; i++) {
            output[i] = minHeap.poll();
        }

        return output;

    }
}
