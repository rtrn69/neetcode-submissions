class MinStack {
    private ArrayList<Integer> arr;
    private ArrayList<Integer> sorted;

    public MinStack() {
        this.arr = new ArrayList<Integer>();
        this.sorted = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        this.arr.add(val);

        if (this.sorted.isEmpty()) {
            this.sorted.add(val);
        } else if (this.sorted.get(this.sorted.size() - 1) >= val) {
            this.sorted.add(val);
        }
    }
    
    public void pop() {
        int removedVal = this.arr.remove(this.arr.size() - 1);
        
        if (removedVal == this.sorted.get(this.sorted.size() - 1)) {
            this.sorted.remove(this.sorted.size() - 1);
        }
    }
    
    public int top() {
        return this.arr.get(this.arr.size() - 1);
    }
    
    public int getMin() {
        return this.sorted.get(this.sorted.size() - 1);
    }
}
