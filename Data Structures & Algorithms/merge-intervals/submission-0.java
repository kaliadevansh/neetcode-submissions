class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> 
            (a[0]==b[0]) ?
            Integer.compare(a[1], b[1]):
            Integer.compare(a[0], b[0])
        );

        // now that we have a sorted array, 
        // i would just start from first interval and compare first two.
        // then i would continue just comparing resultant with the next input.
        // if not merge-able, send that new interval to output.
        // and proceed to next coutnter

        int prevStartIndex = 0;
        int prevEndIndex = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int resultCount = 0;
        for (int i = 0; i<intervals.length; i++) {
            if (i == 0) {
                prevStartIndex = intervals[i][0];
                prevEndIndex = intervals[i][1];
            } else {
                int startIndex = intervals[i][0];
                int endIndex = intervals[i][1];

                if (startIndex <= prevEndIndex) {
                    // merge
                    prevEndIndex = Math.max(prevEndIndex, endIndex);
                } else {
                    // end of range
                    ArrayList innerList = new ArrayList<>();
                    innerList.add(prevStartIndex);
                    innerList.add(prevEndIndex);
                    result.add(innerList);
                    // result[resultCount][0] = prevStartIndex;
                    // result[resultCount][1] = prevEndIndex;
                    prevStartIndex = startIndex;
                    prevEndIndex = endIndex;
                    resultCount++; 
                }
            }
            if (i == intervals.length-1) {
                ArrayList innerList = new ArrayList<>();
                    innerList.add(prevStartIndex);
                    innerList.add(prevEndIndex);
                    result.add(innerList);
            }
        }
        int [][] res = new int[result.size()][2];
        int count = 0;
        for (List<Integer> innerList: result) {
            res[count][0] = innerList.get(0);
            res[count][1] = innerList.get(1);
            count++;
        }
        return res;
    }
}
