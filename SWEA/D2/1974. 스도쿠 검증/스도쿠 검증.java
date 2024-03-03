import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int[][] sudoku = new int[9][9];

            int result = -1;
            // 스도쿠 세팅
            for (int r = 0; r < 9; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 9; c++) {
                    sudoku[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            // sudoku가 정상일지 아닐지 1과 0으로 판단하기 때문에 boolean으로 판단
            boolean isValid = true;

            // 행과 열 검사
            for (int i = 0; i < 9 && isValid; i++) { // 조건에서 i는 9보다 작고 true 일 때만 반복하고 싶을 때는 이렇게 && isValid 로 판단
                int[] rowCheck = new int[9];
                int[] colCheck = new int[9];

                for (int j = 0; j < 9; j++) {
                    rowCheck[j] = sudoku[i][j];
                    colCheck[j] = sudoku[j][i];
                }

                Arrays.sort(rowCheck);
                Arrays.sort(colCheck);

                for (int k = 0; k < 9; k++) {
                    if (rowCheck[k] != k + 1 || colCheck[k] != k + 1) {
                        isValid = false;
                        break;
                    }
                }
            }

            // 3x3 서브그리드 검사
            for (int row = 0; row < 9 && isValid; row += 3) {
                for (int col = 0; col < 9 && isValid; col += 3) {
                    int[] subgridCheck = new int[9];
                    int index = 0;

                    for (int r = row; r < row + 3; r++) {
                        for (int c = col; c < col + 3; c++) {
                            subgridCheck[index++] = sudoku[r][c];
                        }
                    }

                    Arrays.sort(subgridCheck);
                    for (int k = 0; k < 9; k++) {
                        if (subgridCheck[k] != k + 1) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            result = isValid ? 1 : 0;
            System.out.printf("#%d %d\n", tc, result);

        }

    }
}