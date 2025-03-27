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
    static int V, E;

    static int[] parent;
    static ArrayList<Edge> edges;
    static long ans;


    static class Edge implements Comparable<Edge> {
        int u, v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        readLine();
        T = nextInt();
        for (int t = 1; t <= T; t++) {
            readLine();
            V = nextInt();
            E = nextInt();

            int a, b, c;
            edges = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                readLine();
                a = nextInt();
                b = nextInt();
                c = nextInt();

                edges.add(new Edge(a, b, c));
            }
            Collections.sort(edges);

            parent = new int[V + 1];
            for (int i = 1; i <= V; i++)
                parent[i] = i;

            ans = 0;
            for (Edge e : edges) {
                if (find(e.u) != find(e.v)) {
                    union(e.u, e.v);
                    ans += e.weight;
                }
            }

            bw.write(String.format("#%d %d\n", t, ans));
        }
        bwEnd();
    }
}
