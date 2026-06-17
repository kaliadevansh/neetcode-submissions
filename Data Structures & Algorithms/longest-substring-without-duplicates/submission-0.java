class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sp = 0;
        int ep = 1;
        if (s.length() < 2) {
            return s.length();
        }
        int longestSubStringLength = 1;
        HashSet<Character> chars = new HashSet<>();
        chars.add(s.charAt(sp));
        int localLongest = 1;
        while (sp <= ep && ep < s.length()) {
            if (chars.contains(s.charAt(ep))) {
                chars.remove(s.charAt(sp));
                sp++;
                localLongest -= 1;
                continue;
            } else {
                chars.add(s.charAt(ep));
                ep++;
                localLongest++;
                if (localLongest > longestSubStringLength) {
                    longestSubStringLength = localLongest;
                }
            }
        }
        return longestSubStringLength;
    }
}
