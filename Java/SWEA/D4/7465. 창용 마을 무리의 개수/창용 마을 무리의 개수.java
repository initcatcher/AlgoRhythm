import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

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

    static long nextLong() {
        return Long.parseLong(st.nextToken());
    }

    static int T;
    static int N, M;
    static HashMap<Integer, Node> nodes = new HashMap<>();
    static String ans;

    static class Node {
        int par;
        int num;

        Node(int num) {
            this.par = num;
            this.num = num;
        }
    }

    static int find(int a) {
        if (nodes.get(a).par != a) {
            nodes.get(a).par = find(nodes.get(a).par);
        }
        return nodes.get(a).par;
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            nodes.get(rootB).par = rootA;
        }
    }

    static void solve() throws Exception {
        int a, b;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            readLine();
            a = nextInt();
            b = nextInt();

            if (!nodes.containsKey(a))
                nodes.put(a, new Node(a));
            if (!nodes.containsKey(b))
                nodes.put(b, new Node(b));

            union(a, b);
        }

        HashSet<Integer> uniqueGroups = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            if (!nodes.containsKey(i))
                nodes.put(i, new Node(i));
            uniqueGroups.add(find(i));
        }

        sb.append(uniqueGroups.size());

        ans = sb.toString();
    }

    public static void main(String[] args) throws Exception {
        readLine();
        T = nextInt();
        for (int t = 1; t <= T; t++) {
            readLine();
            N = nextInt();
            M = nextInt();
            nodes = new HashMap<>();

            solve();
            bw.write(String.format("#%d %s\n", t, ans));
        }
        bwEnd();
    }
}
