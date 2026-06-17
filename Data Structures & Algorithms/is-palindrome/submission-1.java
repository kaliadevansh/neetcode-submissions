class Solution {
    public boolean isPalindrome(String s) {
        for (int fp = 0, bp = s.length()-1; fp<bp; fp++, bp--) {
            while(fp<bp && !Character.isLetterOrDigit(s.charAt(fp))) {
                fp++;
            }
            while(bp> fp && !Character.isLetterOrDigit(s.charAt(bp))) {
                bp--;
            }
            
            if (Character.toLowerCase(s.charAt(fp)) == Character.toLowerCase(s.charAt(bp))) {
                continue;
            } else {
                return false;
            }
            
        }
        return true;
    }
}
