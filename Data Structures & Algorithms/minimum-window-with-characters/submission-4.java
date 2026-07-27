class Solution {
    public String minWindow(String s, String t) {
        // base case
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> mapT = new HashMap<>();
        int charNeeded = 0;
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
            charNeeded++;
        }

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
 