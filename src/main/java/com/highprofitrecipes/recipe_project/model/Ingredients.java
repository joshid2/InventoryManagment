package com.highprofitrecipes.recipe_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    @Getter @Setter
    private String recipeId;
    @Getter @Setter
    private String ingredientId;

    //For ingredient Type it can be an Item or Recipe
    @Getter @Setter
    private String ingredientType;

    //The Quantity of Items used calculated per base units
    @Getter @Setter
    private int quantity;

}
