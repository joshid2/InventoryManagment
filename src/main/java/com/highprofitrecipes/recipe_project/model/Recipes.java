package com.highprofitrecipes.recipe_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Recipes {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private double salePrice;
}
