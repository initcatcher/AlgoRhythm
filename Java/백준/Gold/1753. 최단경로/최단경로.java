import java.io.*;
import java.util.*;

public class Main {
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

    static int V, E, K;
    static int[] distance;


    static ArrayList<ArrayList<Edge>> edges;

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    static void solve() throws IOException {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge currnet = pq.poll();
            int curNode = currnet.to;
            int curDist = currnet.weight;

            if (curDist > distance[curNode])
                continue;

            for (Edge edge : edges.get(curNode)) {
                if (distance[edge.to] > curDist + edge.weight) {
                    distance[edge.to] = curDist + edge.weight;
                    pq.offer(new Edge(edge.to, distance[edge.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        readLine();
        V = nextInt();
        E = nextInt();
        readLine();
        K = nextInt();

        edges = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            edges.add(new ArrayList<>());

        int u, v, w;
        for (int i = 0; i < E; i++) {
            readLine();
            u = nextInt();
            v = nextInt();
            w = nextInt();

            edges.get(u).add(new Edge(v, w));
        }
        distance = new int[V + 1];

        solve();

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(distance[i] + "\n");
        }
        bwEnd();
    }
}
