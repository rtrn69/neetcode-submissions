class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int startSeq = nums[i], counter = 1;
                while (set.contains(startSeq + 1)) {
                    counter++;
                    startSeq++;
                }
                
                if (counter > max) {
                    max = counter;
                }
            }
        }

        return max;
    }
}
