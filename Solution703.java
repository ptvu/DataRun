class KthLargest {

    // keep the largest k numbers
    private TreeMap<Integer, Integer> map;
    private int total;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.map = new TreeMap<Integer, Integer>();
        this.total = 0;
        this.k = k;
        for (int each : nums) {
            add(each);
        }
    }

    public int add(int val) {
        if (this.total < this.k) {
            this.pureAddToMap(val);
            this.total = this.total + 1;
            return this.map.firstKey();
        } else {
            int smallest = this.map.firstKey();
            if (val > smallest) {
                this.pureRemoveFromMap(smallest);
                this.pureAddToMap(val);
                return this.map.firstKey();
            } else {
                return this.map.firstKey();
            }
        }
    }

    private void pureRemoveFromMap(int smallest) {
        if (this.map.containsKey(smallest)) {
            int newCount = this.map.get(smallest) - 1;
            if (newCount == 0) {
                this.map.remove(smallest);
            } else {
                this.map.put(smallest, newCount);
            }
        }
    }

    private void pureAddToMap(int val) {
        if (!this.map.containsKey(val)) {
            this.map.put(val, 0);
        }
        int newCount = 1 + this.map.get(val);
        this.map.put(val, newCount);
    }
}
