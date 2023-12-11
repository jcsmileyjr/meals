import java.util.Scanner;

public class FoodItem {
    private String type;
    private String name;
    private int points;

    Scanner scan = new Scanner(System.in);

    public int getPoints () {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if (type.equals("meat")) {this.points = 2;}
        if (type.equals("vegetable")) {this.points = 2;}
        if (type.equals("bread")) {this.points = 1;}
        if (type.equals("fruit")) {this.points = 3;}
    }

    // Method to allow a user to create food item by setting its Name and Type
    public boolean createFoodItem() {
        System.out.print("What is the name of the food item? ");
        String foodName = scan.nextLine();
        setName(foodName);

        String input = "";

        while(!input.equals("done")) {
            System.out.println("What type of food is it: Meat, Bread, Vegetable, Fruit. Type 'done' if you can't decide.");
            input = scan.nextLine().toLowerCase();

            if(input.equals("meat") || input.equals("bread") || input.equals("fruit") || input.equals("vegetable")) {
                setType(input);
                break;
            } else {
                System.out.println("Thats an incorrect food type.");
            }            
        }

        System.out.println("Food points: " + this.points);
        
        // This helps people get out of adding an food item.
        if (input.equals("done")) {
            return false;
        } else {
            return true;
        }
    }
}