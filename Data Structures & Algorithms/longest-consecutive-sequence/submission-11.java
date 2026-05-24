class Solution {
     public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();

        for (int num : nums) {
            store.add(num);
        }

        int longest = 0;

        for (int num : store) {
            if (!store.contains(num - 1)) {
                int streak = 1, current = num;

                while (store.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}
