class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int k = 1, low = 1, high = max;

        while (low <= high) {
            int possibleK = (high + low) / 2;

            int totalHours = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHours += (int)Math.ceil((double)piles[i] / possibleK);
            } 

            if (totalHours > h) {
                low = possibleK + 1;
            } else {
                k = possibleK;
                high = possibleK - 1;
            }
        }

        return k;
    }
}
