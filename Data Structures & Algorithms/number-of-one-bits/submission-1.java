class Solution {
    public int hammingWeight(int n) {
        int numberOfOnes = 0;
        while (n!=0) {
            if ((n&1) == 1) {
                numberOfOnes++;
            }
            n= n>>>1;
        }
        return numberOfOnes;
    }
}
