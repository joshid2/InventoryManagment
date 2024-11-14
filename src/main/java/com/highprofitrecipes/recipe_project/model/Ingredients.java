package com.highprofitrecipes.recipe_project.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredients {

    private String recipeId;

    private String ingredientId;

    //For ingredient Type it can be an Item or Recipe
    private String ingredientType;

    //The Quantity of Items used calculated per base units
    private int quantity;

}
