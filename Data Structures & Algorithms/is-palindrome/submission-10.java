class Solution {
    public boolean isPalindrome(String s) {
        // remove whitespace and remove non-alphanumeric characters like "?"
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        Stack<Character> stack = new Stack<>();

        // push all char in s arr into stack
        for (int i = 0; i < clean.length(); i++) {
            stack.push(clean.charAt(i));
        }

        // create string to contain reversed s 
        String reverse = "";

        for (int i = 0; i < clean.length(); i++) {
            reverse += stack.pop();
        }

        // check if reversed and initial string are the same
        if (clean.equals(reverse)) {
            return true;
        }

        return false; 
    }
}
