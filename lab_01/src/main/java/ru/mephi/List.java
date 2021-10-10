package ru.mephi;

public class List {
    public List() {
        this.listCapacity = 10;
        this.lastIndex = 0;
        this.arr = new Object[listCapacity];
    }

    public List(int listCapacity) {
        this.listCapacity = listCapacity;
        this.lastIndex = 0;
        this.arr = new Object[listCapacity];
    }

    public List(Object[] arr) {
        this.listCapacity = arr.length + (int)Math.floor(arr.length * 0.3);
        this.lastIndex = arr.length;
        this.arr = arr;
    }

    public void add(Object value) {
        if (lastIndex > (listCapacity - 1)) {
            Object[] newArr = new Object[calcNewCapacity()];
            System.arraycopy(this.arr, 0, newArr, 0, this.listCapacity);
            this.arr = newArr;
            this.listCapacity = calcNewCapacity();
        }
        this.arr[lastIndex] = value;
        this.lastIndex++;
    }

    public Object remove(int index) {
        if (index < 0 || index >= this.lastIndex) return null;

        Object tempObj = this.arr[index];

        for (int i = index; i < this.arr.length - 1; i++) { //arr.length -> lastIndex
            this.arr[i] = this.arr[i+1];
        }
        this.lastIndex--;

        return tempObj;
    }

    public Object get(int index) {
        if (index < 0 || index >= this.listCapacity) return null; //lastIndex -> listCapacity
        return this.arr[index];
    }

    public int indexOf(Object value) {
        for (int i = 0; i < this.lastIndex; i++)
        {
            if (this.arr[i] == value) return i;
        }

        return -1;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < this.lastIndex; i++)
        {
            if (this.arr[i].equals(value)) return true;
        }

        return false;
    }

    public Object set(Object value, int index) {
        if (index < 0 || index >= this.lastIndex) return null;


        Object temp = this.arr[index];
        this.arr[index] = value;

        return temp;
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

    private int calcNewCapacity() {
        return this.listCapacity + (int)Math.floor(this.listCapacity * 0.3);
    }

    private Object[] arr;
    private int listCapacity;
    private int lastIndex;
}

