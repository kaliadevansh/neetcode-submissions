class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                int newCount = frequencyMap.get(c) - 1;
                if (newCount == 0) {
                    frequencyMap.remove(c);
                } else {
                    frequencyMap.put(c, newCount);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
