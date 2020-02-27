import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    boolean[][] board1 = {{false, false, true},
                          {false, true, true},
                          {false, false, false}};
    SnakeGame game1 = new SnakeGame(board1, 1,1);

    boolean[][] board2 = {{false, false, false},
                         {true, true, false},
                         {false, false, false}};
    SnakeGame game2 = new SnakeGame(board2, 1,1);

    /*
        * Test case 1:
        * findTailExhaustive()
        * game1
     */
    @Test
    public void testFindTailExhaustive1(){
        int[] expected = new int[]{0, 2, 3};
        int[] actual = game1.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindTailRecursive1(){
        int[] expected = new int[]{0, 2 ,3};

        assertArrayEquals(expected, game1.findTailRecursive());
    }

}
