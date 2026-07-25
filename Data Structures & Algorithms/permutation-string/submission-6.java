class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            Logic:
            
        */

        // edge cases
        if (s1.length() > s2.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;

        int[] arr1Count = new int[26];
        int[] arr2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1Count[s1.charAt(i) - 'a']++;
            arr2Count[s2.charAt(i) - 'a']++;
        }  

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (Arrays.equals(arr1Count, arr2Count)) {
                return true;
            }

            arr2Count[s2.charAt(right) - 'a']++;
            arr2Count[s2.charAt(left) - 'a']--;
            left++;
        }

        if (Arrays.equals(arr1Count, arr2Count)) return true;
        
        return false;
    }
}
