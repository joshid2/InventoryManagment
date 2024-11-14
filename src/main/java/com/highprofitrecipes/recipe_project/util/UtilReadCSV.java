package com.highprofitrecipes.recipe_project.util;


import com.highprofitrecipes.recipe_project.model.Ingredients;
import com.highprofitrecipes.recipe_project.model.Item;
import com.highprofitrecipes.recipe_project.model.Recipes;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
This Util class will help us to read the data from the provided CSV files
Item.csv,Ingredients.csv,Recipe.csv.
 */
@Component
public class UtilReadCSV {

    // This methods helps to get the data from ingredients.csv and maps it to list of ingredients objects
    public List<Ingredients> getIngredientScan(){


        try(CSVReader csvReader =new CSVReader(new FileReader("ingredients.csv"))){
            //Read data from CSV file
            List<String[]> ingredientsFileData =csvReader.readAll();
            //Skip->Skips the header row and collects the processed data into list
            return ingredientsFileData.stream().skip(1).map(data->new Ingredients(data[0],data[1],data[2],
                    Integer.parseInt(data[3]))).collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        //return an empty collection in case of exception or no data founds
        return Collections.emptyList();

    }

    // This methods helps to get the data from ingredients.csv and maps it to list of ingredients objects
    public List<Item> getItemScan(){

        try(CSVReader csvReader=new CSVReader(new FileReader("items.csv"))){
            //Read data from CSV file
            List<String[]> itemsFileData =csvReader.readAll();
            //Skip->Skips the header row and collects the processed data into list
            return itemsFileData.stream().skip(1).map(data->new Item(data[0],data[1],Double.parseDouble(data[2])))
                    .collect(Collectors.toList());

        }catch (IOException e){
            e.printStackTrace();
        }
        //return an empty collection in case of exception or no data founds
        return Collections.emptyList();

    }

    // This methods helps to get the data from ingredients.csv and maps it to list of ingredients objects
    public List<Recipes> getRecipesScan(){

        try(CSVReader csvReader=new CSVReader(new FileReader("recipes.csv"))){
            //Read data from CSV file
            List<String[]> recipesFileData=csvReader.readAll();
            //Skip->Skips the header row and collects the processed data into list
            return recipesFileData.stream().skip(1).map(data->new Recipes(data[0],data[1],Double.parseDouble(data[2])))
                    .collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        //return an empty collection in case of exception or no data founds
        return Collections.emptyList();

    }

}
