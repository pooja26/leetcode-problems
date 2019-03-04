package Graph;

public class NumIslands {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {

        n = grid.length;
        m= grid[0].length;
        int count=0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(grid[i][j] == '1') {
                    dfsMarking(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfsMarking(char grid[][],int i,int j) {
        if(i>=n || j>=m || i<0 || j<0 || grid[i][j]=='0') return;
        grid[i][j]='0';
        dfsMarking(grid,i-1,j);
        dfsMarking(grid,i+1,j);
        dfsMarking(grid,i,j-1);
        dfsMarking(grid,i,j+1);

    }

    public static void main(String[] args) {
        NumIslands n = new NumIslands();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(n.numIslands(grid));
    }
}
