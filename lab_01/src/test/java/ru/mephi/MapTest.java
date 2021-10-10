package ru.mephi;

import static org.junit.Assert.*;

public class MapTest {

    @org.junit.Test
    public void put() {
        Map map = new Map();
        map.put("test", 1234);

        List list = map.getEntries();
        Map.Element elem = (Map.Element)(list.get(0));
        assertEquals(elem.key, "test");
        assertEquals(elem.value, 1234);
    }

    @org.junit.Test
    public void remove() {
    }

    @org.junit.Test
    public void keyContains() {
    }

    @org.junit.Test
    public void getKeys() {
    }

    @org.junit.Test
    public void getValues() {
    }

    @org.junit.Test
    public void getEntries() {
    }

    @org.junit.Test
    public void size() {
    }

    @org.junit.Test
    public void isEmpty() {
    }
}