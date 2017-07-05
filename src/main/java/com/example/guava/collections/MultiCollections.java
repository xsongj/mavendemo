package com.example.guava.collections;

import java.util.Collection;
import java.util.Random;
import java.util.function.Predicate;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import org.junit.Test;

/**
 * description  guava 新集合类型：
 *      1. MultiSet
 *      2. MultiMap
 *      3. BiMap 可以用 inverse()反转BiMap<K, V>的键值映射，保证值是唯一的，因此 values()返回Set而不是普通的Collection
 *      4. Table 它有两个支持所有类型的键：”行”和”列”。Table提供多种视图，以便你从各种角度使用它：
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/5
 */
public class MultiCollections {
    //Multiset 它可以多次添加相等的元素，增加了计数的功能。
    @Test
    public void test1() throws InterruptedException {
        Multiset<Integer> multiset = HashMultiset.create();
        Random random = new Random();
        Predicate<Integer> predicate = i -> (i <= 10) ;
        int element = random.nextInt(12);
        while (predicate.test(element)){
            multiset.add(element);
            element = random.nextInt(12);
        }
        Thread.sleep(100);
        multiset.forEach(elem -> System.out.println(elem +": " + multiset.count(elem)));
    }

    @Test
    public void test0(){
        MultiCollections instance = new MultiCollections();
        System.out.println(instance.getClass().getName()+"####"+
            instance.getClass().getMethods()[0].getDeclaringClass());
    }

    // multiMap :类似于a -> [1, 2, 4] b -> 3 c -> 5 的结构。
    @Test
    public void test2(){
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("a", "b");
        multimap.put("a", "b");
        multimap.put("a", "c");
        multimap.put("a", "d");
        multimap.put("a", "e");
        multimap.put("a", "f");
        multimap.put("u", "v");
        multimap.put("w", "x");

        // 返回Map的视图
        Collection<String> res = multimap.get("a");
        System.out.println(multimap);
    }
}
