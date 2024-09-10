package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    public static Recipe recipeHelperConstructor(String name, String price, String amtCoffee, String amtMilk, String amtSugar, String amtChocolate){
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setPrice(price);
        recipe.setAmtCoffee(amtCoffee);
        recipe.setAmtMilk(amtMilk);
        recipe.setAmtSugar(amtSugar);
        recipe.setAmtChocolate(amtChocolate);

        return recipe;
    }

    ///////////////////////////////////////
    ///////////// getCoffee() /////////////
    ///////////////////////////////////////

    @Test
    public void testGetCoffee() {
        // Set up
        int expected = 15;

        // Invoke
        int actual = Inv.getCoffee();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// setCoffee() /////////////
    ///////////////////////////////////////

    @Test
    public void testSetCoffeeAboveZero() {
        // Set up
        int expected = 7;
        int newCoffeeAmt = 7;

        // Invoke
        Inv.setCoffee(newCoffeeAmt);
        int actual = Inv.getCoffee();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetCoffeeZero() {
        // Set up
        int expected = 0;
        int newCoffeeAmt = 0;

        // Invoke
        Inv.setCoffee(newCoffeeAmt);
        int actual = Inv.getCoffee();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetCoffeeBelowZero() {
        // Set up
        int expected = 15;
        int newCoffeeAmt = -2;

        // Invoke
        Inv.setCoffee(newCoffeeAmt);
        int actual = Inv.getCoffee();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// addCoffee() /////////////
    ///////////////////////////////////////

    @Test
    public void testAddingCoffeeAboveZero() {
        // Set up
        int expected = 17;
        String coffeeToAdd = "2";

        // Invoke
        Inv.addCoffee(coffeeToAdd);
        int actual = Inv.getCoffee();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingCoffeeZero() {
        // Set up
        int expected = 15;
        String coffeeToAdd = "0";

        // Invoke
        Inv.addCoffee(coffeeToAdd);
        int actual = Inv.getCoffee();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingCoffeeBelowZero() {
        // Set up
        String coffeeToAdd = "-2";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addCoffee(coffeeToAdd));
    }

    @Test
    public void testAddingCoffeeWrongType() {
        // Set up
        String valueToAdd = "test";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addCoffee(valueToAdd));
    }

    ///////////////////////////////////////
    ///////////// getMilk() ///////////////
    ///////////////////////////////////////

    @Test
    public void testGetMilk() {
        // Set up
        int expected = 15;

        // Invoke
        int actual = Inv.getMilk();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// setMilk() ///////////////
    ///////////////////////////////////////

    @Test
    public void testSetMilkAboveZero() {
        // Set up
        int expected = 7;
        int newMilkAmt = 7;

        // Invoke
        Inv.setMilk(newMilkAmt);
        int actual = Inv.getMilk();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetMilkZero() {
        // Set up
        int expected = 0;
        int newMilkAmt = 0;

        // Invoke
        Inv.setMilk(newMilkAmt);
        int actual = Inv.getMilk();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetMilkBelowZero() {
        // Set up
        int expected = 15;
        int newMilkAmt = -2;

        // Invoke
        Inv.setMilk(newMilkAmt);
        int actual = Inv.getMilk();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// addMilk() ///////////////
    ///////////////////////////////////////

    @Test
    public void testAddingMilkAboveZero() {
        // Set up
        int expected = 17;
        String coffeeToAdd = "2";

        // Invoke
        Inv.addMilk(coffeeToAdd);
        int actual = Inv.getMilk();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingMilkZero() {
        // Set up
        int expected = 15;
        String coffeeToAdd = "0";

        // Invoke
        Inv.addMilk(coffeeToAdd);
        int actual = Inv.getMilk();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingMilkBelowZero() {
        // Set up
        String coffeeToAdd = "-2";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addMilk(coffeeToAdd));
    }

    @Test
    public void testAddingMilkWrongType() {
        // Set up
        String valueToAdd = "test";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addMilk(valueToAdd));
    }

    ///////////////////////////////////////
    ///////////// getSugar() //////////////
    ///////////////////////////////////////

    @Test
    public void testGetSugar() {
        // Set up
        int expected = 15;

        // Invoke
        int actual = Inv.getSugar();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// setSugar() //////////////
    ///////////////////////////////////////

    @Test
    public void testSetSugarAboveZero() {
        // Set up
        int expected = 7;
        int newSugarAmt = 7;

        // Invoke
        Inv.setSugar(newSugarAmt);
        int actual = Inv.getSugar();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetSugarZero() {
        // Set up
        int expected = 0;
        int newSugarAmt = 0;

        // Invoke
        Inv.setSugar(newSugarAmt);
        int actual = Inv.getSugar();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetSugarBelowZero() {
        // Set up
        int expected = 15;
        int newSugarAmt = -2;

        // Invoke
        Inv.setSugar(newSugarAmt);
        int actual = Inv.getSugar();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// addSugar() //////////////
    ///////////////////////////////////////

    @Test
    public void testAddingSugarAboveZero() {
        // Set up
        int expected = 17;
        String coffeeToAdd = "2";

        // Invoke
        Inv.addSugar(coffeeToAdd);
        int actual = Inv.getSugar();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingSugarZero() {
        // Set up
        int expected = 15;
        String coffeeToAdd = "0";

        // Invoke
        Inv.addSugar(coffeeToAdd);
        int actual = Inv.getSugar();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingSugarBelowZero() {
        // Set up
        String coffeeToAdd = "-2";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addSugar(coffeeToAdd));
    }

    @Test
    public void testAddingSugarWrongType() {
        // Set up
        String valueToAdd = "test";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addSugar(valueToAdd));
    }

    ///////////////////////////////////////
    ///////////// getChocolate() //////////
    ///////////////////////////////////////

    @Test
    public void testGetChocolate() {
        // Set up
        int expected = 15;

        // Invoke
        int actual = Inv.getChocolate();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// setChocolate() //////////
    ///////////////////////////////////////

    @Test
    public void testSetChocolateAboveZero() {
        // Set up
        int expected = 7;
        int newChocolateAmt = 7;

        // Invoke
        Inv.setChocolate(newChocolateAmt);
        int actual = Inv.getChocolate();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetChocolateZero() {
        // Set up
        int expected = 0;
        int newChocolateAmt = 0;

        // Invoke
        Inv.setChocolate(newChocolateAmt);
        int actual = Inv.getChocolate();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testSetChocolateBelowZero() {
        // Set up
        int expected = 15;
        int newChocolateAmt = -2;

        // Invoke
        Inv.setChocolate(newChocolateAmt);
        int actual = Inv.getChocolate();

        // Analysis
        assertEquals(expected,actual);
    }

    ///////////////////////////////////////
    ///////////// addChocolate() //////////
    ///////////////////////////////////////

    @Test
    public void testAddingChocolateAboveZero() {
        // Set up
        int expected = 17;
        String coffeeToAdd = "2";

        // Invoke
        Inv.addChocolate(coffeeToAdd);
        int actual = Inv.getChocolate();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingChocolateZero() {
        // Set up
        int expected = 15;
        String coffeeToAdd = "0";

        // Invoke
        Inv.addChocolate(coffeeToAdd);
        int actual = Inv.getChocolate();

        // Analysis
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingChocolateBelowZero() {
        // Set up
        String coffeeToAdd = "-2";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addChocolate(coffeeToAdd));
    }

    @Test
    public void testAddingChocolateWrongType() {
        // Set up
        String valueToAdd = "test";

        // Analysis
        assertThrows(InventoryException.class, () -> Inv.addChocolate(valueToAdd));
    }


    ///////////////////////////////////////
    ///////////// enoughIngredients() /////
    ///////////////////////////////////////

    @Test
    public void testEnoughIngredientsTrue() {
        // Set up
        String name = "test";
        String price = "7";
        String amtCoffee = "7";
        String amtMilk = "7";
        String amtSugar = "7";
        String amtChocolate = "7";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        boolean shouldBeTrue = Inv.enoughIngredients(recipe);


        // Analysis
        assertTrue(shouldBeTrue);
    }

    @Test
    public void testEnoughIngredientsFalseCoffee() {
        // Set up
        String name = "test";
        String price = "7";
        String amtCoffee = "16";
        String amtMilk = "7";
        String amtSugar = "7";
        String amtChocolate = "7";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        boolean shouldBeFalse = Inv.enoughIngredients(recipe);


        // Analysis
        assertFalse(shouldBeFalse);
    }

    @Test
    public void testEnoughIngredientsFalseMilk() {
        // Set up
        String name = "test";
        String price = "7";
        String amtCoffee = "7";
        String amtMilk = "16";
        String amtSugar = "7";
        String amtChocolate = "7";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        boolean shouldBeFalse = Inv.enoughIngredients(recipe);


        // Analysis
        assertFalse(shouldBeFalse);
    }

    @Test
    public void testEnoughIngredientsFalseSugar() {
        // Set up
        String name = "test";
        String price = "7";
        String amtCoffee = "7";
        String amtMilk = "7";
        String amtSugar = "16";
        String amtChocolate = "7";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        boolean shouldBeFalse = Inv.enoughIngredients(recipe);


        // Analysis
        assertFalse(shouldBeFalse);
    }

    @Test
    public void testEnoughIngredientsFalseChocolate() {
        // Set up
        String name = "test";
        String price = "7";
        String amtCoffee = "7";
        String amtMilk = "7";
        String amtSugar = "7";
        String amtChocolate = "16";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        boolean shouldBeFalse = Inv.enoughIngredients(recipe);


        // Analysis
        assertFalse(shouldBeFalse);
    }


    ///////////////////////////////////////
    ///////////// useIngredients() ////////
    ///////////////////////////////////////
    @Test
    public void testUseIngredients(){
        // Set Up
        String name = "test";
        String price = "7";
        String amtCoffee = "7";
        String amtMilk = "7";
        String amtSugar = "7";
        String amtChocolate = "7";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        Inv.useIngredients(recipe);

        // Analysis
        assertAll(
                () -> {assertEquals(Inv.getCoffee(), 8);},
                () -> {assertEquals(Inv.getMilk(), 8);},
                () -> {assertEquals(Inv.getSugar(), 8);},
                () -> {assertEquals(Inv.getChocolate(), 8);}
        );
    }

    @Test
    public void testUseIngredientsFalse(){
        //Set Up
        String name = "test";
        String price = "7";
        String amtCoffee = "16";
        String amtMilk = "7";
        String amtSugar = "17";
        String amtChocolate = "7";

        Recipe recipe = recipeHelperConstructor(name, price, amtCoffee, amtMilk, amtSugar, amtChocolate);


        // Invoke
        Inv.useIngredients(recipe);
        boolean shouldBeFalse = Inv.enoughIngredients(recipe);

        // Analysis
        assertFalse(shouldBeFalse);
    }

    ///////////////////////////////////////
    ////////////// toString() /////////////
    ///////////////////////////////////////
    @Test
    public void testToString(){
        // Set Up
        String expected = "Coffee: 15\n" +
                "Milk: 15\n" +
                "Sugar: 15\n" +
                "Chocolate: 15\n";

        // Invoke
        String actual = Inv.toString();

        // Analysis
        assertEquals(expected, actual);
    }
}