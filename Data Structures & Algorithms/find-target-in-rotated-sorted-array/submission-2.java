class Solution {
    public int search(int[] nums, int target) {
        /*
            DSA:
            Binary Search

            Logic:
            There's a left sorted part and right sorted part.


        */

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[right]) { // check if in left sorted part
                if (target >= nums[left] && target <= nums[mid]) {  
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // mid is in the right sorted part
                if (target <= nums[right] && target >= nums[mid]) { 
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
