package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testNull() {
        Integer[] index1 = null;
        ArrayList < Integer > index2 = null;
        String[] set1 = null;
        ArrayList < String > set2 = null;
        ArrayList < String > res = null;
        List < String > ret = new App().chooseAndMerge(index1, index2, set1, set2);
        assertEquals(res, ret);
    }

    public void testCorrectOrder() {
        Integer[] index1 = new Integer[] {0, 1, 2};
        ArrayList < Integer > index2 = new ArrayList < Integer > (Arrays.asList(0, 1));
        String[] set1 = new String[] {"a", "c", "b"};
        ArrayList < String > set2 = new ArrayList < String > (Arrays.asList("d", "e"));
        ArrayList < String > res = new ArrayList < String > (Arrays.asList("a", "b", "c", "d", "e"));
        List < String > ret = new App().chooseAndMerge(index1, index2, set1, set2);
        assertEquals(res, ret);
    }

    public void testWrongIndices() {
        Integer[] index1 = new Integer[] {-1, 123123, 0};
        ArrayList < Integer > index2 = new ArrayList < Integer > (Arrays.asList(-1, -2, -3, -555, 1));
        String[] set1 = new String[] {"abaca", "acaba"};
        ArrayList < String > set2 = new ArrayList < String > (Arrays.asList("baba", "dede"));
        ArrayList < String > res = new ArrayList < String > (Arrays.asList("abaca", "dede"));
        List < String > ret = new App().chooseAndMerge(index1, index2, set1, set2);
        assertEquals(res, ret);
    }

    public void testSameElements() {
        Integer[] index1 = new Integer[] {0, 0, 0, 1, 1, 1};
        ArrayList < Integer > index2 = new ArrayList < Integer > (Arrays.asList(0, 0, 0, 1, 1, 1));
        String[] set1 = new String[] {"abc", "def"};
        ArrayList < String > set2 = new ArrayList < String > (Arrays.asList("ghi", "jkl"));
        ArrayList < String > res = new ArrayList < String > (Arrays.asList("abc", "abc", "abc", "def", "def", "def", "ghi", "ghi", "ghi", "jkl", "jkl", "jkl"));
        List < String > ret = new App().chooseAndMerge(index1, index2, set1, set2);
        assertEquals(res, ret);
    }

    public void testEmpty() {
        Integer[] index1 = new Integer[] {};
        ArrayList < Integer > index2 = new ArrayList < Integer > (Arrays.asList(0, 1));
        String[] set1 = new String[] {"not", "not", "not"};
        ArrayList < String > set2 = new ArrayList < String > (Arrays.asList("must", "must"));
        ArrayList < String > res = new ArrayList < String > (Arrays.asList("must", "must"));
        List < String > ret = new App().chooseAndMerge(index1, index2, set1, set2);
        assertEquals(res, ret);
    }
}
