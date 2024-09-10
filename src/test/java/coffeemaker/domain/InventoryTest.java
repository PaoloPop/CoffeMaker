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
    @DisplayName("Test getting the amount of coffee.")
    public void testGetCoffee() {
        // Set up
        int expected = 15;

        //
        int actual = Inv.getCoffee();

        // Assert
        assertTrue(expected == actual, "Coffee sould start at 15 by default.");
    }

    @Test
    @DisplayName("Test setting the amount of coffee with a value above zero.")
    public void testSetCoffeeAboveZero() {
        // Set up
        int expected = 7;

        Inv.setCoffee(7);
        int actual = Inv.getCoffee();

        // Assert
        assertTrue(expected == actual, "Coffee sould equal the set amount.");
    }

    @Test
    @DisplayName("Test setting the amount of coffee with a zero value.")
    public void testSetCoffeeZero() {
        // Set up
        int expected = 0;

        Inv.setCoffee(0);
        int actual = Inv.getCoffee();

        // Assert
        assertTrue(expected == actual, "Coffee sould equal the set amount.");
    }

    @Test
    @DisplayName("Test setting the amount of coffee with a value belowzero.")
    public void testSetCoffeeBelowZero() {
        // Set up
        int expected = 15;

        Inv.setCoffee(-2);
        int actual = Inv.getCoffee();

        // Assert
        assertTrue(expected == actual, "Coffee sould equal the set amount.");
    }

    @Test
    @DisplayName("Test adding coffee to the inventory.")
    public void testAddingCoffeeAboveZero() {
        // Set up
        int expected = 17;

        Inv.addCoffee("2");
        int actual = Inv.getCoffee();

        // Assert
        assertTrue(expected == actual, "Coffee sould equal the set amount.");
    }

    @Test
    @DisplayName("Test adding 0 coffee to the inventory.")
    public void testAddingCoffeeZero() {
        // Set up
        int expected = 15;

        Inv.addCoffee("0");
        int actual = Inv.getCoffee();

        // Assert
        assertTrue(expected == actual, "Coffee sould equal the set amount.");
    }

    @Test
    @DisplayName("Test adding negative coffee to the inventory.")
    public void testAddingCoffeeBelowZero() {
        // Set up
        String valueToAdd = "-2";

        // Assert
        assertThrows(InventoryException.class, () -> Inv.addCoffee(valueToAdd));
    }
}