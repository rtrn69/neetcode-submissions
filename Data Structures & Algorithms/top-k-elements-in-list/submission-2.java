class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Hashtable<Integer, Integer> map = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = keys.get(i);
        }

        return ans;
    }
}