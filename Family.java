/* 
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

//public class famile which uses the interface Calculate
public class Family implements Calculate{
  private final Nutrition TOTAL;
  private int[] ID;
  private int[][] calorieData; 
  
  //family constructor 
  /*
  * @param int[] ID
  * @param int[][] caloricInfo
  */
  public Family(int[] ID, int[][] caloricInfo){
    this.ID = ID;
    this.calorieData = caloricInfo; 
    this.TOTAL = calculateContent(); //same inconsistnecy as below, sorry Tina
  }
  
  /*
  * @param int index
  */
  // public method getID which returns the String for the given index of a person
  public String getID(int index){
	  StringBuilder build = new StringBuilder();
    //returns either ID numbers or the actual names(ex.adult male) as string
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
  
  //getter for TOTAL, returns a nutrition object
  public Nutrition getTotal(){
    return this.TOTAL;
  }
  
  @Override
  public Nutrition calculateContent(){ //interface method 
    //using conventions g, p, f, o, c 
    int totalGrain = 0; 
    int totalProtein = 0;
    int totalFV = 0;
    int totalOther = 0;
    int totalCalories = 0;
    int i = 1;
    int index = 0;
    while (i != 5){
      if (this.ID[index] != 0){
        
        int c = this.calorieData[i-1][5];
        int g = this.calorieData[i-1][1];
	int f = this.calorieData[i-1][2];
        int p = this.calorieData[i-1][3];
        int o = this.calorieData[i-1][4];
      
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
