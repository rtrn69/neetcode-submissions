class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort arr using Arrays class
        Arrays.sort(nums);

        List<List<Integer>> soln = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // skip loop if 1st pointer has duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // init left & right pointer 
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    soln.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return soln;
    }
}
