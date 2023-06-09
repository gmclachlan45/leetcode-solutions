//2ms
//42.4MB
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        for(int i = m - 2; i >= 0; i--){
            health[i][n - 1] = Math.max(1, health[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        for(int j = n - 2; j >= 0; j--){
            health[m - 1][j] = Math.max(1, health[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int a = Math.max(1, health[i + 1][j] - dungeon[i][j]);
                int b = Math.max(1, health[i][j + 1] - dungeon[i][j]);

                health[i][j] = Math.min(a, b);
            }
        }

        return health[0][0];
    }
}
