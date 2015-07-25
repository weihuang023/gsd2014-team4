package com.example.recipesapp;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class RecipeFragment extends Fragment {

	public static final String RECIPE_ID = "com.example.recipesapp.recipe_id";
	private Recipe recipe;
	private EditText recipeNameEditText;
	private EditText recipeIngredientsEditText;
	private EditText recipeInstructionEditText;
	private CheckBox mostvistedCheckBox;
	public static RecipeFragment newRecipeFragment(UUID recipeId){
		Bundle passedData = new Bundle();

		passedData.putSerializable(RECIPE_ID,recipeId);

		RecipeFragment recipeFragment = new RecipeFragment();

		recipeFragment.setArguments(passedData);

		return recipeFragment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		UUID recipeId = (UUID) getArguments().getSerializable(RECIPE_ID);

		recipe = AllRecipes.get(getActivity()).getRecipe(recipeId);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View theView = inflater.inflate(R.layout.fragment_recipe,container,false);
		recipeNameEditText=(EditText) theView.findViewById(R.id.recipeNameEditText);
		recipeIngredientsEditText=(EditText) theView.findViewById(R.id.recipeIngredientsEditText);
		recipeInstructionEditText=(EditText) theView.findViewById(R.id.recipeInstructionEditText);

		TextWatcher editTextWatcher = new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(recipeNameEditText.hasFocus() == true){
					recipe.setName(s.toString());
				}else if(recipeIngredientsEditText.hasFocus() == true){
					recipe.setIngredients(s.toString());
				}else if(recipeInstructionEditText.hasFocus() == true){
					recipe.setInstruction(s.toString());
				}
			}
		};

		recipeNameEditText.addTextChangedListener(editTextWatcher);
		recipeIngredientsEditText.addTextChangedListener(editTextWatcher);
		recipeInstructionEditText.addTextChangedListener(editTextWatcher);
		mostvistedCheckBox = (CheckBox) theView.findViewById(R.id.mostvistedCheckBox);

		mostvistedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO 
				// if true change to false
				// if false change to true
				recipe.setMostvisted(!recipe.getMostvisted());

			}});
		recipeNameEditText.setText(recipe.getName());;
		recipeIngredientsEditText.setText(recipe.getIngredients());;
		recipeInstructionEditText.setText(recipe.getInstruction());;
		mostvistedCheckBox.setChecked(recipe.getMostvisted());
		return theView;
	}}