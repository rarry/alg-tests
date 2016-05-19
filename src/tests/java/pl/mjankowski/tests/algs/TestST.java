package pl.mjankowski.tests.algs;

import org.junit.Test;
import pl.mjankowski.tests.algs.ds.Key;
import pl.mjankowski.tests.algs.ds.STSeparateChaining;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 14.05.16
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
public class TestST {

    private static class NKey implements Key<Integer>{

        private Integer i;

        private NKey(Integer i) {
            this.i = i;
        }

        @Override
        public int compareTo(Integer o) {
            return o.compareTo(i);
        }

        @Override
        public int hashCode() {
            return i.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NKey nKey = (NKey) o;

            if (i != null ? !i.equals(nKey.i) : nKey.i != null) return false;

            return true;
        }
    }

    @Test
    public void testSeparateChaining() {

        NKey key1 = new NKey(1);
        NKey key2 = new NKey(7);
        NKey key3 = new NKey(3);

//        System.out.println(key1.hashCode());
//        System.out.println(key2.hashCode());
//        System.out.println(key3.hashCode());

        NKey key11 = new NKey(1);
        NKey key22 = new NKey(7);
        NKey key33 = new NKey(3);

//        System.out.println(key11.hashCode());
//        System.out.println(key22.hashCode());
//        System.out.println(key33.hashCode());


        STSeparateChaining st = new STSeparateChaining();
        st.add(new NKey(1), 97);
        st.add(new NKey(7), 104);
        st.add(new NKey(3), 24);

        System.out.println(st.get(new NKey(1)));
        System.out.println(st.get(new NKey(7)));
        System.out.println(st.get(new NKey(3)));
        System.out.println(st.get(new NKey(10)));
    }
}
