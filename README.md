
# HighProfitRecipe_Calculator



The HighProfitRecipe_Calculator is a SpringBoot Application that helps to calculate the profit from each recipe on a resturant menu.
Profit is calculated by taking the differnce between ingredients cost and total sale of every recipe.The program is well capable to identify the types of ingredients,where an ingredient may contain both standalone thing(e.g ., veggies and condiments) and other recipes(eg,veggieNuggest or Samosa) that can be used as sub-recipes.This allows resturants to predict the profitabilty of complex menus. 

The Projects takes three 3CSV files a input data 
ingredients.csv
items.csv
recipes.csv 
Based on these three files , the program calculates the highest profitable recipe and return a list in descending order.
## Tech Stack

**Language:** Java

**Framework:** SpringBoot

**BuildTool**   Maven

**Data Parsing** OpenCSV


## Dependency and Prerequisites

**JAVA 8 or higher**
****
Install JDK from https://www.oracle.com/ie/java/technologies/downloads/

**GIT**--**Clone the Repository**
****
```bash
  git clone<Repository-url>
```

**Maven**
****
Ensure maven is installed 
****
Navigate to the project directory and run
****
```bash
  mvn clean install
```
#bash : 
****
Run the application 
****
```bash
  mvn spring-boot:run
```

**IDE (e.g Intellij,Eclipse) or Text Editor**

**CSV Files**

**Access the API**
The application will run on http://localhost:9091

One can change the port based on port availability
****
http://localhost:9091/profit
****
The application exposes one end point to get the profit for each recipe 
Request Type: GET



## API Reference

#### Get all list of profitable recipes from order high to low

```http://localhost:9091/profit
  GET /profit
```



#### Returns

```http
  [
    {
        "recipes": "Chickie Burg",
        "profit_amount": 12.0
    },
    {
        "recipes": "Dirty Fries",
        "profit_amount": 6.5
    },
    {
        "recipes": "Mac",
        "profit_amount": 5.5
    },
    {
        "recipes": "Puddin",
        "profit_amount": 5.45
    },
    {
        "recipes": "Tendies",
        "profit_amount": 0.8599999999999994
    }
]
```


## Code Structure and Explanation 

**RecipeProjectApplication**
```
This the main springboot application class ,that servers as a entry point to our application.It is responsible for bootstrpping the application and running the embedded server 

To start the application all we need to run the class:

```
**RecipeProjectApplication.class**
```
This class is all we need to get our springboot up and running.Once its started it will automatically detect all the other required supporting classes 

```
```
Once the application start running up , we can validate the response by using the provided API-endpoint
```


**Controller**

```
ProfitController.class     

**This class works as an endpoint to get the sorted list of recipe profits.The controller invokes the RecipeProfitService to process the data and return final list.**
```
**Model**
```
The below are the Model classes collectively represents 
the structre of data for recipes,
ingredients and items and its allows the service 
to calculate each recipe profitability.

Ingredients.class
Items.class
Profits.class
Recipes.class
                         
```

**Service_Layer**
```
RecipeProfitService.class

This class and its method computeBestRecipeProfits() 
helps to compute the profit of each recipes based on quantity of 
ingredients and cost of items.It also filter out the recipes 
whose sale price is null/0 and sort the recipes profit.


                         
```
**Utils**
```
UtilReadCSV.class   

This Utility class handles reading the CSV files, and parsing each row to provide the data for the service layer funtionality.
```
