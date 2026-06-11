class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, List<String>> map = new Hashtable<>();

        for (int i = 0; i < strs.length; i++) { // Go through each elem in String arr
            int[] count = new int[26];

            // Add a counter for each char that appears in the elem's string
            for (int j = 0; j < strs[i].length(); j++) { 
                count[strs[i].charAt(j) - 'a']++;
            }

            // Convert int arr to String in sorted order as anagrams will have same counted int arr order
            String key = Arrays.toString(count);

            // Check if hashmap contains String in sorted order
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>()); // if String does not exist then new arraylist added
            }
            map.get(key).add(strs[i]); // if string exists, add curr str to the list
        }

        return new ArrayList<>(map.values());
    }
}
