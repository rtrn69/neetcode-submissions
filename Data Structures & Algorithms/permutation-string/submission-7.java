class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            Logic:
            Sliding window problem. Create two arrays to keep track of the number of
            each character in both Strings. Then, compare the two arrays if same. No 
            need to sort since the array will be in alphabetical order by using ASCII.

            Use sliding window to check s2 from front to back, checking if it matches
            at all times 
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
