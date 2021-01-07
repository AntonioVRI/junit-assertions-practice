import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

public class MyFirstTest {

    @Test
    public void testIfNamesAreEqual(){
        String name = "Jane";
        String input = "jane";

        assertEquals(name,input); //the test fails
    }

    @Test
    public void  testIfNumbersAreEqual(){
        int myNumber = 4;
        int userInput = 4;

        assertEquals(myNumber, userInput);
    }

    @Test
    public void testIfChangeIsCorrect() {
        Double price = 10.0;
        Double discount = 4.5;

        //assertEquals(expected, actual, delta);

        //10 - 4.5 = 5.5; with 0 margin of error, the only way to make the test pass is if the answer is EXACTLY the same
        assertEquals(5.5, price - discount, 0); //the test will pass

        //5.5; .5 delta means we can go from 5 - 6
        assertEquals(5.1, price - discount, 0.5); //the test will pass

        //5.5; .5 delta (we can go from 5 - 6 ); the test will pass b/c 4.9 is out of the 5 - 6 range
        assertNotEquals(4.9, price - discount, 0.5); //the test will pass
    }



    @Test
    public void testIfObjectsAreDifferent() {
        Object dog = new Object();
        Object sheep = new Object();
        Object clonedSheep = sheep;

        assertNotSame(sheep, dog); //will pass b/c they are NOT the same object

        assertSame(sheep, clonedSheep); //will pass b/c clonedSheep = sheep;
    }

    @Test
    public void testIfArrayEquals() {
        char[] expected = {'J','u','n','i','t'};
        char[] actual = "Junit".toCharArray();

        assertArrayEquals(expected, actual); //test will pass b/c actual is converting "Junit" to a character array
    }

    @Test
    public void testIfGreaterOrLesserThanWorks() {

        boolean learningTDD = true;

        assertTrue(learningTDD);
        assertTrue("5 is greater than 4", 5 > 4);
        assertFalse("5 is not greater than 6", 5 > 6);
    }

    @Test
    public void testIfInstanceIsNull() {
        Object phone = new Object();
        Object laptop = null;

        assertNull(null);
        assertNotNull(phone);
        assertNull(laptop);
    }

    private List<String> names;

    @Before
    public void setUp(){
        this.names = new ArrayList<>();
        this.names.add("Fer");
    }

    @Test
    public void testIfNamesIsInitialized(){
        assertNotNull(names);
    }

    @Test
    public void testIfANameCanBeAdded(){
        assertEquals(1, this.names.size());
        this.names.add("Zach");
        assertEquals(2, this.names.size());
        assertSame("Fer", this.names.get(0));
        assertSame("Zach", this.names.get(1));
    }
}