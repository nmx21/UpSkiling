package com.study.datastructures.map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    @Test
    void testHashMap() {
        Map map = new HashMap();
        map.put("user", "Tolik");
        map.put("password", "Java");
        Assert.assertEquals(2,map.size()); // 2
        Assert.assertEquals("Tolik",map.get("user"));  // Tolik
        Assert.assertEquals("Java",map.put("password", "record")); // Java
        Assert.assertTrue(map.containsKey("user")); // true
        Assert.assertNull(map.remove("someKeyNotExist"));
        Assert.assertEquals("Tolik",map.remove("user"));
        Assert.assertEquals(1, map.size());
    }
}