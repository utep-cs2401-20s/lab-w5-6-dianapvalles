import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    boolean[][] board1 = {{false, true, false},
                          {false, true, false},
                          {false, true, false}};
    SnakeGame game1 = new SnakeGame(board1, 1,1);
    
    boolean[][] board2 = {{true, true, true},
                         {false, false, true},
                         {true, true, true}};
    SnakeGame game2 = new SnakeGame(board2, 0,0);

    boolean[][] board3 = {{false, false, false, false, false},
                          {false, false, true, true, true},
                          {false, false, true, false, true},
                          {true, true, true, false, true},
                          {false, false, false, false, true}};
    SnakeGame game3 = new SnakeGame(board3, 4,4);

    boolean[][] board4 = {{false, false},
                          {true, true}};
    SnakeGame game4 = new SnakeGame(board4, 1,0);

    boolean[][] board5 = {{false, false, false, false, false, false},
                          {false, false, false, false, false, false},
                          {false, false, false, false, false, false},
                          {false, false, true, false, false, false},
                          {false, false, false, false, false, false},
                          {false, false, false, false, false, false}};
    SnakeGame game5 = new SnakeGame(board5, 3,2);


    /*
        * findTailExhaustive()
        * Test case 1: it shows that the first cell it checks that is not equal to the head position will be considered as the tail
        * Therefore it should return (0,1,3) ---> TEST PASSED
        * game1
     */
    @Test
    public void testFindTailExhaustive1(){
        int[] expected = new int[]{0, 1, 3};
        int[] actual = game1.findTailExhaustive();

        assertEquals(2, game1.getExhaustiveChecks());
        assertArrayEquals(expected, actual);
    }

    /*
     * findTailExhaustive()
     * Test case 2: it shows if the 2D array is being traversed correctly by checking all of its cells to find the tail
     * Therefore it should return (2,0,7) ---> TEST PASSED
     * game2
     */
    @Test
    public void testFindTailExhaustive2(){
        int[] expected = new int[]{2, 0, 7};
        int[] actual = game2.findTailExhaustive();

        assertEquals(7, game2.getExhaustiveChecks());
        assertArrayEquals(expected, actual);
    }

    /*
     * findTailExhaustive()
     * Test case 3: it shows if the 2D array is being traversed correctly by checking all of its cells to find the tail, comparing the neighbors
     * Therefore it should return (3,0,10) ---> TEST PASSED
     * game3
     */
    @Test
    public void testFindTailExhaustive3(){
        int[] expected = new int[]{3, 0, 10};
        int[] actual = game3.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }

    /*
     * findTailExhaustive()
     * Test case 4: it shows that the program can handle a small board
     * Therefore it should return (1,1,2) ---> TEST PASSED
     * game4
     */
    @Test
    public void testFindTailExhaustive4(){
        int[] expected = new int[]{1,1,2};
        int[] actual = game4.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }

    /*
     * findTailExhaustive()
     * Test case 5: it tests what happens when the head is equal to the tail (no other true cells except for the head), then the array should keep the default values (0's)
     * Therefore it should return (0,0,1) ---> TEST PASSED
     * game5
     */
    @Test
    public void testFindTailExhaustive5(){
        int[] expected = new int[]{0,0,1};
        int[] actual = game5.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }

    /*
     * findTailRecursive()
     * Test case 1: it finds the tail by comparing the neighbors but since the two of them are true and only has 1 true neighbor
     * Therefore the program should decide which one is considered as the tail returning (0,1,3)  ---> TEST PASSED
     * game1
     */
    @Test
    public void testFindTailRecursive1(){
        int[] expected = new int[]{0, 1 ,3};
        int[] actual = game1.findTailRecursive();

        assertEquals(1, game1.getRecursiveChecks());
        assertArrayEquals(expected, actual);
    }

    /*
     * findTailRecursive()
     * Test case 2: it should follow the true cells after the head to return the tail
     * Therefore the program should decide which is the tail by comparing the position and neighbors (2,0,7)  ---> TEST PASSED
     *  game2
     */
    @Test
    public void testFindTailRecursive2(){
        int[] expected = new int[]{2, 0 ,7};
        int[] actual = game2.findTailRecursive();

        assertEquals(6, game2.getRecursiveChecks());
        assertArrayEquals(expected, actual);
    }

    /*
     * findTailRecursive()
     * Test case 3: it should follow the true cells after the head to return the tail with a "large" 2D array
     * Therefore the program should decide which is the tail by comparing the position and neighbors (3,0,10)  ---> TEST PASSED
     * game3
     */
    @Test
    public void testFindTailRecursive3(){
        int[] expected = new int[]{3, 0 ,10};
        int[] actual = game3.findTailRecursive();

        assertArrayEquals(expected, actual);
    }

    /*
     * findTailRecursive()
     * Test case 4: it should follow the true cells after the head to return the tail even with a small 2D array
     * Therefore the program should decide which is the tail by comparing the position and neighbors (1,1,2)  ---> TEST PASSED
     * game4
     */
    @Test
    public void testFindTailRecursive4(){
        int[] expected = new int[]{1,1,2};
        int[] actual = game4.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }

    /*
     * findTailRecursive()
     * Test case 4: it should return the default values of an array since the head is the only true cell
     * Therefore the program should return (0,0,1)  ---> TEST PASSED
     * game4
     */
    @Test
    public void testFindTailRecursive5(){
        int[] expected = new int[]{0,0,1};
        int[] actual = game5.findTailExhaustive();

        assertArrayEquals(expected, actual);
    }
}
