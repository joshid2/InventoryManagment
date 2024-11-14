package com.highprofitrecipes.recipe_project.controller;

import com.highprofitrecipes.recipe_project.model.Profits;
import com.highprofitrecipes.recipe_project.service.RecipeProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
This controller class will work as an endpoint to get the final list of recipes profit in sorted manner.
 */
@RestController
@RequestMapping("/profit")
public class ProfitController {

    @Autowired
    private  RecipeProfitService recipeProfitService;

    @GetMapping
    public List<Profits> getBestProfitedRecipe(){
        return recipeProfitService.computeBestRecipeProfits();

    }
}
