package com.highprofitrecipes.recipe_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//This class will help us to get the response in respect to profit and recipes
@AllArgsConstructor
@Data
public class Profits {

    private String recipes;
    private double profit_amount;
}
