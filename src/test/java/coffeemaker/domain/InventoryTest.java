package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.InventoryException;

class InventoryTest {

    /**
     * Component under Test.
     */
    private Inventory Inv;

    @BeforeEach
    public void setUp() {
        // add setup here
        Inv = new Inventory();
    }

    @AfterEach
    public void tearDown() {
        // add tear down here
        Inv = null;
    }

    @Test
    public void testGetCoffee() {
        // Set up
        int expected = 15;

        //
        int actual = Inv.getCoffee();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testSetCoffeeAboveZero() {
        // Set up
        int expected = 7;

        Inv.setCoffee(7);
        int actual = Inv.getCoffee();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testSetCoffeeZero() {
        // Set up
        int expected = 0;

        Inv.setCoffee(0);
        int actual = Inv.getCoffee();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testSetCoffeeBelowZero() {
        // Set up
        int expected = 15;

        Inv.setCoffee(-2);
        int actual = Inv.getCoffee();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingCoffeeAboveZero() {
        // Set up
        int expected = 17;

        Inv.addCoffee("2");
        int actual = Inv.getCoffee();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingCoffeeZero() {
        // Set up
        int expected = 15;

        Inv.addCoffee("0");
        int actual = Inv.getCoffee();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingCoffeeBelowZero() {
        // Set up
        String valueToAdd = "-2";

        // Assert
        assertThrows(InventoryException.class, () -> Inv.addCoffee(valueToAdd));
    }

    @Test
    public void testAddingCoffeeWrongType() {
        // Set up
        String valueToAdd = "test";

        // Assert
        assertThrows(InventoryException.class, () -> Inv.addCoffee(valueToAdd));
    }
}