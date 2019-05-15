/**
 * filename: Dog.java
 */

import java.util.HashMap;
import java.util.Map;


public class Dog {
    
    private final Map<String, String> dogData;

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
        this.dogData = new HashMap<String, String>();
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
     * @return requested data value for this Dog instance.
     */
    public final String getData(String variable) {
        return this.dogData.get(variable);
    }

    @Override
    public boolean equals(Object obj) {
        if ( ! (obj instanceof Dog)) { return false; }
        final Dog that = (Dog) obj;
        return this.dogData.equals(that.dogData);
    }

    @Override
    public int hashCode() {
        return this.dogData.hashCode();
    }

    @Override
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