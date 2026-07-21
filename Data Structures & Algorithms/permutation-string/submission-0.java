class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // build frequency of s1 and initial window
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        // count how many of 26 chars already match
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == windowCount[i]) matches++;
        }

        // slide the window
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            // add right char
            int idx = s2.charAt(right) - 'a';
            windowCount[idx]++;
            if (windowCount[idx] == s1Count[idx]) matches++;
            else if (windowCount[idx] == s1Count[idx] + 1) matches--;

            // remove left char
            int left = right - s1.length();
            idx = s2.charAt(left) - 'a';
            windowCount[idx]--;
            if (windowCount[idx] == s1Count[idx]) matches++;
            else if (windowCount[idx] == s1Count[idx] - 1) matches--;
        }

        return matches == 26;
    }
}