import java.util.ArrayList;

/**
 * Allows the user to add FoodItems to an array and displays the list when the user is ready to create a meal
 */
public class Menu {
    private ArrayList<FoodItem> courses;

    public Menu () {
        this.courses = new ArrayList<>(); // must have this to initlize the courses variable when the object is created
    }

    // Add a FoodItem object to the courses array
    public void addFoodItem (FoodItem item) {
        this.courses.add(item);
    }

    // Find & update the name/type of the FoodItem object within the courses array
    public void updateFoodItem (int index) {
        boolean successfullFoodCreation = this.courses.get(index).createFoodItem();
        
        // If someone typed "done" instead of the type of food, this remove it from the array.
        if(!successfullFoodCreation) {
            this.courses.remove(index);
        }
    }

    // Display a list of all FoodItems within the courses array
    public void displayCourses () {
        System.out.println("List of new Food Items:");
        int count= 1;
        for(FoodItem item : courses) {
            System.out.println(count + ") " + item.getName());
            count++;
        }
    }

    public int findFoodItem (String foodName) {
        int foundItem = -1;
        int index = 0;
        for (FoodItem dish : courses) {
            if (dish.getName().equals(foodName)) {
                foundItem = index;
            }
            index++;
        }
        
        return foundItem;
    }

    public FoodItem getFoodItem (int index) {
        return this.courses.get(index);
    }
}
