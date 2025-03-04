import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static void bwEnd() throws IOException {
        bw.flush();
        bw.close();
    }

    static void readLine() throws IOException {
        st = new StringTokenizer(br.readLine());
    }

    static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static int ans = -1;

    static void solve(int cnt, int start) {
        if (cnt == 3) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    total += arr[i];
            }

            if (total <= M) {
                if (total > ans) {
                    ans = total;
                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        readLine();
        N = nextInt();
        M = nextInt();
        arr = new int[N];
        visited = new boolean[N];
        readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = nextInt();
        }
        solve(0, 0);
        bw.write("" + ans + "\n");

        bwEnd();
    }

}
