package baekjoon.backtracking.no_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon
 * 15652번: N과 M (4)
 * 난이도: 실버 3
 * 분류: 백트래킹
 *
 * @author hozero
 * @since 2025-01-15
 */
@SuppressWarnings("DuplicatedCode")
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static int M;
    static int[] selected;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
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
                selected[depth] = i;
                solve(depth + 1);
                selected[depth] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve(1);
        System.out.println(sb.toString());
    }
}
