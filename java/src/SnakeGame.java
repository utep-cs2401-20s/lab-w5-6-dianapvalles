public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition = new int[2];;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Constructor that initializes an empty 1 x 1 gameboard
    public SnakeGame(){
        game = new boolean[1][1];
    }

    //Constructor that takes a 2-dimensional boolean array, and the x and y position of the snakes head
    public SnakeGame(boolean[][] game, int x, int y){
        for(int i = 0; i < this.game.length; i++){
            for(int j = 0; j < this.game[i].length; i++){
                this.game[i][j] = game[i][j];
            }
        }

        headPosition[0] = x;
        headPosition[1] = y;
    }

    //Returns the x and y position of the tail in the grid, and the length of the snake on the board. Increments the exhaustiveChecks counter with each (x',y') cell that is examined.
    public int[] findTailExhaustive(){
        resetCounters();
        int[] tail = new int[3];
        int length = 0;

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                if(game[i][j]){
                    length++;
                    if(headPosition[0] != i && headPosition[1] != j && neighbors(i,j) == 1){
                        tail[0] = i;
                        tail[1] = j;
                        tail[3] = length;
                        return tail;
                    }
                }
            }
        }

        return tail;
    }

    //It will find the tail of the snake by conducting a search starting at the head location and recursively following the snake's body
    //return 3 items: the x and y position of the tail in the grid, and the length of the snake on the board
    public int[] findTailRecursive(){
        resetCounters();
        int[] tail = new int[3];


        return tail;
    }

    /*
        neighbors method:
        computes the number of 'true' neighbors the corresponding cell in the board has
    */

    public int neighbors(int row, int col){
        int count = 0;

        if(col+1 < game.length && game[row][col+1]){ //looks for the one in the right
            count++;
        }

        if(row+1 < game.length && game[row+1][col]){ //looks for the one below
            count++;
        }

        if(col-1 >= 0 && col > 0 && game[row][col-1]){ //looks for the one on the left
            count++;
        }

        if(row-1 >= 0 && game[row-1][col]){ //looks for the one above
            count++;
        }

        if(row-1 >= 0 && col + 1 < game.length && game[row-1][col+1]){  //looks for the one in upper right diagonal
            count++;
        }

        if(row+1 < game.length && col+1 < game.length && game[row+1][col+1]){ //looks for the one in lower right diagonal
            count++;
        }

        if(row+1 < game.length && col-1 >= 0 && game[row+1][col-1]){ //looks for the one in lower left diagonal
            count++;
        }

        if(row-1 >= 0 && col-1 >=0 && game[row-1][col-1]){ //looks for the one in upper left diagonal
            count++;
        }
        return count;
    }

    private void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;
    }

    private static int getRecursiveChecks(){
        return recursiveChecks;
    }

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
}
