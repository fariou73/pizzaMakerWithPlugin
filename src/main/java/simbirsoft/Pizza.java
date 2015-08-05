package simbirsoft;

public class Pizza {
    private final PizzaSize currentPizzaSize;
    private final Ingredients currentIngredients;

    public Pizza(PizzaSize currentPizzaSize, Ingredients currentIngredients) {
        this.currentPizzaSize = currentPizzaSize;
        this.currentIngredients = currentIngredients;
    }

    public void printALL() {
        System.out.println("Pizza size: " + currentPizzaSize.getCurrentSize());
        currentIngredients.printAll();
    }
}
