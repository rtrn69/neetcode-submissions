class Solution {
    public String minWindow(String s, String t) {
        /*
            Logic:
            Sliding Window problem. Use two hashmaps. 
            1st HashMap to track unique chars in String t with corresponding increments.
            2nd HashMap to do the same but in String s via sliding window.
            
            Use two int counters respective for each HashMap to determine if requirements
            are met.

            When right pointer meets a required char in String s, add to 2nd HashMap to  
            track and increment counter.

            When charCount in String s matches charNeeded from String t. Update shortest
            when necessary. 
            While charCount == charNeeded, increment left pointer to remove chars not
            needed and update the 2nd HashMap & counter if element is required.
        */

        // base case
        if (s.length() < t.length()) return "";

        // 1st HashMap
        HashMap<Character, Integer> mapT = new HashMap<>();
        int charNeeded = 0; // tracks characters needed in ans
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
            charNeeded++;
        }

        // 2nd HashMap
        HashMap<Character, Integer> mapS = new HashMap<>();
        String shortest = "";
        int left = 0, charCount = 0;

        for (int right = 0; right < s.length(); right++) {
            if (mapT.containsKey(s.charAt(right))) {
                mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0) + 1);
            
                if (mapS.get(s.charAt(right)) <= mapT.get(s.charAt(right))) {
                    charCount++;
                }
            }

            while (charCount == charNeeded) {
                if (s.substring(left, right + 1).length() < shortest.length() || shortest.isEmpty()) {
                    shortest = s.substring(left, right + 1); 
                }

                if (mapT.containsKey(s.charAt(left))) {
                    mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);

                    if (mapS.get(s.charAt(left)) < mapT.get(s.charAt(left))) {
                        charCount--;
                    }
                } 

                left++;
            } 
        }

        return shortest; 
    }
}
 