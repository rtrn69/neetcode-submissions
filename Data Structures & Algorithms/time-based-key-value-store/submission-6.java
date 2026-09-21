class TimeMap {
    private HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        ArrayList<Pair> pairs = map.get(key);
        int left = 0, right = pairs.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = (left + right) / 2;
            if (pairs.get(mid).timestamp <= timestamp) {
                result = pairs.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

class Pair {
    private int timestamp;
    private String value;

    public Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}