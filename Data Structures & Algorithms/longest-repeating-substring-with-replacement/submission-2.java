class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int freqChar = 0, longest = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);

            freqChar = Math.max(freqChar, map.get(rc));

            if ((right - left + 1) - freqChar > k) {
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                left++;
            }

            longest = Math.max(right - left + 1, longest);
        }

        return longest;
    }
}