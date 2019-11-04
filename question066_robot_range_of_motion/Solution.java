package question066_robot_range_of_motion;

/**
 * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 运行时间：20ms。占用内存：9184k。
 */
public class Solution {
    private int[][] graph;

    private int result;

    private boolean[][] visited;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int movingCount(int threshold, int rows, int cols) {
        graph = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                graph[i][j] = getNumberSum(i) + getNumberSum(j);
            }
        }
        visited = new boolean[rows][cols];
        if (threshold >= 0) {
            dfs(0, 0, threshold);
        }
        return result;
    }

    private void dfs(int x, int y, int threshold) {
        visited[x][y] = true;
        result++;
        for (int i = 0; i < 4; i++) {
            int newX = directions[i][0] + x, newY = directions[i][1] + y;
            if (newX >= 0 && newX < graph.length && newY >= 0 && newY < graph[0].length
                    && graph[newX][newY] <= threshold && !visited[newX][newY]) {
                dfs(newX, newY, threshold);
            }
        }
    }

    private int getNumberSum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}