class Solution {
     public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // First pass: compute prefix products
        int left = 1;
        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *= nums[i];
        }

        // Second pass: multiply by suffix products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }
}  
