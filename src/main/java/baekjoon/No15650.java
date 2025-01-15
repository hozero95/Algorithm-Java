package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon
 * 15652번: N과 M (2)
 * 난이도: 실버 3
 * 분류: 백트래킹
 *
 * @author hozero
 * @since 2025-01-15
 */
@SuppressWarnings("DuplicatedCode")
public class No15650 {
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
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    static void solve(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int start = selected[depth - 1] == 0 ? 1 : selected[depth - 1];
            for (int i = start; i <= N; i++) {
                if (used[i] == 1) {
                    continue;
                }
                selected[depth] = i;
                used[i] = 1;
                solve(depth + 1);
                selected[depth] = 0;
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve(1);
        System.out.println(sb.toString());
    }
}
