package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    void locationClassTest() {
        Location locationTest = new Location(1, 1);
    }

    @Test
    void getRow() {
        Location locationTest = new Location(2, 2);
        Assertions.assertEquals(2, locationTest.getRow());
    }

    @Test
    void getColumn() {
        Location locationTest = new Location(2, 2);
        Assertions.assertEquals(2, locationTest.getColumn());
    }
    
    @Test
    void negativeNumberInRow()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(-1, 3));
    }

    @Test
    void negativeNumberInColumn()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(3, -1));
    }
    @Test
    void negativeNumberInRowAndInColumn()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(-1, -1));
    }

    //Mutation Testing to kill Mutants
    @Test
    void testValidRangeBoundary()
    {
        Location locationTest = new Location(0, 0);
        Assertions.assertEquals(0, locationTest.getRow());
        Assertions.assertEquals(0, locationTest.getColumn());

        locationTest = new Location(2, 0);
        Assertions.assertEquals(2, locationTest.getRow());
        Assertions.assertEquals(0, locationTest.getColumn());

        locationTest = new Location(0, 2);
        Assertions.assertEquals(0, locationTest.getRow());
        Assertions.assertEquals(2, locationTest.getColumn());

        locationTest = new Location(2, 2);
        Assertions.assertEquals(2, locationTest.getRow());
        Assertions.assertEquals(2, locationTest.getColumn());
    }

    //Mutation Testing to kill Mutants
    @Test
    void testInValidRangeBoundary()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(Integer.MIN_VALUE, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(-1, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(3, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(Integer.MAX_VALUE, 2));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(2,Integer.MIN_VALUE));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(2, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(2, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Location(2,Integer.MAX_VALUE));
    }
}