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
    public void testSetAmtCoffee_zeroValueShouldFail() {
        Recipe recipe = new Recipe();
        RecipeException thrown = assertThrows(
                RecipeException.class,
                () -> recipe.setAmtCoffee("0"),
                "Expected setAmtCoffee to throw, but it didn't");
        assertEquals("Units of coffee must be a positive integer", thrown.getMessage(),
                "The exception message should indicate that the value must be positive.");
    }

    @Test
    public void testSetName_validName() {
        Recipe recipe = new Recipe();
        recipe.setName("Espresso");
        assertEquals("Espresso", recipe.getName(), "Name should be set correctly.");
    }

    @Test
    public void testSetName_nullName() {
        Recipe recipe = new Recipe();
        recipe.setName(null);
        assertEquals("", recipe.getName(), "Name should remain an empty string when set to null.");
    }

    @Test
    public void testSetPrice_validValue() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setPrice("100");
        assertEquals(100, recipe.getPrice(), "Price should be set correctly.");
    }

    @Test
    public void testSetAmtCoffee_validValue() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("3");
        assertEquals(3, recipe.getAmtCoffee(), "Amount of coffee should be set correctly.");
    }

    @Test
    public void testSetAmtCoffee_negativeValue() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-1"),
                "Negative coffee amount should throw a RecipeException.");
    }

    @Test
    public void testSetAmtMilk_validValue() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtMilk("2");
        assertEquals(2, recipe.getAmtMilk(), "Amount of milk should be set correctly.");
    }

    @Test
    public void testSetAmtMilk_negativeValue() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtMilk("-1"),
                "Negative milk amount should throw a RecipeException.");
    }

    @Test
    public void testSetAmtMilk_nonNumeric() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtMilk("abc"),
                "Non-numeric milk amount should throw a RecipeException.");
    }

    @Test
    public void testSetAmtSugar_validValue() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtSugar("4");
        assertEquals(4, recipe.getAmtSugar(), "Amount of sugar should be set correctly.");
    }

    @Test
    public void testSetAmtSugar_negativeValue() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-1"),
                "Negative sugar amount should throw a RecipeException.");
    }

    @Test
    public void testSetAmtSugar_nonNumeric() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtSugar("xyz"),
                "Non-numeric sugar amount should throw a RecipeException.");
    }

    @Test
    public void testSetAmtChocolate_validValue() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtChocolate("5");
        assertEquals(5, recipe.getAmtChocolate(), "Amount of chocolate should be set correctly.");
    }

    @Test
    public void testSetAmtChocolate_negativeValue() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("-1"),
                "Negative chocolate amount should throw a RecipeException.");
    }

    @Test
    public void testSetAmtChocolate_nonNumeric() {
        Recipe recipe = new Recipe();
        assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("abc"),
                "Non-numeric chocolate amount should throw a RecipeException.");
    }

    @Test
    public void testSetPrice_zeroValue() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setPrice("0");
        assertEquals(0, recipe.getPrice(), "Price should be set to 0.");
    }

    @Test
    public void testToString() {
        Recipe recipe = new Recipe();
        recipe.setName("Cappuccino");
        assertEquals("Recipe{Cappuccino}", recipe.toString(), "toString should return 'Recipe{Cappuccino}'.");
    }

    @Test
    public void testSetAmtCoffee_validAmount() throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("3");
        assertEquals(3, recipe.getAmtCoffee(), "Amount of coffee should be set to 3.");
    }

    @Test
    public void testSetAmtCoffee_nonNumeric() {
        Recipe recipe = new Recipe();
        RecipeException thrown = assertThrows(
                RecipeException.class,
                () -> recipe.setAmtCoffee("abc"),
                "Expected setAmtCoffee to throw, but it didn't");
        assertEquals("Units of coffee must be a positive integer", thrown.getMessage());
    }

    @Test
    public void testSetAmtCoffee_negativeAmount() {
        Recipe recipe = new Recipe();
        RecipeException thrown = assertThrows(
                RecipeException.class,
                () -> recipe.setAmtCoffee("-1"),
                "Expected setAmtCoffee to throw, but it didn't");
        assertEquals("Units of coffee must be a positive integer", thrown.getMessage());
    }

    @Test
    public void testSetAmtCoffee_zeroAmount() {
        Recipe recipe = new Recipe();
        RecipeException thrown = assertThrows(
                RecipeException.class,
                () -> recipe.setAmtCoffee("0"),
                "Expected setAmtCoffee to throw, but it didn't");
        assertEquals("Units of coffee must be a positive integer", thrown.getMessage());
    }


    /*
     * Test equals method
     */

    @Test
    public void testEquals_sameObject() {
        Recipe recipe = new Recipe();
        assertTrue(recipe.equals(recipe), "An object should equal itself.");
    }

    @Test
    public void testEquals_differentObjectSameName() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setName("Latte");
        recipe2.setName("Latte");
        assertTrue(recipe1.equals(recipe2), "Recipes with the same name should be equal.");
    }

    @Test
    public void testEquals_differentObjectDifferentName() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setName("Latte");
        recipe2.setName("Espresso");
        assertFalse(recipe1.equals(recipe2), "Recipes with different names should not be equal.");
    }

    @Test
    public void testEquals_identicalObjects() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Latte");

        Recipe recipe2 = new Recipe();
        recipe2.setName("Latte");

        assertTrue(recipe1.equals(recipe2), "Recipes with the same name should be equal.");
    }

    // Test equals when comparing to null
    @Test
    public void testEquals_nullObject() {
        Recipe recipe = new Recipe();
        assertFalse(recipe.equals(null), "Recipe should not be equal to null.");
    }

    // Test equals when comparing to different class
    @Test
    public void testEquals_differentClass() {
        Recipe recipe = new Recipe();
        assertFalse(recipe.equals("Some String"), "Recipe should not be equal to an object of a different class.");
    }

    // Test equals when names are both null
    @Test
    public void testEquals_bothNamesNull() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setName(null);
        recipe2.setName(null);
        assertTrue(recipe1.equals(recipe2), "Recipes with both names null should be equal.");
    }

    // Test equals when names are the same
    @Test
    public void testEquals_sameName() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Latte");

        Recipe recipe2 = new Recipe();
        recipe2.setName("Latte");

        assertTrue(recipe1.equals(recipe2), "Recipes with the same name should be equal.");
    }

    // Test equals when names are different
    @Test
    public void testEquals_differentName() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Latte");

        Recipe recipe2 = new Recipe();
        recipe2.setName("Mocha");

        assertFalse(recipe1.equals(recipe2), "Recipes with different names should not be equal.");
    }

    // Test equals when one name is non-null and the other is null (reverse
    // scenario)
    @Test
    public void testEquals_nonNullNameAndNullName() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Latte");

        Recipe recipe2 = new Recipe();
        recipe2.setName(null);

        assertFalse(recipe1.equals(recipe2), "Recipe with non-null name should not equal recipe with null name.");
    }

    @Test
    public void testHashCode_differentName() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setName("Latte");
        recipe2.setName("Espresso");
        assertNotEquals(recipe1.hashCode(), recipe2.hashCode(),
                "Recipes with different names should have different hash codes.");
    }

    @Test
    public void testHashCode_nullName() {
        Recipe recipe = new Recipe();
        recipe.setName(null); // Ensure name is null
        assertEquals(31, recipe.hashCode(), "Expected hashCode to be 31 when name is null.");
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

    // Test hashCode with non-null name
    @Test
    public void testHashCode_nonNullName() {
        Recipe recipe = new Recipe();
        recipe.setName("Latte");
        int expectedHashCode = 31 * 1 + "Latte".hashCode();
        assertEquals(expectedHashCode, recipe.hashCode(), "HashCode should match expected value.");
    }

    @Test
    public void testHashCode_blankName() {
        Recipe recipe = new Recipe();
        recipe.setName("   "); // Name is blank but not null
        int expectedHashCode = 31;
        assertEquals(expectedHashCode, recipe.hashCode(), "Expected hashCode to match for blank name.");
    }

}