package question065;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 运行时间：24ms。占用内存：9336k。
 */
public class Solution {
    private char[][] graph;

    private boolean result;

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean[][] visited;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        graph = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                graph[i][j] = matrix[index++];
            }
        }
        if (str == null || str.length == 0) {
            return true;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == str[0]) {
                    visited = new boolean[rows][cols];
                    findPath(i, j, str, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return result;
    }

    //目前在点(x, y)，str[index] = graph[x][y]，寻找下一个点
    private void findPath(int x, int y, char[] str, int index) {
        if (index == str.length - 1) {
            result = true;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0], newY = y + directions[i][1];
            if (newX >= 0 && newX < graph.length && newY >= 0 && newY < graph[0].length &&
                    graph[newX][newY] == str[index + 1] && !visited[newX][newY]) {
                visited[newX][newY] = true;
                findPath(newX, newY, str, index + 1);
                visited[newX][newY] = false;
            }
        }
    }
}
