class Solution {
    public int characterReplacement(String s, int k) {
        /*
            Algorithm - 
                Use a sliding window.
                Start from i == 0, and j == i+1
                Create a freq map, since the question says only upper case, 
                so array can be used as well. like s.charAt(i)-'A' as index.
                now on the map, check max freq element.
                check sum of freq of other elements
                if sum of other elements <= k (valid subString)
                    (meaning 1 base character, and k swaps)
                then:
                    1. store the max length globally if > globalMaxLength
                    2. j++ (expand the window)
                    3. redo this whole loop
                else:
                    for invalid substring, we need to increment i now
                    and check for validity of i+1,j
                    run the entire loop there.
        */
        
        int sp = 0;
        int ep = 1;
        int globalMax = 0;

        int[] freqMap = new int[26];
        if (s.length() >= 1) 
            freqMap[s.charAt(0)-'A']++;
            globalMax =1;
        if (s.length() >=2)
        freqMap[s.charAt(1)-'A']++;

        while (sp<=ep && ep<s.length()) {
            int sumOfOthers = getSumOfNonMaxFreq(freqMap, getMaxFreqIndex(freqMap));

            if (sumOfOthers > k) {
                sp++;
                if (sp<s.length())
                    freqMap[s.charAt(sp-1) - 'A']--;
            } else {
                int localMax = ep-sp+1;
                globalMax = Math.max(localMax, globalMax);
                ep++;
                if(ep<s.length())
                    freqMap[s.charAt(ep) - 'A']++;
            }
        }
        return globalMax;
    }


    int getMaxFreqIndex(int[] freqMap) {
        int max = 0;
        int maxIndex = 0;
        for (int i=0; i<26; i++) {
            if(freqMap[i]>max) {
                max = freqMap[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    int getSumOfNonMaxFreq(int[] freqMap, int maxIndex) {
        int sum = 0;
        for (int i=0; i<26; i++) {
            if (i!=maxIndex) {
                sum+=freqMap[i];
            }
        }
        return sum;
    }

    
}
