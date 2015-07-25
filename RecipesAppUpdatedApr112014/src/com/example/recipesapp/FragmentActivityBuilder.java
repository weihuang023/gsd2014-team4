package com.example.recipesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class FragmentActivityBuilder extends FragmentActivity {
	
	protected abstract Fragment createFragment();
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_recipe_app);

		FragmentManager fragManager = getSupportFragmentManager();
		
		
		
		Fragment theFragment = fragManager.findFragmentById(R.id.fragmentContainer);
		
		
		
		if(theFragment == null){
			
			
			
			theFragment = new RecipeFragment();
			
			
			fragManager.beginTransaction()
				.add(R.id.fragmentContainer, theFragment)
				.commit();
			
		}
	}

	
}
