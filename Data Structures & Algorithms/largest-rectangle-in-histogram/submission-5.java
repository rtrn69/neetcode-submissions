class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            // pop top bar in stack if taller than curr bar - cannot extend right
            while (!stack.empty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int area = top[1] * (i - top[0]);
                max = Math.max(area, max);
                start = top[0]; // curr bar can extend back to popped bar's start 
            }

            stack.push(new int[] {start, heights[i]});
        }
        
        while (!stack.empty()) {
            int area = stack.peek()[1] * (heights.length - stack.peek()[0]);
            max = Math.max(max, area);
            stack.pop();
        }

        return max; 
    }
}
