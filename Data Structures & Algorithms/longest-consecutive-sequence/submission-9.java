class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxConsecutive = 1;
        int lastConsecutive = 1;
        List<Integer> numsList = Arrays.stream(nums)
                                        .boxed()
                                        .collect(Collectors.toList());

        numsList.sort(Comparator.naturalOrder());
        System.out.println(numsList);
        
        for (int i = 1; i < numsList.size(); i++) {
            int current = numsList.get(i);
            int lastNumber = numsList.get(i - 1);

            if (current != lastNumber) {
                if ((current - lastNumber) == 1) {
                    System.out.println(current + "-" + lastNumber + " = " + (current - lastNumber));
                    lastConsecutive++;
                } else {
                    maxConsecutive = Math.max(maxConsecutive, lastConsecutive);
                    lastConsecutive = 1;
                }
            }
        }

        return Math.max(maxConsecutive, lastConsecutive);
    }
}
