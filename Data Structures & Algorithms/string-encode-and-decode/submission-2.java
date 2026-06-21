class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append("#");
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> output = new ArrayList<>();
        int count = 0;
        int localcount = 0;
        int size = -1;
        int localSize = 0;
        while(count < str.length()) {
            count++;
            while (size == -1 && Character.isDigit(str.charAt(count))) {
                localSize = (localSize*10) + (str.charAt(count) - '0');
                count++;
            }
            if (size == -1 && str.charAt(count) == '#') {
                size = localSize;
                count++;
            }
            if (size != -1) {


            // read next size characters
            int i = 0;
            StringBuilder sb = new StringBuilder();
            int base = count;
            while (i < size) {
                sb.append(str.charAt(i+base));
                i++;
                count++;
            }
            output.add(sb.toString());
            
            size = -1;
            localSize = 0;
            }
        }
        return output;
    }
}
