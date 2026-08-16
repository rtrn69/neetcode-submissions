class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;     // min is in the right half
            } else {
                right = mid;         // mid could be the min
            }
        }

        return nums[left];
    }
}
