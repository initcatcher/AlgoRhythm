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

	static class Pos {
		int y;
		int x;
		boolean isHorizontal;
		int count;

		Pos(int y, int x, boolean isHorizontal) {
			this.y = y;
			this.x = x;
			this.isHorizontal = isHorizontal;
			this.count = 0;
		}

		Pos(int y, int x, boolean isHorizontal, int count) {
			this.y = y;
			this.x = x;
			this.isHorizontal = isHorizontal;
			this.count = count;
		}

		Pos(Pos init) {
			this.y = init.y;
			this.x = init.x;
			this.isHorizontal = init.isHorizontal;
			this.count = init.count;
		}

		void left() {
			this.x--;
		}

		void right() {
			this.x++;
		}

		void up() {
			this.y--;
		}

		void down() {
			this.y++;
		}
	}

	static int N;
	static char[][] grid = new char[51][];
	static int[][][] visited = new int[51][51][2];
	static Pos startPos;
	static Pos endPos;

	static int[][] dir = { { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	static boolean isOk(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < N) {
			if (grid[y][x] != '1') {
				return true;
			}
		}

		return false;
	}

	static void solve() {

		int curDir = startPos.isHorizontal ? 0 : 1;
		visited[startPos.y][startPos.x][curDir] = 0;
		ArrayDeque<Pos> dq = new ArrayDeque<>();

		dq.offer(new Pos(startPos.y, startPos.x, startPos.isHorizontal));

		while (dq.size() > 0) {
			Pos curPos = dq.poll();
			// System.out.println("cur:" + curPos.y + ", " + curPos.x + " : " +
			// curPos.isHorizontal);

			for (int i = 0; i < 5; i++) {
				Pos[] nextPos3 = new Pos[3];
				for (int j = 0; j < 3; ++j)
					nextPos3[j] = new Pos(curPos);

				if (curPos.isHorizontal) {
					// 수평
					nextPos3[0].left();
					nextPos3[2].right();
				} else {
					// 수직
					nextPos3[0].up();
					nextPos3[2].down();
				}

				// for (int j = 0; j < 3; j++) {
				// System.out
				// .println("next:" + nextPos3[j].y + ", " + nextPos3[j].x + " : " +
				// nextPos3[j].isHorizontal);
				// }
				// System.out.println("and then...");
				if (i == 0) {
					nextPos3[0].right();
					nextPos3[1].right();
					nextPos3[2].right();
				} else if (i == 1) {
					nextPos3[0].up();
					nextPos3[1].up();
					nextPos3[2].up();
				} else if (i == 2) {
					nextPos3[0].left();
					nextPos3[1].left();
					nextPos3[2].left();
				} else if (i == 3) {
					nextPos3[0].down();
					nextPos3[1].down();
					nextPos3[2].down();
				} else if (i == 4) {
					if (curPos.isHorizontal) {
						nextPos3[0].up();
						nextPos3[0].right();
						nextPos3[2].down();
						nextPos3[2].left();
					} else {
						nextPos3[0].right();
						nextPos3[0].down();
						nextPos3[2].left();
						nextPos3[2].up();
					}
					nextPos3[0].isHorizontal = nextPos3[1].isHorizontal = nextPos3[2].isHorizontal = !curPos.isHorizontal;
				}

				boolean checkIn = true;
				for (int j = 0; j < 3; j++) {
					if (!isOk(nextPos3[j].y, nextPos3[j].x)) {
						checkIn = false;
						break;
					}
				}

				if (i == 4) {
					for (int j = 0; j < 8; j++) {
						if (!isOk(nextPos3[1].y + dir[j][0], nextPos3[1].x + dir[j][1])) {
							checkIn = false;
							break;
						}
					}
				}

				int nextDir = nextPos3[1].isHorizontal ? 0 : 1;

				if (checkIn && visited[nextPos3[1].y][nextPos3[1].x][nextDir] > curPos.count + 1) {
					// for (int j = 0; j < 3; j++) {
					// System.out
					// .println("next:" + nextPos3[j].y + ", " + nextPos3[j].x + " : " +
					// nextPos3[j].isHorizontal);
					// }

					// System.out
					// .println("next:" + nextPos3[1].y + ", " + nextPos3[1].x + " : " +
					// nextPos3[1].isHorizontal + " : " + (curPos.count + 1));
					// System.out.println();

					visited[nextPos3[1].y][nextPos3[1].x][nextDir] = curPos.count + 1;
					nextPos3[1].count = curPos.count + 1;

					dq.offer(new Pos(nextPos3[1].y, nextPos3[1].x, nextPos3[1].isHorizontal, curPos.count + 1));
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {

		readline();
		N = nextInt();

		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();

			for (int j = 0; j < N; j++)
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
		}

		int b = 0, e = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 'B')
					if (++b == 2) {
						if (j > 0 && grid[i][j - 1] == 'B')
							startPos = new Pos(i, j, true);
						else
							startPos = new Pos(i, j, false);
					}
				if (grid[i][j] == 'E')
					if (++e == 2) {
						if (j > 0 && grid[i][j - 1] == 'E')
							endPos = new Pos(i, j, true);
						else
							endPos = new Pos(i, j, false);
					}
			}
		}
		solve();

		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// if (visited[i][j][0] != Integer.MAX_VALUE) {
		// System.out.print(String.format("%d ", visited[i][j][0]));
		// } else {
		// System.out.print(String.format("%d ", -1));
		// }
		// }
		// System.out.println();
		// }
		// System.out.println();
		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// if (visited[i][j][1] != Integer.MAX_VALUE) {
		// System.out.print(String.format("%d ", visited[i][j][1]));
		// } else {
		// System.out.print(String.format("%d ", -1));
		// }
		// }
		// System.out.println();
		// }

		int endDir = endPos.isHorizontal ? 0 : 1;

		int ans = visited[endPos.y][endPos.x][endDir];

		if (ans == Integer.MAX_VALUE) {
			ans = 0;
		}
		System.out.println(String.format("%d\n", ans));

		bwEnd();
	}

}