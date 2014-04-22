package com.weihuang.recipes;

import java.util.HashMap;

import com.weihuang.recipes.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;


public class NewRecipe extends Activity{

	// The EditText objects

	EditText recipeName;
	EditText recipeDescription;
	EditText recipeTime;
	EditText recipeIngredients;
	EditText recipeInstruction;
	String recipeRadioGroupButton;

	DBTools dbTools = new DBTools(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {

		// Get saved data if there is any

		super.onCreate(savedInstanceState);

		// Designate that add_new_recipe.xml is the interface used
		
		setContentView(R.layout.add_new_recipe);

		// Initialize the EditText objects
		
		recipeName = (EditText) findViewById(R.id.recipeName);
		recipeDescription = (EditText) findViewById(R.id.recipeDescription);
		recipeTime = (EditText) findViewById(R.id.recipeTime);
		recipeIngredients = (EditText) findViewById(R.id.recipeIngredients);
		recipeInstruction = (EditText) findViewById(R.id.recipeInstruction);
	
		
		//recipeRadioGroupButton = (String) findViewById(R.id.)
	}
	public void addNewRecipe(View view) {
		
		// Will hold the HashMap of values 
		
		HashMap<String, String> queryValuesMap =  new  HashMap<String, String>();

		// Get the values from the EditText boxes
		
		queryValuesMap.put("recipeName", recipeName.getText().toString());
		queryValuesMap.put("recipeDescription", recipeDescription.getText().toString());
		queryValuesMap.put("recipeTime", recipeTime.getText().toString());
		queryValuesMap.put("recipeIngredients", recipeIngredients.getText().toString());
		queryValuesMap.put("recipeInstruction", recipeInstruction.getText().toString());

		// Call for the HashMap to be added to the database
		
		dbTools.insertRecipe(queryValuesMap);
		
		// Call for MainActivity to execute
		
		this.callMainActivity(view);
	}
	
	public void callMainActivity(View view) {
		Intent theIntent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(theIntent);
	}	
}
