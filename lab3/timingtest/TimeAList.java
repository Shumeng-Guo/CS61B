package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        // TODO: YOUR CODE HERE
        for (int N = 1000; N < 128000; N=2*N) {
            Ns.addLast(N);
            opCounts.addLast(N);
            Stopwatch sw = new Stopwatch();
            AList<Integer> aList = new AList<>();
            for (int j = 0; j < N; j++) {
                aList.addLast(1);
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(Ns, times, opCounts);
    }
}
