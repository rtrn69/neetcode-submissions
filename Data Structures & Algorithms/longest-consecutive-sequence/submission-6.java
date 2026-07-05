class Solution {
    public int longestConsecutive(int[] nums) {
        // use hashset to check for existence of integers
        HashSet<Integer> set = new HashSet<>();

        // add all elems in arr to hashset
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0; // max sequence counter
        for (int i = 0; i < nums.length; i++) { // iterate thru every elem in arr
            if (!set.contains(nums[i] - 1)) { // check if elem is start of seq
                int startSeq = nums[i], counter = 1;

                // if elem is start of seq then check if subsequent nums are in hashset
                while (set.contains(startSeq + 1)) {
                    counter++;
                    startSeq++;
                }
                
                // override max if curr seq counter is higher
                if (counter > max) {
                    max = counter;
                }
            }
        }

        return max;
    }
}
