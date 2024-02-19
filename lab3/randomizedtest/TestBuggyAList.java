package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        aListNoResizing.addLast(4);
        buggyAList.addLast(4);

        aListNoResizing.addLast(5);
        buggyAList.addLast(5);

        aListNoResizing.addLast(6);
        buggyAList.addLast(6);

        assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
        assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
        assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                assertEquals(L.getLast(), buggyAList.getLast());

            } else if (operationNumber == 1) {
                // size
                System.out.println("size in AList: " + L.size());
                System.out.println("size in BuggyAList: " + buggyAList.size());
                assertEquals(L.size(), buggyAList.size());

            } else if (operationNumber == 2) {
                // getLast
                if (L.size() != 0 && buggyAList.size() != 0) {
                    System.out.println("The last item in AList: " + L.getLast());
                    System.out.println("The last item in BuggyAList: " + buggyAList.getLast());
                    assertEquals(L.getLast(), buggyAList.getLast());
                } else {
                    System.out.println("Size = 0 when trying to removeLast.");
                }
            } else {
                if (L.size() != 0 && buggyAList.size() != 0) {
                    assertEquals(L.removeLast(), buggyAList.getLast());
                } else {
                    System.out.println("Size = 0 when trying to removeLast.");
                }
            }
        }
    }
}
