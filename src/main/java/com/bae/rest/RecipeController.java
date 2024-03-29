package com.bae.rest;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Category;
import com.bae.persistence.domain.Ingredients;
import com.bae.persistence.domain.Recipe;
import com.bae.service.RecipeService;

@RestController
@CrossOrigin("*")
public class RecipeController {
	
	private RecipeService recService;
	
	@Autowired
	public RecipeController (RecipeService recService) {
		super();
		 this.recService = recService;
	}
	
	@PostMapping("/createRecipe")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
	return this.recService.createRecipe(recipe);
	}
	
	@DeleteMapping("/deleteRecipe/{id}")
	public void deleteRecipeById(@PathVariable int id) {
		this.recService.deleteRecipeById(id);
	} 
	
	@GetMapping("/getRec/{id}")
	public Recipe getRecipe(@PathVariable int id) {
		return this.recService.findRecipeById(id);
}
	@GetMapping("/getAllRec")
	public List<Recipe> getAllRecipes(){
		return this.recService.getAllRecipes();
	}
	
	@PutMapping("/updateRecipe")
	public Recipe updateRecipe(@PathParam("id") int recipeId, @RequestBody Recipe recipeToUpdate) {
	
		return this.recService.updateRecipe(recipeToUpdate, recipeId);
	}
	
	@PatchMapping("/attachIngredient/{id}")
	public Recipe addIngredientToRecipe(@PathVariable int id, @RequestBody Collection<Ingredients> ingredient) {
		return this.recService.updateRecipeWithIngredients(id, ingredient);
	}
	
	@PatchMapping("/attachCategory/{id}")
	public Recipe addCategoryToRecipe(@PathVariable int id, @RequestBody Collection<Category> category) {
		return this.recService.updateRecipeWithCategories(id, category);
	}
}
