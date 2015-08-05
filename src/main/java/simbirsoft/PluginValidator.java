package simbirsoft;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.simbirsoft.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class PluginValidator {

    public List<IngredientInterface> loadIngredients(Class<?> pluginClass) {
        List<IngredientInterface> pluginIngredient = new ArrayList<IngredientInterface>();
        if (PluginIngredientsInterface.class.isAssignableFrom(pluginClass)) {
            try {
                PluginIngredientsInterface plugin = (PluginIngredientsInterface) pluginClass.newInstance();
                pluginIngredient = plugin.getIngredients();
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
                pluginIngredient = null;
            }
        }
        return pluginIngredient;
    }
}
