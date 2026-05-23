class Solution {
    public boolean isPalindrome(String s) {
        String cleanedTarget = s.toUpperCase()
                                .chars()
                                .filter(Character::isLetterOrDigit)
                                .mapToObj(c -> String.valueOf((char) c))
                                .collect(Collectors.joining());

        String[] splitedTarget = cleanedTarget.split("");
        String targetBackwards = "";

        int index = splitedTarget.length - 1;
        
        while (index >= 0) {
            targetBackwards += splitedTarget[index];
            index--;
        }

        return cleanedTarget.equals(targetBackwards.toUpperCase());
    }
}
