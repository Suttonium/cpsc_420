import java.util.ArrayList;

public class Sieve {
    public static ArrayList<Integer> sieve(Integer n) {
        Integer[] A = new Integer[n + 1];
        for (int i = 2; i <= n; i++) {
            A[i] = i;
        }
        for (int p = 2; p <= (int) Math.sqrt(n); p++) {
            if (A[p] != 0) {
                int j = p * p;
                while (j <= n) {
                    A[j] = 0;
                    j = j + p;
                }
            }
        }
        ArrayList<Integer> L = new ArrayList<>();
        for (int m = 2; m <= n; m++) {
            if (A[m] != 0) {
                L.add(A[m]);
            }
        }
        return L;
    }
}
