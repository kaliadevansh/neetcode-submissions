class Solution {
    public int coinChange(int[] coins, int amount) {
        int memory[] = new int[amount];
        for(int i=0; i<memory.length;i++) {
            memory[i] = -2;
        }

        return minCoinsNeededToGetToAmount(
            0, amount, coins, memory);
    }

    int minCoinsNeededToGetToAmount(int currSum, int amount, int[] coins,
    int[] memory) {
        if (currSum == amount) {
            return 0;
        } else if(memory[currSum] != -2) {
            
            return memory[currSum];
        
        } else {
            int minCoins = Integer.MAX_VALUE;
            // need to add more coins
            for (int coin: coins) {
                if (coin <= amount - currSum) {
                    int localAmount = currSum + coin;

                    int subResult = minCoinsNeededToGetToAmount(
                        localAmount, amount, coins, memory
                    );

                    if (subResult != -1) {
                       int coinsNeeded = 1 + subResult;
                        minCoins = Math.min(coinsNeeded, minCoins);
                    }
                }
            }
            if (minCoins == Integer.MAX_VALUE) {
                memory[currSum] = -1;
                return -1;
            }
            memory[currSum] = minCoins;
            return minCoins;
        }
    }
}
