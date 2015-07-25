package com.example.recipesapp;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentRecipeList extends ListFragment{
	
	
	private ArrayList<Recipe> recipeList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.fragment_recipe_list_title);
		
		recipeList = AllRecipes.get(getActivity()).getRecipeList();
		
		RecipeAdapter recipeAdapter = new RecipeAdapter(recipeList);
		
		setListAdapter(recipeAdapter);
		
	}
	
	
		@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
			((RecipeAdapter)getListAdapter()).notifyDataSetChanged();

		}


		@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
			Recipe clickedRecipe = ((RecipeAdapter)getListAdapter()).getItem(position);
			
			Intent newIntent = new Intent(getActivity(),RecipeApp.class);
			
			newIntent.putExtra(RecipeFragment.RECIPE_ID,clickedRecipe.getIdNumber());
			
			startActivityForResult(newIntent,0);
	}


		private class RecipeAdapter extends ArrayAdapter<Recipe>{
			public RecipeAdapter(ArrayList<Recipe> recipes){
				super(getActivity(),android.R.layout.simple_list_item_1,recipes);
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {

			if(convertView == null){
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_recipe,null); 
			}
			
			Recipe theRecipe = getItem(position);
			TextView recipeNameTextView = (TextView) convertView.findViewById(R.id.recipe_name);
			recipeNameTextView.setText(theRecipe.getName());
			TextView recipeIngredientsTextView = (TextView) convertView.findViewById(R.id.recipe_ingredients);
			recipeIngredientsTextView.setText(theRecipe.getIngredients());
			CheckBox mostvistedCheckBox = (CheckBox) convertView.findViewById(R.id.recipe_mostvisted_checkbox);
			mostvistedCheckBox.setChecked(theRecipe.getMostvisted());

			
			return convertView;
			}
	
}
}
