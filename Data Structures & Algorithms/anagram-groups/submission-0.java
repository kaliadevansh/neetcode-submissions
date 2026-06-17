class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            int[] count = new int[26];
            for (Character c:word.toCharArray()) {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k-> new ArrayList<String>()).add(word);
        }
        List<List<String>> output = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            output.add(entry.getValue());
        }
        return output;
    }
}
