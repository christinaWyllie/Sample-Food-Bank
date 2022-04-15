/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: Family.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.12
@since 1.0
 */
package edu.ucalgary.ensf409;

/**
 * Family is a public class that organizes the nutritional requirements for family
 * members that were specified. This class uses the Nutrition class to contain 
 * information and utilizes and stores the user input given by the GUI. The Family class
 * requires the daily requirements for each person that is given in the DataBase and 
 * implements the Calculate interface to turn percentage values into actual calorie
 * amounts.
*/
public class Family implements Calculate{
  private final Nutrition TOTAL; //Total nutritional needs of family 
  private int[] ID; //Holds given user input
  private int[][] calorieData; //Daily nutritional needs (originally taken from DataBase)
  

 /**
  * SoleFamily constructor that takes an array of ID numbers inputted in 
  * the GUI and the table containing percentages of daily caloric needs for all
  * types of clients that has been read from the database.
  * 
  * @param ID 	integer array that is the user inputted family 
  * @param caloricInfo	daily nutritional needs of adult male/female and child over/under 8
  */
  public Family(int[] ID, int[][] caloricInfo){
    this.ID = ID;
    this.calorieData = caloricInfo; 
    this.TOTAL = calculateContent(); //Calculates total nutrition value for entire family 
  }
  
/**
 * getID() is a public method which returns the ID array that was specified
 * in the constructor. 
 * 
 * @return 	the original user inputted array 
 */
  public int[] getID(){
	  return this.ID;
  }
  
 /**
  * This method is a public method that returns the string that corresponds
  * for a given index relating to a type of client. This method
  * helps for formatString method in OrderForm class.
  * 
  * @param index	 used to access index of ID array
  * @return 	the type of member depending on index - 0 = Adult Male, 1 = Adult Female, 2 = Child over 8, 3 = Child Under 8
  *
  */
  public String getIDAtIndex(int index){
	StringBuilder build = new StringBuilder();
	if(ID[index] != 0){
		build.append(ID[index]);
		if(index == 0){
			build.append(" Adult Male");
		}
		else if(index ==1){
			build.append(" Adult Female");
		}
		else if(index ==2){
			build.append(" Child over 8");
		}
		else{
			build.append(" Child under 8");
		}
	}
	
	return build.toString();
  }
  
 /**
  * This method is a getter method for TOTAL, which is a nutriton object
  * containing the weekly caloric needs of the entire family. This 
  * method returns a nutrition object.
  * 
  * @return 	total nutrition object
  */
  public Nutrition getTotal(){
    return this.TOTAL;
  }
  
  /**
   * This method overrides the calculateContent method in the Calculate interface
   * and uses the caloric information specialized from the database for each type
   * of client, and uses the information about the family to calculate the 
   * number of calories needed by the entire family per category for an 
   * entire week.
   * 
   * @return 	returns a nutrition object that contains weely caloric needs of the family.
   */
  @Override
  public Nutrition calculateContent(){ //Overrides the calculateContent method in Calculate interface 
    //using conventions g, f, p, o, c 
    int totalGrain = 0; 
    int totalProtein = 0;
    int totalFV = 0;
    int totalOther = 0;
    int totalCalories = 0;
    int i = 0;
    int index = 0;
    while (i < 4){
      if (this.ID[index] != 0){
        
        int c = this.calorieData[i][5];
        int g = this.calorieData[i][1];
        int f = this.calorieData[i][2];
        int p = this.calorieData[i][3];
        int o = this.calorieData[i][4];
      
      // to calculate the total contents. 
	  // the code adds to the existing total contents for each category
	  // by dividing the percentage by 100 to get the decimal value
	  // then by multiplying the decimal value by the total calories needed per person
	  // and then by how many people of that type are in the hamper. 
        totalGrain += (int)((g/100.0)*c * this.ID[index]); 
        totalProtein += (int)((p/100.0)*c * this.ID[index]);
        totalFV += (int)((f/100.0)*c * this.ID[index]);
        totalOther += (int)((o/100.0)*c * this.ID[index]);
        totalCalories += (c* this.ID[index]);
       
      }
      i++;
      index++;
    }
    Nutrition n = new Nutrition(totalGrain*7, totalFV*7, totalProtein*7, totalOther*7, totalCalories*7);
	// send the values to nutrition and multiply by 7 to get the total nutrition for a week.
    return n;
  }
  
}
