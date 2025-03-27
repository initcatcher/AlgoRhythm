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

    static long nextLong() {
        return Long.parseLong(st.nextToken());
    }

    static int N, M;

    static ArrayList<Pos> houses, chickens;

    static int[] parent;
    static ArrayList<ArrayList<Edge>> edges;
    static int ans;
    static boolean[] visited;


    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

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

        public String toString() {
            return String.format("%d %d %d", this.u, this.v, this.weight);
        }
    }

    static void backTracking(int cur, int count) {
        if (count == M) {
            int total = 0;
            for (int i = 0; i < houses.size(); i++) {
                ArrayList<Edge> dis = edges.get(i);

                for (int j = 0; j < dis.size(); j++)
                    if (visited[dis.get(j).v]) {
                        total += dis.get(j).weight;
                        break;
                    }
            }

            ans = Math.min(ans, total);
            return;
        }

        for (int i = cur; i < chickens.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                backTracking(i + 1, count + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        readLine();
        N = nextInt();
        M = nextInt();

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < N; j++) {
                if (line[j] == 1)
                    houses.add(new Pos(i, j));
                else if (line[j] == 2)
                    chickens.add(new Pos(i, j));
            }
        }
        edges = new ArrayList<>();

        for (int i = 0; i < houses.size(); i++) {
            ArrayList<Edge> dis = new ArrayList<>();

            for (int j = 0; j < chickens.size(); j++) {
                dis.add(new Edge(i, j, Math.abs(houses.get(i).x - chickens.get(j).x)
                        + Math.abs(houses.get(i).y - chickens.get(j).y)));
            }
            Collections.sort(dis);
            edges.add(dis);
        }

        visited = new boolean[chickens.size()];
        ans = Integer.MAX_VALUE;
        backTracking(0, 0);

        bw.write(String.format("%d\n", ans));
        bwEnd();
    }
}
