//food

public class Food{
  private final String name;
  private final Nutrition nutritionValue;
  
  public Food(String n, int g, int f, int p, int o, int c){
    this.name = n;
    int grain = (int)((double)(g/100) * c));
    int fv = (int)((double)(f/100) * c));
    int protein = (int)((double)(p/100) * c));
    int other = (int)((double)(o/100) * c));
    this.nutritionValue = new Nutrition(grain, protein, fv, other, c);
  }
}
