class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // prefix is the product of all elems before the elem itself
        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = 1;
            }

            if (i > 0) {
                prefix[i] = nums[i - 1] * prefix[i - 1];
            }
        }

        // postfix is the product of all elems after the nums elem itself
        int[] postfix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = 1;
            }

            if (i < nums.length - 1) {
                postfix[i] = nums[i + 1] * postfix[i + 1];
            }
        }

        // output at each elem wld be the prefix * postfix at the index
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix[i] * postfix[i];
        }

        return output;
    }
}  
