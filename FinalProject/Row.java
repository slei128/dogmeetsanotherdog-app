/**
 * Initializes the Row class. 
 * Note: Modified from Angelina Li. 
 * 
 * @author Shirley Lei, Willa Sun, Emily Yin
 * @version May 15 2019
 */

import java.util.HashMap;


public class Row {
    
    private final String name,sex,breed,borough,size,area,phone;
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
        String borough,
        String size,
        String area,
        String phone
    ) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.breed = breed;
        this.borough = borough;
        this.size = size;
        this.area = area;
        this.phone = phone;
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
    
    public final String getSize() {
        return this.size;
    }
    
    public final String getArea() {
        return this.area;
    }
    
    public final String getPhone() {
        return this.phone;
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
        sb.append("size=" + this.size);
        sb.append("}\n");
        return sb.toString();
    }
}