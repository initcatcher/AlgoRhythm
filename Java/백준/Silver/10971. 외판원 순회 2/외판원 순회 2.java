import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, ALL_VISITED;
    static final int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        ALL_VISITED = (1 << N) - 1;

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[1 << N][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int answer = tsp(0, 1, cost, dp);
        System.out.println(answer);
    }

    static int tsp(int cur, int visited, int[][] cost, int[][] dp) {
        if (visited == ALL_VISITED) {
            return (cost[cur][0] != 0) ? cost[cur][0] : INF;
        }

        if (dp[visited][cur] != -1) {
            return dp[visited][cur];
        }

        int minCost = INF;
        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && cost[cur][next] != 0) {
                int newCost = cost[cur][next] + tsp(next, visited | (1 << next), cost, dp);
                minCost = Math.min(minCost, newCost);
            }
        }

        dp[visited][cur] = minCost;
        return minCost;
    }
}
