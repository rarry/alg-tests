package pl.mjankowski.tests.algs;

import org.junit.Assert;
import org.junit.Test;
import pl.mjankowski.tests.algs.union.QuickUnionUF;

/**
 * Created by mjankowski on 2016-05-10.
 */
public class TestQuickUnionUF {

    @Test
    public void test(){
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(4,3);
        uf.union(3,8);
        uf.union(6,5);

        uf.union(9,4);
        uf.union(2,1);
        uf.union(5,0);
        uf.union(7,2);
        uf.union(6,1);
        uf.union(7,3);

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(!uf.connected(i,j)){
                    Assert.fail();
                }
            }
        }
    }
}
