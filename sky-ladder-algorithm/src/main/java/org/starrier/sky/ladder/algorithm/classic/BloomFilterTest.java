package org.starrier.sky.ladder.algorithm.classic;

import java.util.BitSet;

/**
 * 布隆过滤器
 * <p>
 * {@link }
 *
 * @author starrier
 * @date 2020/11/27
 */
public class BloomFilterTest {

    private static final int DEFAULT_SIZE = 2 << 24;

    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public BloomFilterTest() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    public static void main(String[] args) {
        final String value = "starrier@starrier.org";
        BloomFilterTest filterT = new BloomFilterTest();
        System.out.println(filterT.contains(value));
        filterT.add(value);
        System.out.println(filterT.contains(value));
    }

    public void add(String value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    public static class SimpleHash {

        private int cap;

        private int seed;

        private SimpleHash() {
        }

        public SimpleHash(int defaultSize, int seed) {
            this.cap = defaultSize;
            this.seed = seed;
        }

        private int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (cap - 1) & result;
        }
    }
}
