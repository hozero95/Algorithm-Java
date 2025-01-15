package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon
 * 15649번: N과 M (1)
 * 난이도: 실버 3
 * 분류: 백트래킹
 *
 * @author hozero
 * @since 2025-01-15
 */
@SuppressWarnings("DuplicatedCode")
public class No15649 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static int M;
    static int[] selected, used;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        used = new int[N];
    }

    static void solve(int depth) {
        if (depth == M) {
            for (int j : selected) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if (used[i] == 1) {
                    continue;
                }
                selected[depth] = i + 1;
                used[i] = 1;
                solve(depth + 1);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve(0);
        System.out.println(sb.toString());
    }
}
