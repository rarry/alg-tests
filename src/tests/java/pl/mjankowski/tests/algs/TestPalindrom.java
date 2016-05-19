package pl.mjankowski.tests.algs;


import org.junit.Test;
import pl.mjankowski.tests.algs.zad.Palindrom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 18.05.16
 * Time: 20:57
 * To change this template use File | Settings | File Templates.
 */
public class TestPalindrom {

    @Test
    public void test(){

        String str = "mohammadsajjadhossain";

        List<Character> chars = new ArrayList<Character>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }

        Palindrom p = new Palindrom(str);
        System.out.println(p.getMin());

    }

}
