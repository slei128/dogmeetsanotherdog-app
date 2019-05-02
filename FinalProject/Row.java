/**
 * filename: Row.java
 * description: Initializes Row class
 * date: 01/09/19
 * @author Angelina Li
 *
 * NOTE: Do NOT modify this class.
 */

import java.util.HashMap;


public class Row {
    
    private final String name,sex,breed,borough;
    private int age;

    /**
     * Constructor for Row class. 
     * Each Row represents data on the city-year level.
     */
    public Row(
        String name,
        String sex,
        int age,
        String breed,
        String borough
    ) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.breed = breed;
        this.borough = borough;
    }

    /**
     * Getter method for name variable.
     * @return name data for this Row instance.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Getter method for state variable.
     * @return state data for this Row instance.
     */
    public final String getSex() {
        return this.sex;
    }

    /**
     * Getter method for year variable.
     * @return year data for this Row instance.
     */
    public final int getAge() {
        return this.age;
    }
    
    public final String getBreed() {
        return this.breed;
    }
    
    public final String getBorough() {
        return this.borough;
    }
    
    /**
     * Returns a String representing all the data in this Row instance.
     @return a String representation of this Row.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("name=" + this.name + ", ");
        sb.append("sex=" + this.sex + ", ");
        sb.append("age=" + this.age + ",");
        sb.append("breed=" + this.breed + ",");
        sb.append("borough=" + this.borough);
        sb.append("}\n");
        return sb.toString();
    }
}