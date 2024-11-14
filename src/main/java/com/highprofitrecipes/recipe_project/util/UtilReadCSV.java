package com.highprofitrecipes.recipe_project.util;


import com.highprofitrecipes.recipe_project.model.Ingredients;
import com.highprofitrecipes.recipe_project.model.Item;
import com.highprofitrecipes.recipe_project.model.Recipes;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
This Util class will help us to read the data from the provided CSV files
Item.csv,Ingredients.csv,Recipe.csv.
 */
public final class UtilReadCSV {

    /*
    The below method helps to get CSV files from the resource section of code repo
    and it will return the data in array of strings
    */
    private static List<String[]> getCSVFiles(String csvName) throws IOException, CsvException {

        try(CSVReader csvReader=new CSVReader(new InputStreamReader
                (Objects.requireNonNull(UtilReadCSV.class.getClassLoader().getResourceAsStream(csvName))))){
            //Skip->Skips the header row and collects the processed data into list

            return csvReader.readAll().stream().skip(1).collect(Collectors.toList());
        }
    }

    // This methods helps to get the data from ingredients.csv and maps it to list of ingredients objects
    public static  List<Ingredients> getIngredientScan()throws IOException , CsvException{

            return getCSVFiles("ingredients.csv").stream().map(data->new Ingredients(data[0],data[1],data[2],
                    Integer.parseInt(data[3]))).collect(Collectors.toList());
    }

    // This methods helps to get the data from items.csv and maps it to list of ingredients objects
    public static List<Item> getItemScan()throws IOException , CsvException{

        return getCSVFiles("items.csv").stream().map(data->new Item(data[0],data[1],convertStringToDouble(data[2])))
                    .collect(Collectors.toList());
    }

    // This methods helps to get the data from recipes.csv and maps it to list of ingredients objects
    public static List<Recipes> getRecipesScan() throws IOException , CsvException{

        List<String[]> arrayString=getCSVFiles("recipes.csv");

            return arrayString.stream().map(data->new Recipes(data[0],data[1],convertStringToDouble(data[2])))
                    .collect(Collectors.toList());
    }

    //This helper method check if the value is empty , replace with 0.0
    public static double convertStringToDouble(String input){

        if(input.length()>0){
            return Double.parseDouble(input);
        }
        return 0.0;

    }

}
