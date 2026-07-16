class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();

        int left = 0, longest = 0;

        for (int right = 0; right < s.length(); right++) {
            while (map.contains(s.charAt(right))) {
                map.remove(s.charAt(left));
                left++;
            }
            map.add(s.charAt(right));
            longest = Math.max(longest, map.size());
        }

        return longest;
    }
}
