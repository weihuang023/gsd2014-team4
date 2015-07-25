package com.example.recipesapp;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class AllRecipes {
	
	
	private static AllRecipes allRecipes;
	
	private Context applicationContext;
	
	private ArrayList<Recipe> recipeList;
	
	private AllRecipes(Context applicationContext){
		this.applicationContext = applicationContext;
		recipeList = new ArrayList<Recipe>();
		Recipe rice = new Recipe();
		rice.setName("Rice");
		rice.setIngredients("White");
		rice.setMostvisted(false);
		recipeList.add(rice);
		
		Recipe banana = new Recipe();
		banana.setName("banana");
		banana.setIngredients("Yellow");
		banana.setMostvisted(false);
		recipeList.add(banana);
		
		Recipe cake = new Recipe();
		cake.setName("cake");
		cake.setIngredients("cake");
		cake.setMostvisted(false);
		recipeList.add(cake);
		
		
	}
	
	public static AllRecipes get(Context context){
		if (allRecipes == null){
			allRecipes = new AllRecipes(context.getApplicationContext());
		}
		return allRecipes;
	}
	
	public ArrayList<Recipe> getRecipeList(){
		
		return recipeList;
	}
	
	public Recipe getRecipe(UUID id){
		for(Recipe theRecipe : recipeList){
			if(theRecipe.getIdNumber().equals(id)){
				return theRecipe;
			}
		}
		return null;
	}

}
