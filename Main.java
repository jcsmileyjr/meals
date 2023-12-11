import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Meal Planner and Scorer application 
 * App that allows the user to create and plan a meal that is given a "Health" score based on types of food used. 
 */
public class Main {    
    public static void main(String[] args) {
        System.out.println("Meal Planner and Scorer ");
        System.out.println("Create different food items to include in your meal.");
        
        Menu courses = new Menu(); // Array of FoodItems
        Scanner scan = new Scanner(System.in);
        String input = ""; // user input data
        int count = 0; // Allow access to food item with the Menu

        // Loop that allows the user to create food items and place them into an menu (array of FoodItems)
        while(!input.equals("done")) {
            courses.addFoodItem(new FoodItem()); // add the FoodItem to the array
            courses.updateFoodItem(count); // Ask the user for the name and type of the new food item
            count++;
            System.out.println("Type 'done' if you are finish or type 'y' to create another food item");
            input = scan.next();
        }
        
        courses.displayCourses();

        // Create a loop that allows the user to add food items (from the list) to a Meal
        Meal meal = new Meal();
        meal.createMeal(courses);

        // When the above loop is finished, display the score
        meal.scoreMeal();

        scan.close();
    }
}
