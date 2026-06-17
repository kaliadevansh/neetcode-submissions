class Solution {
    public int hammingWeight(int n) {
        int numberOfOnes = 0;
        while (n!=0) {
            if (n%2 != 0) {
                numberOfOnes++;
            }
            n= n>>1;
        }
        return numberOfOnes;
    }
}
