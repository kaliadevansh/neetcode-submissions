class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int n = 0;

    public KthLargest(int k, int[] nums) {
        this.n = k;
        for (int i = 0 ; i<nums.length; i++) {
            minHeap.add(nums[i]);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > this.n) {
            minHeap.poll();   // removes the smallest element (for min-heap)
        }
        return minHeap.peek();
    }
}
