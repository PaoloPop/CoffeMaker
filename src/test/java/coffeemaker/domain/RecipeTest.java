package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.RecipeException;

class RecipeTest {
    @Test
    public void testSetName_blankName() {
        Recipe recipe = new Recipe();
        recipe.setName("  ");
        assertNotEquals("  ", recipe.getName(), "Name should not be blank or empty.");
    }

    @Test
    public void testSetPrice_negativeValue() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setPrice("-10"),
                "Price should throw exception when negative value is set.");
    }

    @Test
    public void testSetPrice_nonNumeric() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setPrice("abc"),
                "Setting a non-numeric price should throw a RecipeException.");
    }

    @Test
    public void testHashCodeConsistency() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setName("Latte");
        recipe2.setName("Latte");

        assertEquals(recipe1.hashCode(), recipe2.hashCode(),
                "HashCode should be consistent when names are equal.");
    }

    @Test
    public void testSetAmtCoffee_zeroValueShouldFail() {
        Recipe recipe = new Recipe();
        RecipeException thrown = assertThrows(
                RecipeException.class,
                () -> recipe.setAmtCoffee("0"),
                "Expected setAmtCoffee to throw, but it didn't");
        assertEquals("Units of coffee must be a positive integer", thrown.getMessage(),
                "The exception message should indicate that the value must be positive.");
    }

}