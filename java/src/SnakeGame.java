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
        this.game = new boolean[game.length][game.length];

        for(int i = 0; i < this.game.length; i++){
            for(int j = 0; j < this.game[i].length; j++){
                this.game[i][j] = game[i][j];
            }
        }

        headPosition[0] = x;
        headPosition[1] = y;
    }

    //Returns the x and y position of the tail in the grid, and the length of the snake on the board.
    // Increments the exhaustiveChecks counter with each (x',y') cell that is examined.
    public int[] findTailExhaustive(){
        resetCounters();
        int[] tail = new int[3];
        tail[2] = length();

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                if(game[i][j]){
                    if((headPosition[0] != i || headPosition[1] != j) && neighbors(i,j) == 1){
                        tail[0] = i;
                        tail[1] = j;
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
        int[] tail = findTailRecursive(headPosition, headPosition);

        int[] tail2 = new int[3];
        tail2[0] = tail[0];
        tail2[1] = tail[1];
        tail2[2] = length();

        return tail2;
    }

    //Starts at a position other than the head position (used for the recursive calls),
    //Also takes in the position of the previous body position (to exclude it from deciding the next position).
    //Increments the recursiveChecks counter with each (x',y') cell that is examined.
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] finalPosition = new int[2];
        finalPosition[0] = currentPosition[0];
        finalPosition[1] = currentPosition[1];

        if((finalPosition[0] != headPosition[0] && finalPosition[1] == headPosition[1]) || (finalPosition[0] == headPosition[0] && finalPosition[1] != headPosition[1]) || (finalPosition[0] != headPosition[0] && finalPosition[1] != headPosition[1])){
            if(neighbors(finalPosition[0], finalPosition[1]) == 1) {
                return currentPosition;
            }
        }

        //checks up
        if(currentPosition[0] - 1 >= 0) {
            if (currentPosition[0] - 1 != previousPosition[0]) {
                if (game[currentPosition[0] - 1][currentPosition[1]]) {
                    finalPosition [0] = currentPosition[0] - 1;
                    finalPosition [1] = currentPosition[1];
                    recursiveChecks++;
                    return findTailRecursive(finalPosition, currentPosition);
                }
            }
        }

        //checks down
        if(currentPosition[0] + 1 < game.length) {
            if (currentPosition[0] + 1 != previousPosition[0]) {
                if (game[currentPosition[0] + 1][currentPosition[1]]) {
                    finalPosition [0] = currentPosition[0] + 1;
                    finalPosition [1] = currentPosition[1];
                    recursiveChecks++;
                    return findTailRecursive(finalPosition, currentPosition);
                }
            }
        }



        //checks right
        if(currentPosition[1] + 1 < game.length) {
            if (currentPosition[1] + 1 != previousPosition[1]) {
                if (game[currentPosition[0]][currentPosition[1] + 1]) {
                    finalPosition [0] = currentPosition[0];
                    finalPosition [1] = currentPosition[1] + 1;
                    recursiveChecks++;
                    return findTailRecursive(finalPosition, currentPosition);
                }
            }
        }

        //checks left
        if(currentPosition[1] - 1 >= 0) {
            if (currentPosition[1] - 1 != previousPosition[1]) {
                if (game[currentPosition[0]][currentPosition[1] - 1]) {
                    finalPosition [0] = currentPosition[0];
                    finalPosition [1] = currentPosition[1] - 1;
                    recursiveChecks++;
                    return findTailRecursive(finalPosition, currentPosition);
                }
            }
        }
        else{
            recursiveChecks++;
        }

        //default (invalid) values
        return(new int[]{0, 0, 1});
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

        if(col-1 >= 0 && game[row][col-1]){ //looks for the one on the left
            count++;
        }

        if(row-1 >= 0 && game[row-1][col]){ //looks for the one above
            count++;
        }

        return count;
    }

    public int length(){
        int count = 0;

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                if(game[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    private void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;
    }

    public static int getRecursiveChecks(){
        return recursiveChecks;
    }

    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
}
