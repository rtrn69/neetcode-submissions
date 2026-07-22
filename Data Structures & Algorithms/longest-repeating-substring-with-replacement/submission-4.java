class Solution {
    public int characterReplacement(String s, int k) {
        /*
            Logic:
            Use hashmap to keep track of the number of character types. Make a charWindow
            and count the most frequent char in the window. Replace the least frequent
            window with the more freq char if windowLength - map.get(<char>) <= k

            To find current window, need to use sliding window 
        */

        Hashtable<Character, Integer> map = new Hashtable<>();

        int freqChar = 0, longest = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // update freqChar
            freqChar = Math.max(freqChar, map.get(s.charAt(right)));

            // edge case: sliding window - most freq char > k 
            if ((right + 1 - left) - freqChar > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            longest = Math.max(right + 1 - left, longest);
        }

        return longest;
    }
}
