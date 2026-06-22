class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preProduct = new int[nums.length];
        Arrays.fill(preProduct, 1);
        int[] postProduct = new int[nums.length];
        Arrays.fill(postProduct, 1);
        int[] output = new int[nums.length];

        for (int sp = 1; sp<nums.length; sp++) {
            preProduct[sp] = preProduct[sp-1] * nums[sp-1];
        }

        for (int ep = nums.length-2; ep>=0;ep--) {
            postProduct[ep] = postProduct[ep+1] * nums[ep+1];
        }

        for (int i=0;i<nums.length; i++) {
            output[i] = preProduct[i]*postProduct[i];
        }
        return output;
    }
}  


