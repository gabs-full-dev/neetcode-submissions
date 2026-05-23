class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!isAlphaNumeric(l)) {
                left++;
                continue;
            }

            if (!isAlphaNumeric(r)) {
                right--;
                continue;
            }

            if (toLower(l) != toLower(r)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }

    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }
}