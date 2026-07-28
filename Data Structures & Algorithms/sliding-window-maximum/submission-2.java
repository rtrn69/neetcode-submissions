class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            deque.addLast(right);

            // remove from front if elem outside window
            if (deque.peekFirst() < right - k + 1 ) {
                deque.pollFirst();
            }

            // check if window full, records max (on the left most position)
            if (right >= k - 1) {
                ans.add(nums[deque.peekFirst()]);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
