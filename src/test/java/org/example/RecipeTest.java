package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RecipeTest  {

    private Recipe recipe;
    private Recipe recipe2;

    @BeforeEach
    void setUp() throws RecipeException {
        recipe = new Recipe();
        recipe.setAmtChocolate("5");
        recipe.setAmtCoffee("10");
        recipe.setAmtMilk("8");
        recipe.setAmtSugar("7");
        recipe.setName("name");
        recipe.setPrice("50");

        recipe2 = new Recipe();
        recipe2.setAmtChocolate("5");
        recipe2.setAmtCoffee("10");
        recipe2.setAmtMilk("8");
        recipe2.setAmtSugar("7");
        recipe2.setName("name");
        recipe2.setPrice("50");
    }
    /**
     * @Test Case ID: 1
     */
    @Test
    void testGetAmtChocolatePositiveInt(){
        Assertions.assertEquals(5,recipe.getAmtChocolate());
    }
    /**
     * @Test Case ID: 2
     */
    @Test
    void testSetAmtChocolate() {
        try {
            recipe.setAmtChocolate("12");
            Assertions.assertEquals(12, recipe.getAmtChocolate());
        } catch (RecipeException e) {
            Assertions.fail("RecipeException was thrown, due to an invalid input!");
        }
    }
    /**
     * @Test Case ID:3
     */
    @Test
    void testSetAmtChocolateNegativeNumber(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(-1+""));
    }
    /**
     * @Test Case ID: 4
     */
    @Test
    void testSetAmtChocolateInvalid(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("Blah"));
    }
    /**
     * @Test Case ID: 5
     */
    @Test
    void testSetAmtChocolateNoInput(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(""));
    }
    /**
     * @Test Case ID: 6
     */
    @Test
    void testGetAmtCoffee(){
        Assertions.assertEquals(10,recipe.getAmtCoffee());
    }
    /**
     * @Test Case ID: 7
     */
    @Test
    void testSetAmtCoffee() {
        try {
            recipe.setAmtCoffee("17");
            Assertions.assertEquals(17, recipe.getAmtCoffee());
        } catch (RecipeException e) {
            Assertions.fail("RecipeException was thrown, due to an invalid input!");
        }
    }
    /**
     * @Test Case ID: 8
     */
    @Test
    void testSetAmtCoffeeNegativeNumber(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(-1+""));
    }
    /**
     * @Test Case ID: 9
     */
    @Test
    void testSetAmtCoffeeInvalid(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("Blah"));
    }
    /**
     * @Test Case ID: 10
     */
    @Test
    void testSetAmtCoffeeEmptyInput(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(""));
    }
    /**
     * @Test Case ID: 11
     */
    @Test
    void testGetAmtMilk(){
        Assertions.assertEquals(8,recipe.getAmtMilk());
    }
    /**
     * @Test Case ID: 12
     */
    @Test
    void testSetAmtMilk() {
        try {
        recipe.setAmtMilk("9");
        Assertions.assertEquals(9,recipe.getAmtMilk());
        } catch (RecipeException e) {
            Assertions.fail("RecipeException was thrown, due to an invalid input!");
        }
    }
    /**
     * @Test Case ID: 13
     */
    @Test
    void testSetAmtMilkNegativeNumber(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtMilk(-1+""));
    }
    /**
     * @Test Case ID: 14
     */
    @Test
    void testSetAmtMilkInvalid(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtMilk("Blah"));
    }
    /**
     * @Test Case ID: 15
     */
    @Test
    void testSetAmtMilkEmptyInput(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtMilk(""));
    }
    /**
     * @Test Case ID: 16
     */
    @Test
    void testGetAmtSugar(){
        Assertions.assertEquals(7,recipe.getAmtSugar());
    }
    /**
     * @Test Case ID: 17
     */
    @Test
    void testSetAmtSugar() {
        try {
            recipe.setAmtSugar("11");
            Assertions.assertEquals(11, recipe.getAmtSugar());
        } catch (RecipeException e) {
            Assertions.fail("RecipeException was thrown, due to an invalid input!");
        }
    }
    /**
     * @Test Case ID: 18
     */
    @Test
    void testSetAmtSugarNegativeNumber(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtSugar(-1+""));
    }
    /**
     * @Test Case ID: 19
     */
    @Test
    void testSetAmtSugarInvalid(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtSugar("Blah"));
    }
    /**
     * @Test Case ID: 20
     */
    @Test
    void testSetAmtSugarEmptyInput(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setAmtSugar(""));
    }
    /**
     * @Test Case ID: 21
     */
    @Test
    void testGetName(){
        Assertions.assertEquals("name",recipe.getName());
    }
    /**
     * @Test Case ID: 22
     */
    @Test
    void testSetName(){
        recipe.setName("New");
        Assertions.assertEquals("New",recipe.getName());
    }
    /**
     * @Test Case ID: 23
     */
    @Test
    void testSetNameNull(){
        recipe.setName(null);
        Assertions.assertNull(recipe.getName());
    }
    /**
     * @Test Case ID: 24
     */
    @Test
    void testGetPrice(){
        Assertions.assertEquals(50,recipe.getPrice());
    }
    /**
     * @Test Case ID: 25
     */
    @Test
    void testSetPrice() {
        try {
        recipe.setPrice("55");
        Assertions.assertEquals(55,recipe.getPrice());
        } catch (RecipeException e) {
            Assertions.fail("RecipeException was thrown, due to an invalid input!");
        }
    }
    /**
     * @Test Case ID: 26
     */
    @Test
    void testSetPriceNegativeNumber(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setPrice(-1+""));
    }
    /**
     * @Test Case ID: 27
     */
    @Test
    void testSetPriceInvalid(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setPrice("Blah"));
    }
    /**
     * @Test Case ID: 28
     */
    @Test
    void testSetPriceEmptyInput(){
        Assertions.assertThrows(RecipeException.class, () -> recipe.setPrice(""));
    }
    /**
     * @Test Case ID: 29
     */
    @Test
    void testToString(){
        Assertions.assertEquals(recipe.getName(),recipe.toString());
    }
    /**
     * @Test Case ID: 30
     */
    @Test
    void testHashCode(){
        Assertions.assertTrue(recipe.hashCode() == recipe2.hashCode());
        Assertions.assertTrue(recipe.equals(recipe2) && recipe2.equals(recipe));
    }
    /**
     * @Test Case ID: 31
     */
    @Test
    void testEqualsValid() throws RecipeException {

        Recipe recipe3 = new Recipe();
        recipe3.setAmtChocolate("5");
        recipe3.setAmtCoffee("10");
        recipe3.setAmtMilk("8");
        recipe3.setAmtSugar("7");
        recipe3.setName("name");
        recipe3.setPrice("50");
        Assertions.assertEquals(recipe, recipe3);

        recipe2 = recipe;
        Assertions.assertEquals(recipe, recipe2);
    }
    /**
     * @Test Case ID: 32
     */
    @Test
    void testEqualsNull(){
        recipe2 = null;
        Assertions.assertFalse(recipe.equals(recipe2));
    }
    /**
     * @Test Case ID: 33
     */
    @Test
    void testEqualsReturnFalse(){
        recipe2.setName("new name");
        Assertions.assertFalse(recipe.equals(recipe2));
    }

    /**
     * @Test Case ID: 34
     */
    @Test
    void testEqualsGetClass() {

        Inventory inv = new Inventory();
        Assertions.assertFalse(recipe.equals(inv));
    }

}