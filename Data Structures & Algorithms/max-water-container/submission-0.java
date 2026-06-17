class Solution {
    public int maxArea(int[] heights) {
        /* algorithm -
            volume = legth * width
            length is in array, width we control.
            So to maximize volume, we can start with maximum width
            (we could have started with a smallest width too)
            then the wall which is leaking water, we move it inward.
            keep track of max vol and retun that. 
        */
        int maxVolume = 0;
        int startingIndex = 0;
        int endingIndex = heights.length - 1;

        while (startingIndex < endingIndex) {
            // same index is zero volume.
            int localVolume = (endingIndex-startingIndex)* Math.min(
                heights[startingIndex], heights[endingIndex]);

            if (localVolume > maxVolume) {
                maxVolume = localVolume;
            }

            if (heights[startingIndex] < heights[endingIndex]) {
                // starting index is leaking water, move inward
                startingIndex++;
            } else {
                endingIndex--;
            }
        }
        return maxVolume;
    }
}
