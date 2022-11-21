package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int N = 8;
        int M = 10000;
        for (int i = 0; i < N; i++) {
            int count = 1000 * (int)Math.pow(2, i);
            Ns.addLast(count);
            opCounts.addLast(M);
            SLList<Integer> test = new SLList<>();
            for (int j = 0; j < count; j++) {
                test.addFirst(0);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < M; j++) {
                test.getLast();
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(Ns, times, opCounts);
    }

}
