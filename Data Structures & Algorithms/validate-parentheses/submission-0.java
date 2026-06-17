class Solution {
    public boolean isValid(String s) {
        Deque<Character> parantheses = new ArrayDeque<>();

        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                parantheses.push(c);
            } else if (c == ')') {
                if (parantheses.isEmpty()) {
                    return false;
                } else if (parantheses.peek() == '(') {
                    parantheses.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (parantheses.isEmpty()) {
                    return false;
                } else if (parantheses.peek() == '{') {
                    parantheses.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (parantheses.isEmpty()) {
                    return false;
                } else if (parantheses.peek() == '[') {
                    parantheses.pop();
                } else {
                    return false;
                }
            }
        }
        if (parantheses.size() > 0) {
            return false;
        }
        return true;
    }
}
