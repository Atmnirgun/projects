import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Recipe } from '../recipe.model'
@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  @Output() recipeWasSelected = new EventEmitter<Recipe>();
  recipes : Recipe[] = [
    new Recipe("A test recipe","this is simply a test","https://ap-south-1-02840027-view.menlosecurity.com/c/0/i/aHR0cHM6Ly91cGxvYWQud2lraW1lZGlhLm9yZy93aWtpcGVkaWEvY29tbW9ucy8xLzE1L1JlY2lwZV9sb2dvLmpwZWc~"),
    new Recipe("A test recipe","this is simply a test","https://ap-south-1-02840027-view.menlosecurity.com/c/0/i/aHR0cHM6Ly91cGxvYWQud2lraW1lZGlhLm9yZy93aWtpcGVkaWEvY29tbW9ucy8xLzE1L1JlY2lwZV9sb2dvLmpwZWc~"),
    new Recipe("A test recipe","this is simply a test","https://ap-south-1-02840027-view.menlosecurity.com/c/0/i/aHR0cHM6Ly91cGxvYWQud2lraW1lZGlhLm9yZy93aWtpcGVkaWEvY29tbW9ucy8xLzE1L1JlY2lwZV9sb2dvLmpwZWc~")
  ]

  constructor() { }

  ngOnInit() {
  }

  onRecipeSelected(recipe:Recipe){
    this.recipeWasSelected.emit(recipe);
  }

}
