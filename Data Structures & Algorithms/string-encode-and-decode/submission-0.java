class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append("#");
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();

        int counter = 0;

        while (counter < str.length()) {
            // First character should be '#'
            counter++;

            int size = 0;

            // Read length until next '#'
            while (counter < str.length() && Character.isDigit(str.charAt(counter))) {
                size = (size * 10) + (str.charAt(counter) - '0');
                counter++;
            }

            // Skip second '#'
            counter++;

            // Read exactly size characters
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(str.charAt(counter));
                counter++;
            }

            output.add(sb.toString());
        }

        return output;
    }
}