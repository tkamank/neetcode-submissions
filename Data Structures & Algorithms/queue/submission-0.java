class Deque {
    ArrayList<Integer> qu = new ArrayList<Integer>();
    public Deque() {
    }

    public boolean isEmpty() {
        return this.qu.isEmpty();
    }

    public void append(int value) {
       this.qu.add(value);
    }

    public void appendleft(int value) {
        this.qu.add(0,value);
    }

    public int pop() {
        if(qu.isEmpty()) return -1;
        int val = qu.get(qu.size()-1);
        this.qu.remove(qu.size()-1);
        return val;
    }

    public int popleft() {
        if(qu.isEmpty()) return -1;
        int val = this.qu.get(0);
        this.qu.remove(0);
        return val;
    }
}
