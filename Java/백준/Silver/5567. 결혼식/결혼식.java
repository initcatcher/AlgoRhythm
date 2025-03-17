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

	static void readline() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static int nextInt() {
		return Integer.parseInt(st.nextToken());
	}

	static long nextLong() {
		return Long.parseLong(st.nextToken());
	}

	static int[][] adj = new int[501][501];
	static int N;
	static int M;

	static boolean[] visited = new boolean[501];

	static int ans;

	public static void main(String[] args) throws Exception {

		readline();
		N = nextInt();
		readline();
		M = nextInt();

		int a = 0, b = 0;
		for (int i = 0; i < M; i++) {
			readline();
			a = nextInt();
			b = nextInt();
			adj[a][b] = adj[b][a] = 1;
		}

		ArrayList<Integer> friend = new ArrayList<>();

		for (int i = 2; i <= N; i++) {
			if (adj[1][i] == 1) {
				visited[i] = true;
				friend.add(i);
			}
		}

		for (int person : friend)
			for (int i = 1; i <= N; i++)
				if (adj[person][i] == 1)
					visited[i] = true;

		int count = 0;
		for (int i = 2; i <= N; i++)
			if (visited[i])
				count++;

		bw.write(String.format("%d\n", count));
		bwEnd();
	}

}
