class Solution {
    public boolean hasDuplicate(int[] nums) {
         ArrayList<Integer> aux = new ArrayList<>();

        for (int num : nums) {
            if (aux.size() > 0 && aux.contains(num)) {
                return true;
            }

            aux.add(num);
        }

        return false;
    }
}