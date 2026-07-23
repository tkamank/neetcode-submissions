class DynamicArray {
    public int[] arr = null;
    public int cap = 0;
    public int size = 0;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.cap = capacity;
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.cap == this.size) {
            resize();
        }
        this.arr[this.size++] = n;
    }

    public int popback() {
        int pop = this.arr[--this.size];
        this.arr[this.size] = 0;
        return pop;
    }

    private void resize() {
        int nSize = this.cap * 2;
        int[] temp = new int[nSize];
        //Copy over old array
        for (int n = 0; n < this.cap; n++) {
            temp[n] = this.arr[n];
        }
        this.arr = temp;
        this.cap = nSize;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.cap;
    }
}
