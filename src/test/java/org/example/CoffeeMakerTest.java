package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {

    private Recipe recipeTest1;
    private Recipe recipeTest2;
    private CoffeeMaker coffeeMaker;
    private Inventory inventory;

    @BeforeEach
    void setUp() throws RecipeException {
        inventory = new Inventory();
        coffeeMaker = new CoffeeMaker();
        recipeTest1 = new Recipe();

        recipeTest1.setName("Coffee");
        recipeTest1.setAmtChocolate("0");
        recipeTest1.setAmtCoffee("3");
        recipeTest1.setAmtMilk("1");
        recipeTest1.setAmtSugar("1");
        recipeTest1.setPrice("50");

        recipeTest2 = new Recipe();
        recipeTest2.setName("Tea");
        recipeTest2.setAmtChocolate("0");
        recipeTest2.setAmtCoffee("3");
        recipeTest2.setAmtMilk("1");
        recipeTest2.setAmtSugar("1");
        recipeTest2.setPrice("50");
    }
    /**
     * @Test Case ID: 44
     */
    @Test
    void testGetRecipes(){
        coffeeMaker.addRecipe(recipeTest1);
        Recipe[] recipes = new Recipe[4];
        recipes[0] = recipeTest1;
        Assertions.assertArrayEquals(recipes ,coffeeMaker.getRecipes());
    }
    /**
     * @Test Case ID: 45
     */
    @Test
    void testDeleteRecipe(){
        coffeeMaker.addRecipe(recipeTest1);
        coffeeMaker.deleteRecipe(0);
        Assertions.assertNotSame(recipeTest1, coffeeMaker.getRecipes()[0]);
        Assertions.assertNull(coffeeMaker.getRecipes()[0]);
    }
    /**
     * @Test Case ID: 46
     */
    @Test
    void testDeleteRecipeThatIsNull(){
        Assertions.assertNull(coffeeMaker.deleteRecipe(3));
    }
    /**
     * @Test Case ID: 47
     */
    @Test
    void testAddRecipe(){
        Recipe[] recipes = coffeeMaker.getRecipes();
        Assertions.assertTrue(coffeeMaker.addRecipe(recipeTest1));
        Recipe recipeTest = recipes[0];
        Assertions.assertEquals(recipeTest1, recipeTest);
        Assertions.assertFalse(coffeeMaker.addRecipe(recipeTest1));
    }
    /**
     * @Test Case ID: 48
     */
    @Test
    void testAddRecipeAddingTheSameRecipe(){
        coffeeMaker.addRecipe(recipeTest1);
        Assertions.assertFalse(coffeeMaker.addRecipe(recipeTest1));
    }
    /**
     * @Test Case ID: 49
     */
    @Test
    void testEditRecipe() throws RecipeException {

        coffeeMaker.addRecipe(recipeTest1);
        coffeeMaker.editRecipe(0, recipeTest2);
        Recipe[] recipes = coffeeMaker.getRecipes();
        recipes[0] = recipeTest2; // Update to reflect the change made
        Assertions.assertArrayEquals(recipes, coffeeMaker.getRecipes());
        Assertions.assertSame(recipeTest2, coffeeMaker.getRecipes()[0]);
    }
    /**
     * @Test Case ID: 50
     */
    @Test
    void testEditRecipeAtNullPosition() {
        coffeeMaker.addRecipe(recipeTest1); // Ensure there's at least one recipe to edit
        Assertions.assertNull(coffeeMaker.editRecipe(3, recipeTest2));
    }
    /**
     * @Test Case ID: 51
     */
    @Test
    void testCheckInventory(){
        String inventoryStatus = "Coffee: " + inventory.getCoffee() + "\n" +
                "Milk: " + inventory.getMilk() + "\n" +
                "Sugar: " + inventory.getSugar() + "\n" +
                "Chocolate: " + inventory.getChocolate() + "\n";
        Assertions.assertEquals(inventoryStatus.trim(), coffeeMaker.checkInventory().trim());
    }
    /**
     * @Test Case ID: 52
     */
    @Test
    void testCheckInventoryNotNull(){
        Assertions.assertNotNull(coffeeMaker.checkInventory());
    }
    /**
     * @Test Case ID: 53
     */
    @Test
    void testAddInventory(){
        try {
            coffeeMaker.addInventory("20", "20", "20", "20");
            Assertions.assertEquals("Coffee: 35\n" +
                    "Milk: 35\n" +
                    "Sugar: 35\n" +
                    "Chocolate: 35\n", coffeeMaker.checkInventory());
        }
        catch (InventoryException e){
            Assertions.fail("Adding valid inventory resulted in an exception being thrown.");
        }
    }
    /**
     * @Test Case ID: 54
     */
    @Test
    void testAddInventoryWithInvalidData(){
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("a","","test",null));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("","a",null,"test"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("test",null,"a",""));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( null,"test","","a"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-3","-6","-4","-4"));

        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("-2","10","10","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("10","-2","10","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory("10","10","-2","10"));
        Assertions.assertThrows(InventoryException.class, () -> coffeeMaker.addInventory( "10","10","10","-2"));
    }
    /**
     * @Test Case ID: 55
     */
    @Test
    void testAddInventoryWithZero() {
        try {
            coffeeMaker.addInventory("0", "0", "0", "0");
            Assertions.assertEquals("Coffee: 15\n" +
                    "Milk: 15\n" +
                    "Sugar: 15\n" +
                    "Chocolate: 15\n", coffeeMaker.checkInventory());
        }
        catch (InventoryException e){
            Assertions.fail("Adding zero inventory should not fail.");
        }
    }
    /**
     * @Test Case ID: 56
     */
    @Test
    void testMakeCoffee() throws RecipeException {
        coffeeMaker.addRecipe(recipeTest1);
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(50, testChange);
    }
    /**
     * @Test Case ID: 57
     */
    @Test
    void testMakeCoffeeNoRecipe(){
        int testChange = coffeeMaker.makeCoffee(0,100);
        Assertions.assertEquals(100, testChange);
    }
    /**
     * @Test Case ID: 58
     */
    @Test
    void testMakeCoffeeInvalidRecipeInput(){
        int testChange = coffeeMaker.makeCoffee(4,100); // Adjust to use valid array index
        Assertions.assertEquals(100, testChange);
    }
    /**
     * @Test Case ID: 59
     */
    // @Test
    // void testMakeCoffeeInvalidPriceInput() throws RecipeException {
    //     coffeeMaker.addRecipe(recipeTest1);
    //     int testChange = coffeeMaker.makeCoffee(0,-3);
    //     Assertions.assertEquals(100, testChange); // Adjust expectation to return full amount when price is invalid
    // }
    /**
     * @Test Case ID:60
     */
    @Test
    void testMakeCoffeeInvalidSmallerPriceInput() throws RecipeException{
        coffeeMaker.addRecipe(recipeTest1);
        int testChange = coffeeMaker.makeCoffee(0,10);
        Assertions.assertEquals(10, testChange); // Maintain test validity: input less than recipe price returns input amount

    }
    /**
     * @Test Case ID: 61
     */
    // @Test
    // void testMakeCoffeeNoInventory() throws RecipeException{
    //     coffeeMaker.addRecipe(recipeTest1);
    //     try {
    //         coffeeMaker.addInventory("-10", "-10", "-10", "-10"); // Attempt to reduce inventory to below 0
    //     } catch (InventoryException ignored) {
    //     }
    //     int testChange = coffeeMaker.makeCoffee(0,100);
    //     Assertions.assertEquals(100, testChange); // Inventory shortage should prevent purchase

    // }
}