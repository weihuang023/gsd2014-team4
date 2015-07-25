package com.weihuang.recipes;

import java.util.HashMap;

import com.weihuang.recipes.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditRecipe extends Activity{
	
	EditText recipeName;
	EditText recipeDescription;
	EditText recipeTime;
	EditText recipeIngredients;
	EditText recipeInstruction;
	
	DBTools dbTools = new DBTools(this);
	
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_recipe);
		recipeName = (EditText) findViewById(R.id.recipeName);
		recipeDescription = (EditText) findViewById(R.id.recipeDescription);
		recipeTime = (EditText) findViewById(R.id.recipeTime);
		recipeIngredients = (EditText) findViewById(R.id.recipeIngredients);
		recipeInstruction = (EditText) findViewById(R.id.recipeInstruction);
		
		Intent theIntent = getIntent();
		
		String recipeId = theIntent.getStringExtra("recipeId");
		
		HashMap<String, String> recipeList = dbTools.getRecipeInfo(recipeId);
		
		if(recipeList.size() != 0){
			
			recipeName.setText(recipeList.get("recipeName"));
			recipeDescription.setText(recipeList.get("recipeDescription"));
			recipeTime.setText(recipeList.get("recipeTime"));
			recipeIngredients.setText(recipeList.get("recipeIngredients"));
			recipeInstruction.setText(recipeList.get("recipeInstruction"));
			
		}
	}
	
	public void editRecipe(View view){
		
		HashMap<String, String> queryValuesMap = new HashMap<String, String>();
		recipeName = (EditText) findViewById(R.id.recipeName);
		recipeDescription = (EditText) findViewById(R.id.recipeDescription);
		recipeTime = (EditText) findViewById(R.id.recipeTime);
		recipeIngredients = (EditText) findViewById(R.id.recipeIngredients);
		recipeInstruction = (EditText) findViewById(R.id.recipeInstruction);
		
		Intent theIntent = getIntent();
		
		String recipeId = theIntent.getStringExtra("recipeId");
		
		queryValuesMap.put("recipeId", recipeId);
		queryValuesMap.put("recipeName", recipeName.getText().toString());
		queryValuesMap.put("recipeDescription", recipeDescription.getText().toString());
		queryValuesMap.put("recipeTime", recipeTime.getText().toString());
		queryValuesMap.put("recipeIngredients", recipeIngredients.getText().toString());
		queryValuesMap.put("recipeInstruction", recipeInstruction.getText().toString());
		
		dbTools.updateRecipe(queryValuesMap);
		this.callMainActivity(view);
		
	}
	
	public void removeRecipe(View view){
		
		Intent theIntent = getIntent();
		
		String recipeId = theIntent.getStringExtra("recipeId");
		
		dbTools.deleteRecipe(recipeId);
		
		this.callMainActivity(view);
		
	}
	
	public void callMainActivity(View view){
		
		Intent objIntent = new Intent(getApplication(), MainActivity.class);
		
		startActivity(objIntent);
		
	}
	
}






