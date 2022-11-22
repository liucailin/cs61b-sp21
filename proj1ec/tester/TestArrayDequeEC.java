package tester;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestArrayDequeEC {
    @Test
    public void randomTest() {

        int N = 5000;
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StringBuilder msg = new StringBuilder();
        msg.append("\n");
        for (int i = 0; i < N; i++) {
            int op = StdRandom.uniform(0, 5);
            if (op == 0) {
                int val = StdRandom.uniform(0, 100);
                student.addFirst(val);
                solution.addFirst(val);
                msg.append(String.format("addFirst(%s)\n", val));
            } else if (op == 1) {
                int val = StdRandom.uniform(0, 100);
                student.addLast(val);
                solution.addLast(val);
                msg.append(String.format("addLast(%s)\n", val));
            } else if (op == 2) {
                if (!student.isEmpty() && !solution.isEmpty()) {
//                    msg.append(String.format("curDeque -> %s", getDequeString(student)));
                    msg.append("removeFirst()\n");
                    assertEquals(msg.toString(), solution.removeFirst(), student.removeFirst());
                    msg.append(String.format("curDeque -> %s", getDequeString(student)));
                }
            } else if (op == 3) {
                if (!student.isEmpty() && !solution.isEmpty()) {
//                    msg.append(String.format("curDeque -> %s", getDequeString(student)));
                    msg.append("removeLast()\n");
                    assertEquals(msg.toString(), solution.removeLast(), student.removeLast());
                    msg.append(String.format("curDeque -> %s", getDequeString(student)));
                }
            } else if (op == 4) {
                if (!student.isEmpty() && !solution.isEmpty()) {
                    int index = StdRandom.uniform(0, solution.size());
                    msg.append(String.format("get(%s)\n", index));
                    msg.append(String.format("curDeque -> %s", getDequeString(student)));
                    assertEquals(msg.toString(), solution.get(index), student.get(index));
                }
            }

        }

    }

    private String getDequeString(StudentArrayDeque deque) {
        PrintStream ps = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        deque.printDeque();
        System.out.flush();
        System.setOut(ps);

        return baos.toString();
    }

}
