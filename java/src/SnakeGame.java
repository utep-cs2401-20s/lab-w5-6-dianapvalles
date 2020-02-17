public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
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

    public int[] findTailExhaustive(){
        int[] findTailExhaustive = new int[3];
         exhaustiveChecks = 0;

        return findTailExhaustive;
    }

    public int[] findTailRecursive(){
        int[] findTailRecursive = new int[3];
         recursiveChecks = 0;
        return findTailRecursive;
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
