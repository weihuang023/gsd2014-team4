package com.example.recipesapp;

import java.util.UUID;


import android.support.v4.app.Fragment;


public class RecipeApp extends FragmentActivityBuilder {



	@Override
	protected Fragment createFragment() {
		UUID recipeIdNumber = (UUID) getIntent().getSerializableExtra(RecipeFragment.RECIPE_ID);
	new RecipeFragment();
	return RecipeFragment.newRecipeFragment(recipeIdNumber);	
	}

	
}