/**
 * filename: Reader.java
 * description: Takes a CSV datafile and converts it into an array of Rows
 * date: 01/09/19
 * @author Angelina Li
 *
 * NOTE: Do NOT modify this class.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Vector;
import java.util.HashMap;
import fastcsv.*;

/**
 * A utility class for reading in 
 */
public class Reader {

    //private final AdjListsGraph<Person> g;
    private final Map<String, Dog> nameMap;
    
    private final Vector<Dog> v;
    

    /**
     * Constructor for Reader class. 
     */
    public Reader(String dataFilepath) throws IOException {
        System.out.println("Reading in Dog dataset:");
        this.v = new Vector<Dog>();

        // reading nodes
        System.out.println("==> Reading in Dog objects...");
        CsvParser nodesParser = getParser(dataFilepath);
        CsvRow nodeRow;
        this.nameMap = new HashMap<String, Dog>();
        while ( (nodeRow = nodesParser.nextRow()) != null) {
            Dog dog = new Dog(
                nodeRow.getField("AnimalName"),
                nodeRow.getField("AnimalGender"),
                nodeRow.getField("AgeAsOf2015"),
                nodeRow.getField("BreedName"),
                nodeRow.getField("Borough")
            );
            v.add(dog);
            this.nameMap.put(dog.getData("AnimalName"), dog);
        }
        System.out.println("==> All done!");
    }

    /**
     * Given a filepath, will return a CsvParser that can be used to iterate 
     * over the rows of the dataset. Assumes that the file contains a header,
     * and that the data are in UTF_8 format.
     *
     * @throws IOException
     * @param filepath - the filepath to this file.
     * @return the parser over this file.
     */
    private static CsvParser getParser(String filepath) throws IOException {
        File file = new File(filepath);
        CsvReader reader = new CsvReader();
        reader.setContainsHeader(true);
        CsvParser parser = reader.parse(file, StandardCharsets.UTF_8);
        return parser;
    }

    /**
     * Returns all dogs in the vector
     * @return 
     */
    public Vector<Dog> getAllDogsVector() { 
        return this.v;
    }

    /**
     * Returns a mapping between names and Dogs
     * @return a Map between each name in the dataset and the Dog that name
     *         corresponds to.
     */
    public Map<String, Dog> getNameMap() {
        return this.nameMap;
    }
    
}
