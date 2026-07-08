class Solution {
    public int maxArea(int[] heights) {
        
        int max = 0, left = 0, right = heights.length - 1;

        while (left < right) {
            int currVol = 0;
            currVol = (right - left) * Math.min(heights[left], heights[right]);

            if (currVol > max) {
                max = currVol;
            }

            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
