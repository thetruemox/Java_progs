package ru.mephi;

public class Map {


    public Map() {
        this.mapCapacity = 10;
        //this.mapSize = 0;
        this.list = new List(10);

        for (int i = 0; i < this.mapCapacity; ++i) {
            this.list.add(new List());
        }
    }

    public void put(Object key, Object value) {
        if (((String)key).length() == 0) { return; }

        int index = hash(key);
        List collisionList;

        collisionList = (List)this.list.get(index);

        Element element = new Element(key, value);

        if (keyContains(key)) {
            for (int i = 0; i < collisionList.size(); i++) {
                if (key.equals(((Element)collisionList.get(i)).key)) {
                    collisionList.set(element, i);
                }
            }
        } else {
            collisionList.add(element);
        }
        return;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < this.mapCapacity; ++i) {
            size += ((List)this.list.get(i)).size();
        }
        return size;
    }

    public boolean isEmpty() {
        if (size() == 0)
            return true;
        else
            return false;
    }

    public List getValues() {
        List valueList = new List();

        List listTemp;
        for (int i = 0; i < this.list.capacity(); ++i) {
            listTemp = (List)this.list.get(i);

            if (listTemp != null) {
                for (int j = 0; j < listTemp.size(); ++j) {
                    valueList.add(((Element) listTemp.get(j)).value);
                }
            }
        }

        return valueList;
    }

    public List getEntries() {
        List entriesList = new List();

        List listTemp;
        for (int i = 0; i < this.list.capacity(); ++i) {
            listTemp = (List)this.list.get(i);

            if (listTemp != null) {
                for (int j = 0; j < listTemp.size(); ++j) {
                    entriesList.add((Element) listTemp.get(j));
                }
            }
        }

        return entriesList;
    }

    public List getKeys() {
        List keyList = new List();

        List listTemp;
        for (int i = 0; i < this.list.capacity(); ++i) {
            listTemp = (List)this.list.get(i);

            if (listTemp != null) {
                for (int j = 0; j < listTemp.size(); ++j) {
                    keyList.add(((Element) listTemp.get(j)).key);
                }
            }
        }

        return keyList;
    }

    public Object remove(Object key) {
        if (((String)key).length() == 0) { return null; }
        if (!keyContains(key)) { return null; }

        int index = hash(key);
        List collisionList = (List)this.list.get(index);

        Element temp;

        for (int i = 0; i < collisionList.size(); ++i) {
            if (key.equals(((Element)collisionList.get(i)).key))  {
                temp = (Element)collisionList.remove(i);
                return temp.value;
            }
        }

        return null;
    }

    public Object get(Object key) {
        if (((String)key).length() == 0) { return null; }
        int index = hash(key);
        List collisionList = (List)this.list.get(index);

        for (int i = 0; i < collisionList.size(); ++i) {
            if (key.equals(((Element)collisionList.get(i)).key)){
                return ((Element)collisionList.get(i)).value;
            }
        }

        return null;
    }

    public Object get(Object key, Object bydefault) {
        if (((String)key).length() == 0) { return null; }
        int index = hash(key);
        List collisionList = (List)this.list.get(index);

        for (int i = 0; i < collisionList.size(); ++i) {
            if (key.equals(((Element)collisionList.get(i)).key))  {
                return ((Element)collisionList.get(i)).value;
            }
        }

        put(key, bydefault); // Значение по умолчанию необходимо сохранить.
        return bydefault;
    }

    public boolean keyContains(Object key) {
        if (((String)key).length() == 0) { return false; }
        List listTemp;
        for (int i = 0; i < this.list.capacity(); ++i) {
            listTemp = (List)this.list.get(i);

            if (listTemp != null) {
                for (int j = 0; j < listTemp.size(); ++j) {
                    if (((Element) listTemp.get(j)).key == key) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int hash(Object key) {
        String sKey = key.toString();

        if (sKey.length() == 0) {
            return -1;
        }

        int index = 0;

        for (int i = 0; i < sKey.length(); ++i) {
            index += (int)sKey.charAt(i);
        }
        while (index >= this.mapCapacity) {
            index /= this.mapCapacity;
        }
        return index;
    };

    public class Element {
        public Element (Object key, Object value) {
            this.key = key;
            this.value = value;
        }
        public Object key;
        public Object value;
    }

    private int mapCapacity;
    //private int mapSize;
    private List list;
}

