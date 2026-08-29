class TimeMap {
    private static class Data {
        String value;
        int timeStamp;

        Data(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timeStamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timeStamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Data> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timeStamp <= timestamp) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
