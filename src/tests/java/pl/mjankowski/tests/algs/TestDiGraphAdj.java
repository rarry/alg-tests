package pl.mjankowski.tests.algs;

import org.junit.Test;
import pl.mjankowski.tests.algs.graph2.DiGraphAdj;

import java.util.Deque;

/**
 * Created by mjankowski on 2016-05-05.
 */
public class TestDiGraphAdj {

    @Test
    public void testTopologicalSort() {
        DiGraphAdj graph = new DiGraphAdj(7);

        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(5, 2);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);

        Deque<Integer> stack = graph.topologicalSort();

        while (!stack.isEmpty()) {
            Integer e = stack.pop();
            System.out.println(e);
        }
    }

    @Test
    public void testTopologicalSort2() {
        DiGraphAdj graph = new DiGraphAdj(13);

        graph.addEdge(0,6);
        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(5,4);
        graph.addEdge(6,4);
        graph.addEdge(6,9);
        graph.addEdge(7,6);
        graph.addEdge(8,7);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

        Deque<Integer> stack = graph.topologicalSort();

        while (!stack.isEmpty()) {
            Integer e = stack.pop();
            System.out.println(e);
        }
    }

    @Test
    public void testStrongComponents() {
        DiGraphAdj graph = new DiGraphAdj(13);

        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,2);
        graph.addEdge(3,5);
        graph.addEdge(4,2);
        graph.addEdge(4,3);
        graph.addEdge(5,4);
        graph.addEdge(6, 0);
        graph.addEdge(6,4);
        graph.addEdge(6,8);
        graph.addEdge(6,9);
        graph.addEdge(7,6);
        graph.addEdge(7,9);
        graph.addEdge(8,6);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(10,12);
        graph.addEdge(11,4);
        graph.addEdge(11,12);
        graph.addEdge(12,9);

        int[] strongComponents = graph.strongComponent();

        for(int i=0; i<strongComponents.length; i++){
            System.out.println(strongComponents[i]+"\t");
        }
    }
}
