class Solution {
    public int findMin(int[] nums) {
        /*
            Algo:
            Binary Search

            Logic:
            Since arr is alw in ascending order, there'll be a left sorted part and
            right sorted part starting from the lowest number. 

            Use binary search to check mid elem with left most elem then or right most
            then split based on which side to search



        */

        int left = 0, right = nums.length - 1, ans = nums[(left + right) / 2]; 

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= nums[left]) {
                ans = Math.min(nums[left], ans);
                left = mid + 1;
            } else {
                ans = Math.min(nums[mid], ans);
                right = mid - 1;
            }
        }
        
        return ans;
    }
}
