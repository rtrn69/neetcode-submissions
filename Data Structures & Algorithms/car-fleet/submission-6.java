class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // create array of index positions
        Integer[] indexes = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indexes[i] = i;
        }

        // sort index arr based on positions in ascending order 
        Arrays.sort(indexes, (a, b) -> position[a] - position[b]);

        // stack ds
        Stack<Double> stack = new Stack<>();

        for (int i = position.length - 1; i >= 0; i--) {
            int starting = position[indexes[i]];
            int pace = speed[indexes[i]];
            double rate = (double)(target - starting) / pace; 
            
            if (stack.empty()) {
                stack.push(rate);
            } else {
                if (rate > stack.peek()) {
                    stack.push(rate);
                }
            }
        }        
    
        return stack.size();
    }
}
