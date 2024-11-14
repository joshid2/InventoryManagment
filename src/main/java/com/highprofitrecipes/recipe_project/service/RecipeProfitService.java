package com.highprofitrecipes.recipe_project.service;


import com.highprofitrecipes.recipe_project.model.Ingredients;
import com.highprofitrecipes.recipe_project.model.Item;
import com.highprofitrecipes.recipe_project.model.Profits;
import com.highprofitrecipes.recipe_project.model.Recipes;
import com.highprofitrecipes.recipe_project.util.UtilReadCSV;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
This service class will take the data from CSV file and will compute
the profit and return recipes based on the profit in a sorted order.
 */

@Service
public class RecipeProfitService {

    private List<Ingredients> ingredients;
    private List<Item> items;
    private List<Recipes> recipes;

    public RecipeProfitService() throws IOException, CsvException {
        this.loadData();
    }

    private void loadData() throws IOException, CsvException {
            this.ingredients= UtilReadCSV.getIngredientScan();
            this.recipes=UtilReadCSV.getRecipesScan();
            this.items=UtilReadCSV.getItemScan();

    }

    public List<Profits> computeBestRecipeProfits() {

        //itemMap is used to store the item costs based on the itemId
        Map<String, Double> itemMap = items.stream().collect(Collectors.toMap(Item::getId, Item::getCost));
        // recipeCostMap is used to addUp the final ingredient cost for recipes
        Map<String, Double> recipeCostMap = new HashMap<>();

        // Traverse performed for each recipe to get the total cost
        for (Recipes recipe : recipes) {
            if (recipe.getSalePrice() <= 0) {
                continue; // Skip recipes with no sale price
            }

            double finalCost = 0;

            List<Ingredients> recipeIngredients = ingredients.stream()
                    //to filter the ingredient for there recipe
                    .filter(ingredient -> ingredient.getRecipeId().equals(recipe.getId()))
                    .collect(Collectors.toList());

            // based on the recipe calculate the cost of ingredient for every recipe
            for (Ingredients ingredient : recipeIngredients) {
                double ingredientPrice;

                // ingredient==item get cost and multiply with units
                if ("item".equals(ingredient.getIngredientType())) {
                    ingredientPrice = itemMap.getOrDefault(ingredient.getIngredientId(), 0.0) * ingredient.getQuantity();
                } else { // ingredient==recipe get cost from recipe map and multiple with  units
                    finalCost = recipeCostMap.getOrDefault(ingredient.getIngredientId(), 0.0) * ingredient.getQuantity();
                    break;
                }
                finalCost += ingredientPrice;
            }

            //here we put the cost into map
            recipeCostMap.put(recipe.getId(), finalCost);
        }

        /*
        return the sortedlist of calculated profit and collect into list
         */
        return recipes.stream()
                .filter(recipe -> recipe.getSalePrice() > 0) // recipes with only a price more 0 and rest are removed(filtered)
                //profit is calculated.
                .map(recipe -> new Profits(recipe.getName(), recipe.getSalePrice() - recipeCostMap.get(recipe.getId())))
                //Sorted recipes based on profit in desc order
                .sorted(Comparator.comparingDouble(Profits::getProfit_amount).reversed())
                .collect(Collectors.toList());
    }
}


