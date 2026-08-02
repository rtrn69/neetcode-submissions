class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
            Logic:
            Monotonic decreasing stack.

            Stack & array used.

            Push index of temperature into stack. If the next temp elem is higher than
            the top of stack, pop stack and record the ith day in the ans arr.
            Keep pushing if elem in temperatures arr into stack if temp is lower than
            the prev. 
        */

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // find index of prev temperature
                ans[prevIndex] = i - prevIndex; // find day difference by subtracting indexes
            }

            stack.push(i);
        }

        return ans;
    }
}
