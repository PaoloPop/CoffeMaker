package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeBookTest {
    @Test
    public void testNumberOfRecipes(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe[] recipes=recipeBook.getRecipes();

        // Expected
        int expectedLength=4;

        // Actual
        int actualLength=recipes.length;
        // Result
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testAddRecipeSuccess(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe=new Recipe();
        recipe.setName("test recipe");

        // Actual
        boolean actualReturn=recipeBook.addRecipe(recipe);

        // Expected
        boolean expectedReturn=true;

        // for(int i=0;i<recipeBook.getRecipes().length;i++){
        //     System.out.println(recipeBook.getRecipes()[i]);
        // }

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testAddRecipeEndOfRecipeBook(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe1=new Recipe();
        recipe1.setName("1");
        recipeBook.addRecipe(recipe1);
        
        Recipe recipe2=new Recipe();
        recipe2.setName("2");
        recipeBook.addRecipe(recipe2);
        
        Recipe recipe3=new Recipe();
        recipe3.setName("3");
        recipeBook.addRecipe(recipe3);

        Recipe recipe4=new Recipe();
        recipe4.setName("4");

        // Actual
        boolean actualReturn=recipeBook.addRecipe(recipe4);

        // Expected
        boolean expectedReturn=true;

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testAddRecipeDuplicate(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe=new Recipe();
        recipeBook.addRecipe(recipe);

        // Actual
        boolean actualReturn=recipeBook.addRecipe(recipe);
        
        // Expected
        boolean expectedReturn=false;

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testAddRecipeFullBook(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe=new Recipe();
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe);
        recipeBook.addRecipe(recipe);

        // Actual
        boolean actualReturn=recipeBook.addRecipe(recipe);
        
        // Expected
        boolean expectedReturn=false;

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testDeleteRecipeSuccess(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe=new Recipe();
        recipe.setName("Test");
        recipeBook.addRecipe(recipe);

        // Actual
        String actualReturn=recipeBook.deleteRecipe(0);
        
        // Expected
        String expectedReturn="Test";

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testDeleteRecipeNull(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe=new Recipe();
        recipe.setName("Test");
        recipeBook.addRecipe(recipe);

        // Actual
        String actualReturn=recipeBook.deleteRecipe(1);        

        // Result
        assertNull(actualReturn);
    }

    @Test
    public void testDeleteRecipeEndOfRecipeBook(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe1=new Recipe();
        recipe1.setName("Test1");
        recipeBook.addRecipe(recipe1);

        Recipe recipe2=new Recipe();
        recipe2.setName("Test2");
        recipeBook.addRecipe(recipe2);

        Recipe recipe3=new Recipe();
        recipe3.setName("Test3");
        recipeBook.addRecipe(recipe3);

        Recipe recipe4=new Recipe();
        recipe4.setName("Test4");
        recipeBook.addRecipe(recipe4);

        // Actual
        String actualReturn=recipeBook.deleteRecipe(3);
        
        // Expected
        String expectedReturn="Test4";

        // Result
        assertEquals(expectedReturn, actualReturn);
    }
    
    @Test
    public void testDeleteThenAddRecipe(){
        RecipeBook recipeBook=new RecipeBook();
        Recipe recipe1=new Recipe();
        recipe1.setName("recipe1");
        recipeBook.addRecipe(recipe1);
        recipeBook.deleteRecipe(0);

        Recipe recipe2=new Recipe();
        recipe2.setName("recipe2");
        
        //Actual
        Recipe expectedReturn=recipe2;
        
        //Expected
        recipeBook.addRecipe(recipe2);
        Recipe actualReturn=recipeBook.getRecipes()[0];

        // Result
        assertEquals(expectedReturn, actualReturn);


    }

    @Test
    public void testReplaceRecipeSuccess(){
        // Set Up
        RecipeBook recipeBook=new RecipeBook();
        Recipe recipeOld=new Recipe();
        recipeOld.setName("Old Recipe");
        recipeBook.addRecipe(recipeOld);

        Recipe recipeNew=new Recipe();
        recipeNew.setName("New Recipe");

        //Actual
        String actualReturn=recipeBook.replaceRecipe(0, recipeNew);

        // Expected
        String expectedReturn="Old Recipe";

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testReplaceRecipeNull(){
        // Set Up
        RecipeBook recipeBook=new RecipeBook();

        Recipe recipeNew=new Recipe();
        recipeNew.setName("New Recipe");

        //Actual
        String actualReturn=recipeBook.replaceRecipe(0, recipeNew);

        // Expected
        String expectedReturn=null;

        // Result
        assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void testReplaceRecipeEndOfRecipeBook(){
        // Set Up
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe1=new Recipe();
        recipe1.setName("1");
        recipeBook.addRecipe(recipe1);
        
        Recipe recipe2=new Recipe();
        recipe2.setName("2");
        recipeBook.addRecipe(recipe2);
        
        Recipe recipe3=new Recipe();
        recipe3.setName("3");
        recipeBook.addRecipe(recipe3);

        Recipe recipe4=new Recipe();
        recipe4.setName("4");
        recipeBook.addRecipe(recipe4);

        Recipe recipeNew=new Recipe();
        recipeNew.setName("New Recipe");

        //Actual
        String actualReturn=recipeBook.replaceRecipe(3, recipeNew);

        // Expected
        String expectedReturn="4";

        // Result
        assertEquals(expectedReturn, actualReturn);
    }
}