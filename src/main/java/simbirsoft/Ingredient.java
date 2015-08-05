package simbirsoft;

import com.simbirsoft.interfaces.IngredientInterface;

public class Ingredient implements IngredientInterface {
    private final String ingredientsName;
    private Integer ingredientCount;


    public Ingredient(String ingredientsName, Integer ingredientCount) {
        this.ingredientsName = ingredientsName;
        this.ingredientCount = ingredientCount;
    }

    @Override
    public String getIngredientsName() {
        return ingredientsName;
    }

    @Override
    public Integer getIngredientCount() {
        return ingredientCount;
    }

    @Override
    public void setIngredientCount(Integer count) {
        ingredientCount = count;
    }

    @Override
    public String toString() {
        return (ingredientsName + ' ' + ingredientCount);
    }
}
