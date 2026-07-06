class Solution {
    public boolean isPalindrome(String s) {
        
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < clean.length(); i++) {
            stack.push(clean.charAt(i));
        }

        String reverse = "";

        for (int i = 0; i < clean.length(); i++) {
            reverse += stack.pop();
        }

        if (clean.equals(reverse)) {
            return true;
        }

        return false; 
    }
}
