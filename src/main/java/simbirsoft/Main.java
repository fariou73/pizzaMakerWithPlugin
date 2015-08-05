package simbirsoft;

import com.simbirsoft.interfaces.IngredientInterface;

import java.io.File;
import java.util.*;

public class Main {
    private static final PizzaQueue MY_PIZZA_QUEUE = new PizzaQueue();
    private static volatile Ingredients REAL_PIZZA_INGREDIENTS = new Ingredients();
    private static final Ingredients CUSTOMER_PIZZA_INGREDIENTS = new Ingredients();

    public static void main(String[] args) {

        String pathFromFile = "ingriki.txt";

        if ((new File(pathFromFile)).exists()) {
            PluginJarLoader pluginJarLoader = new PluginJarLoader(REAL_PIZZA_INGREDIENTS);
            while (true) {
                startWorkWithPizza(pathFromFile);
            }
        } else {
            System.out.println("File With ingredients not found.");
        }
    }

    private static void startWorkWithPizza(String pathFromFile) {
        final int exitId = 998;
        final int exitIdFromShow = exitId + 1;
        Scanner scanner = new Scanner(System.in);
        int ingredientCount;
        int ingredientId = -1;
        PizzaSize myPizzaSize = new PizzaSize();
        CUSTOMER_PIZZA_INGREDIENTS.clear();
        System.out.println("Sizes:");
        myPizzaSize.printALL();
        myPizzaSize.setCurrentSize("");
        while (!myPizzaSize.SIZES_OF_PIZZA.contains(myPizzaSize.getCurrentSize())) {
            System.out.println("Enter size of pizza:");
            myPizzaSize.setCurrentSize(scanner.nextLine().toUpperCase());
        }
        System.out.println("Ingredients:");
        REAL_PIZZA_INGREDIENTS.loadFromFile(pathFromFile);
        REAL_PIZZA_INGREDIENTS.printAll();
        while (ingredientId != exitId & CUSTOMER_PIZZA_INGREDIENTS.getIngredients().size() >= 0) {
            System.out.println("(" + exitIdFromShow + " from exit) Enter the number of engredient:");
            ingredientId = scanner.nextInt() - 1;
            if (ingredientId < REAL_PIZZA_INGREDIENTS.getIngredients().size() && ingredientId >= 0) {
                System.out.println("Enter the number of portion:");
                try {
                    ingredientCount = new Scanner(System.in).nextInt();
                    IngredientInterface _ingr = REAL_PIZZA_INGREDIENTS.getIngredients().get(ingredientId);
                    if ((_ingr.getIngredientCount() - ingredientCount) >= 0 && ingredientCount != 0) {
                        CUSTOMER_PIZZA_INGREDIENTS.add(new Ingredient(_ingr.getIngredientsName(), ingredientCount));
                        REAL_PIZZA_INGREDIENTS.getIngredients().get(ingredientId).setIngredientCount(_ingr.getIngredientCount() - ingredientCount);
                        REAL_PIZZA_INGREDIENTS.saveFromFile(pathFromFile);
                    } else {
                        System.out.println("Incorrect number");
                    }
                } catch (Exception e) {
                    System.err.println("You have written an incorrect number.");
                }
            } else if (ingredientId != exitId) {
                System.out.println("Ingredient not find.");
            }
        }
        System.out.println("Your ingredients:");
        CUSTOMER_PIZZA_INGREDIENTS.printAll();
        REAL_PIZZA_INGREDIENTS.clear();
        Pizza myPizza = new Pizza(myPizzaSize, CUSTOMER_PIZZA_INGREDIENTS);
        MY_PIZZA_QUEUE.add(myPizza);
    }
}






