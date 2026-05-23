class Solution {
    public int majorityElement(List<Integer> nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int maxCount = -1;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int loopCount = 0;
        int[] output = new int[k];

        List<Integer> nonCheckedNumsList = Arrays.stream(nums)
                                         .boxed()
                                         .collect(Collectors.toList());

        do {
            int majority = majorityElement(nonCheckedNumsList);

            output[loopCount] = majority;

            final int toRemove = majority;
            nonCheckedNumsList = nonCheckedNumsList.stream()
                                                   .filter(num -> num != toRemove)
                                                   .collect(Collectors.toList());
            loopCount++;
        } while (loopCount < k && nonCheckedNumsList.size() > 0);

        return output;
    }
}