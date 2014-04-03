package com.example.recipesapp;


import android.support.v4.app.Fragment;


public class RecipeListActivity extends FragmentActivityBuilder {

	

	@Override
	protected Fragment createFragment() {
		
		
		// TODO Auto-generated method stub
		return new FragmentRecipeList();
	}


}


