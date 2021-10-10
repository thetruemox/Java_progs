package ru.mephi;

public class List {
    private int[] arr;
    private int listCapacity;
    private int lastIndex;
    private int calcNewCapacity() {
        return this.listCapacity + (int)Math.floor(this.listCapacity * 0.3);
    }

    public List() {
        this.listCapacity = 10;
        this.lastIndex = 0;
        this.arr = new int[listCapacity];
    }

    public List(int listCapacity) {
        this.listCapacity = listCapacity;
        this.lastIndex = 0;
        this.arr = new int[listCapacity];
    }

    public List(int[] arr) {
        this.listCapacity = arr.length + (int)Math.floor(arr.length * 0.3);
        this.lastIndex = arr.length;
        this.arr = arr;
    }

    public void add(int value) {
        if (lastIndex > (listCapacity - 1)) {
            int[] newArr = new int[calcNewCapacity()];
            System.arraycopy(this.arr, 0, newArr, 0, this.listCapacity);
            this.arr = newArr;
            this.listCapacity = calcNewCapacity();
        }
        this.arr[lastIndex] = value;
        this.lastIndex++;
    }

    public int remove(int index) {
        try {
            if (index < 0 || index >= this.lastIndex)
                throw new Exception("method remove is dead : IndexOutOfBoundsException");
            int tempObj = this.arr[index];
            for (int i = index; i < this.arr.length - 1; i++) { //arr.length -> lastIndex
                this.arr[i] = this.arr[i + 1];
            }
            this.lastIndex--;
            return tempObj;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } return -1;
    }

    public int get(int index) {
        try {
            if (index < 0 || index >= this.lastIndex) throw new Exception("method get is dead : IndexOutOfBoundsException");
            return this.arr[index];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } return -1;
    }

    public int indexOf(int value) {
        for (int i = 0; i < this.lastIndex; i++) {
            if (this.arr[i] == value) return i;
        }

        return -1;
    }

    public boolean contains(int value) {
        for (int i = 0; i < this.lastIndex; i++) {
            if (this.arr[i] == value) return true;
        }

        return false;
    }

    public int set(int value, int index) {
        try {
            if (index < 0 || index >= this.lastIndex) throw new Exception("method set is dead : IndexOutOfBoundsException");
            int temp = this.arr[index];
            this.arr[index] = value;
            return temp;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } return -1;
    }

    public int size() {
        return this.lastIndex;
    }

    public int capacity() {
        return  this.listCapacity;
    }

    public boolean isEmpty() {
        if (this.lastIndex == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < this.lastIndex - 1; i++) {
            if (this.arr[i] > this.arr[i+1]) return false;
        }
        return true;
    }

    static public List merge(List first, List second) {
        if (!first.isSorted() && !second.isSorted()) return null;

        List newList = new List();
        int fI = 0, sI = 0;

        for (int i = 0; i < (first.lastIndex + second.lastIndex); i++) {
            if (fI == first.lastIndex) {
                newList.add(second.arr[sI]);
                sI++;
            } else if (sI == second.lastIndex) {
                newList.add(first.arr[fI]);
                fI++;
            } else {
                if (first.arr[fI] < second.arr[sI]) {
                    newList.add(first.arr[fI]);
                    fI++;
                } else {
                    newList.add(second.arr[sI]);
                    sI++;
                }
            }
        }

        return newList;
    }
}

