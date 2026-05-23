class Solution {
    public boolean isPalindrome(String s) {
        String cleanedTarget = s.toUpperCase()
                                .chars()
                                .filter(Character::isLetterOrDigit)
                                .mapToObj(c -> String.valueOf((char) c))
                                .collect(Collectors.joining());
        String[] splitedTarget = cleanedTarget.split("");
        String targetBackwards = "";

        for (int i = splitedTarget.length - 1; i >= 0; i--) {
            targetBackwards += splitedTarget[i];
        }

        return cleanedTarget.equals(targetBackwards.toUpperCase());
    }
}
