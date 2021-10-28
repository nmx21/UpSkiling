package com.study.datastructures.map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


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
        map.put("user", "Tolik");
        map.put("user1", "Tolik");
        map.put("user2", "Tolik");
        map.put("user3", "Tolik");
        map.put("user4", "Tolik");
        map.put("user5", "Tolik");
        map.put("user6", "Tolik");
        map.put("user7", "Tolik");
        map.put("user8", "Tolik");
        map.put("user9", "Tolik");
        map.put("user10", "Tolik");
        map.put("user12", "Tolik");
        map.put("user13", "Tolik");
        map.put("user14", "Tolik");
        map.put("user15", "Tolik");
        map.put("user16", "Tolik");
        map.put("user17", "Tolik");
        map.put("user18", "Tolik");
        map.put("user19", "Tolik");
        map.put("user20", "Tolik");
        map.put("user21", "Tolik");
    }
}