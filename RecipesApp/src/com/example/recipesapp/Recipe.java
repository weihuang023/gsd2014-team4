package com.example.recipesapp;

import java.util.UUID;

import android.util.Log;

public class Recipe {

	private String name;
	private String ingredients;
	private String instruction;
	private UUID idNumber;
	private boolean mostvisted = false;
	
	public Recipe(){
		idNumber = UUID.randomUUID();
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Log.e("RECIPE", "NAME CHANGE TO" + name);
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		Log.e("RECIPE", "INGRENDIENTS CHANGE TO" + ingredients);
		this.ingredients = ingredients;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		Log.e("RECIPE", "INSTRUCTION CHANGE TO" + instruction);

		this.instruction = instruction;
	}
	//save data

	public boolean getMostvisted() {
		return mostvisted;
	}

	public void setMostvisted(boolean mostvisted) {
		this.mostvisted = mostvisted;
	}

	public UUID getIdNumber() {
		return idNumber;
	}
	
}
