import java.util.ArrayList;
import java.util.Scanner;

/**
 * Allows the user to add FoodItems to an array and score the meal
 */
public class Meal {
    private ArrayList<FoodItem> meal;

    Scanner scan = new Scanner(System.in);

    public Meal () {
        this.meal = new ArrayList<>();
    }

    // Scores the meal based on 1pt = bread, 2pt = meat or Fruit, 3pt = vegetables
    public void scoreMeal () {
        int score = 0;

        for (FoodItem foodItem : meal) {
            score += foodItem.getPoints();
        }

        System.out.println("This meal score is: " + score);
    }

    // Method that receive an array of FoodItems witihn an Menu object to allow the user to select which dishes to add to the meal array. 
    public void createMeal (Menu menu) {
        System.out.println( '\n' + "Add food items to your meal. Type 'done' when finished");
        String input = "";

        while (!input.equals("done")) {
            System.out.print("Add to meal: ");
            input = scan.nextLine();

            if (input.equals("done")) {
                break;
            }

            int dishIndex = menu.findFoodItem(input);
            if (dishIndex == -1) {
                System.out.println("Sorry, that food item isn't on the menu!");
            } else {
                this.meal.add(menu.getFoodItem(dishIndex));
            }
        }

        this.displayMeal(); // Displays all food items that was added to the meal. 
    }

    // Display a list of all FoodItems within the meal array
    public void displayMeal () {
        System.out.println("List of Food Items in the Meal:");
        int count= 1;
        for(FoodItem item : meal) {
            System.out.println(count + ") " + item.getName());
            count++;
        }
    }
}
