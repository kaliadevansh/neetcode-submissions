class Solution {
    public int maxProfit(int[] prices) {
        int minPurchasePrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i =0; i<prices.length; i++) {
            if (prices[i] < minPurchasePrice) {
                minPurchasePrice = prices[i];
            }
            int todaysProfit = prices[i] - minPurchasePrice;
            if (todaysProfit > maxProfit) {
                maxProfit = todaysProfit;
            }
        }
        return maxProfit;
        
    }
}
