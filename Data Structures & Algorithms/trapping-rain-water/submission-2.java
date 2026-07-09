class Solution {
    public int trap(int[] height) {
        
        /*
            Logic:
             

            Formula:
            vol at a spot = Math.min(Max height[left], Max height[right]) - height at position i 
        */

        int[] maxLeft = new int[height.length];
        int maxHeight = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > maxHeight) {
                maxHeight = height[i - 1];
            }

            maxLeft[i] = maxHeight;
        }

        int[] maxRight = new int[height.length];
        maxHeight = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > maxHeight) {
                maxHeight = height[i + 1];
            }

            maxRight[i] = maxHeight;
        }

        int totalArea = 0;
        for (int i = 0; i < height.length; i++) {
            int positionVol = Math.min(maxLeft[i], maxRight[i]) - height[i];

            if (positionVol >= 0) {
                totalArea += positionVol;
            }
        }

        return totalArea; 
    }
}
