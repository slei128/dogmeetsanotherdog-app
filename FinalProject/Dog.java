/**
 * The Dog class represents a dog, with characteristics such as age, name, sex, etc. 
 * It provides getter method to get these data about the dog.
 *
 * @author (Shirley Lei, Willa Sun, Emily Yin)
 * @version (16 May 2019)
 */

import java.util.HashMap;
import java.util.Map;

public class Dog {
    //create an empty map of dogData to be populated
    private final Map<String, String> dogData;
    
    /**
     * Constructor for Dog, which creates a Dog with specified values for the variables.
     * 
     * @param name name of dog
     * @param sex sex of dog
     * @param age age of dog
     * @param breed breed of dog
     * @param location borough/location of dog
     * @param size size of dog
     * @param area area code of dog
     * @param phone phone number of dog
     */
    public Dog(
        String name,
        String sex,
        Integer age,
        String breed,
        String location,
        String size,
        String area,
        String phone
    ) {
        //start a new hashmap to put specified values in
        this.dogData = new HashMap<String, String>();
        //put in specified values
        this.dogData.put("name", name);
        this.dogData.put("sex", sex);
        this.dogData.put("age", Integer.toString(age));
        this.dogData.put("breed", breed);
        this.dogData.put("location", location);
        this.dogData.put("size",size);
        this.dogData.put("area",area);
        this.dogData.put("phone",phone);
    }

    /**
     * Getter method for data variable.
     * @variable the variable to get (e.g. name or age)
     * @return requested data value for this Dog instance.
     */
    public final String getData(String variable) {
        return this.dogData.get(variable);
    }
    
    /**
     * String representation of an object of Dog class.
     * @Override
     * @return a string of information about the dog
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dog {");
        sb.append("\n\tname=" + this.getData("name"));
        sb.append("\n\tsex=" + this.getData("sex"));
        sb.append("\n\tage=" + this.getData("age"));
        sb.append("\n\tbreed=" + this.getData("breed"));
        sb.append("\n\tlocation=" + this.getData("location"));
        sb.append("\n\tsize=" + this.getData("size"));
        sb.append("\n\tarea=" + this.getData("area"));
        sb.append("\n\tphone=" + this.getData("phone"));
        sb.append("\n}");
        return sb.toString();
    }
}