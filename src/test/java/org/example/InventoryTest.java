package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author unitTesters
 *zz
 * Unit tests for Inventory class.
 */
public class InventoryTest {

	private Inventory i;
	private int randNum = -1;
	private Recipe r;


	@BeforeEach
	void setUp() throws RecipeException {
		randNum = 1 + (int) Math.abs(Math.random()*99); //generate positive integer
		i = new Inventory();

		r = new Recipe();
		r.setAmtChocolate("10");
		r.setAmtCoffee("10");
		r.setAmtMilk("10");
		r.setAmtSugar("10");

	}

	/**
	 * @Test Case ID: 62*/
	@Test
	void getChocolate() {
		Assertions.assertEquals(15, i.getChocolate());
	}

	/**
	 * @Test Case ID: 63
	 */
	@Test
	void setChocolate() {
		i.setChocolate(randNum);
		Assertions.assertEquals(randNum, i.getChocolate());
	}

	/**
	 * @Test Case ID: 64
	 */
	@Test
	void addChocolate() {
		try {
			int initial = i.getChocolate();
			i.addChocolate(randNum + "");
			Assertions.assertEquals(initial + randNum, i.getChocolate());
		} catch (InventoryException e){
			Assertions.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}

	/**
	 * @Test Case ID: 65
	 */
	@Test
	void addNegativeToChocolate() {
		Assertions.assertThrows(InventoryException.class, () -> i.addChocolate("-1"));
	}

	/**
	 * @Test Case ID: 66
	 */
	@Test
	void addInvalidToChocolate() {
		Assertions.assertThrows(InventoryException.class, () -> i.addChocolate("Seven"));
	}

	/**
	 * @Test Case ID: 67
	 */
	@Test
	void getCoffee() {
		Assertions.assertEquals(15, i.getCoffee());
	}

	/**
	 * @Test Case ID: 68
	 */
	@Test
	void setCoffee() {
		i.setCoffee(randNum);
		Assertions.assertEquals(randNum, i.getCoffee());
	}
	/**
	 * @Test Case ID: 69
	 */
	@Test
	void addCoffee() {
		try {
			int initial = i.getCoffee();
			i.addCoffee(randNum + "");
			Assertions.assertEquals(initial + randNum, i.getCoffee());
		} catch (InventoryException e){
			Assertions.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}
	/**
	 * @Test Case ID: 70
	 */
	@Test
	void addNegativeToCoffee() {
		Assertions.assertThrows(InventoryException.class, () -> i.addCoffee("-1"));
	}
	/**
	 * @Test Case ID: 71
	 */
	@Test
	void addInvalidToCoffee() {
		Assertions.assertThrows(InventoryException.class, () -> i.addCoffee("Seven"));
	}
	/**
	 * @Test Case ID: 72
	 */
	@Test
	void getMilk() {
		Assertions.assertEquals(15, i.getMilk());
	}
	/**
	 * @Test Case ID: 73
	 */
	@Test
	void setMilk() {
		i.setMilk(randNum);
		Assertions.assertEquals(randNum, i.getMilk());
	}
	/**
	 * @Test Case ID: 74
	 */
	@Test
	void addMilk() {
		try {
			int initial = i.getMilk();
			i.addMilk(randNum + "");
			Assertions.assertEquals(initial + randNum, i.getMilk());
		} catch (InventoryException e){
			Assertions.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}
	/**
	 * @Test Case ID: 75
	 */
	@Test
	void addNegativeToMilk() {
		Assertions.assertThrows(InventoryException.class, () -> i.addMilk("-1"));
	}
	/**
	 * @Test Case ID: 76
	 */
	@Test
	void addInvalidToMilk() {
		Assertions.assertThrows(InventoryException.class, () -> i.addMilk("Seven"));
	}
	/**
	 * @Test Case ID: 77
	 */
	@Test
	void getSugar() {
		Assertions.assertEquals(15, i.getSugar());
	}
	/**
	 * @Test Case ID: 78
	 */
	@Test
	void setSugar() {
		i.setSugar(randNum);
		Assertions.assertEquals(randNum, i.getSugar());
	}
	/**
	 * @Test Case ID: 79
	 */
	@Test
	void addSugar() {
		try {
			int initial = i.getSugar();
			i.addSugar(randNum + "");
			Assertions.assertEquals(initial + randNum, i.getSugar());
		} catch (InventoryException e){
			Assertions.fail("Threw InventoryException error, when presented with a positive integer");
		}
	}
	/**
	 * @Test Case ID: 80
	 */
	@Test
	void addNegativeToSugar() {
		Assertions.assertThrows(InventoryException.class, () -> i.addSugar("-1"));
	}
	/**
	 * @Test Case ID: 81
	 */
	@Test
	void addInvalidToSugar() {
		Assertions.assertThrows(InventoryException.class, () -> i.addSugar("Seven"));
	}
	/**
	 * @Test Case ID: 82
	 */
	@Test
	void enoughIngredients() throws RecipeException {

		Assertions.assertTrue(i.enoughIngredients(r));

		r.setAmtChocolate("16");
		Assertions.assertFalse(i.enoughIngredients(r));

		r.setAmtChocolate("15");
		r.setAmtCoffee("16");
		Assertions.assertFalse(i.enoughIngredients(r));

		r.setAmtCoffee("15");
		r.setAmtMilk("16");
		Assertions.assertFalse(i.enoughIngredients(r));

		r.setAmtMilk("15");
		r.setAmtSugar("16");
		Assertions.assertFalse(i.enoughIngredients(r));
	}
	/**
	 * @Test Case ID: 83
	 */
	@Test
	void useIngredients() {
		Assertions.assertTrue(i.useIngredients(r));
		Assertions.assertEquals(5, i.getChocolate());
		Assertions.assertEquals(5, i.getCoffee());
		Assertions.assertEquals(5, i.getMilk());
		Assertions.assertEquals(5, i.getSugar());

		Assertions.assertFalse(i.useIngredients(r));
	}
	/**
	 * @Test Case ID: 84
	 */
	@Test
	void testToString() {
		Assertions.assertEquals("Coffee: 15\n" +
				"Milk: 15\n" +
				"Sugar: 15\n" +
				"Chocolate: 15\n", i.toString());
	}

	/**
     * @Test Case ID: 104
     */
	@Test
	void resetInventoryToDefault() {
    	i.setCoffee(15);
    	i.setMilk(15);
    	i.setSugar(15);
    	i.setChocolate(15);

    	Assertions.assertEquals(15, i.getCoffee(), "Coffee should be reset to 15");
    	Assertions.assertEquals(15, i.getMilk(), "Milk should be reset to 15");
    	Assertions.assertEquals(15, i.getSugar(), "Sugar should be reset to 15");
    	Assertions.assertEquals(15, i.getChocolate(), "Chocolate should be reset to 15");
	}

	/**
     * @Test Case ID: 105
     */
	@Test
	void checkInventoryReductionAfterUse() throws InventoryException {
    	i.addCoffee("5"); 
    	i.addMilk("5");  
    	i.addSugar("5");  
    	i.addChocolate("5"); 

    	i.useIngredients(r);
	
    	Assertions.assertEquals(10, i.getCoffee(), "Coffee should be reduced by 10");
    	Assertions.assertEquals(10, i.getMilk(), "Milk should be reduced by 10");
    	Assertions.assertEquals(10, i.getSugar(), "Sugar should be reduced by 10");
    	Assertions.assertEquals(10, i.getChocolate(), "Chocolate should be reduced by 10");
	}
	
}