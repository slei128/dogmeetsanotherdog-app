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
    //private final Map<String, Dog> nameMap;
    private final FilterableDataset data;
    //private final Vector<Dog> v;
    

    /**
     * Constructor for Reader class. 
     */
    public Reader(String filepath) throws IOException {
        this.data = new FilterableDataset();

        File file = new File(filepath);
        CsvReader reader = new CsvReader();
        reader.setContainsHeader(true);
        //System.out.println("Reading in Dog dataset:");
        //this.v = new Vector<Dog>();

        // reading nodes
        /*
        System.out.println("==> Reading in Dog objects...");
        CsvParser nodesParser = getParser(dataFilepath);
        CsvRow nodeRow;
        this.nameMap = new HashMap<String, Dog>();
        */
       try (CsvParser parser = reader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow dataRow;
            //int currentNumberRows = 0;
            while  ((dataRow = parser.nextRow()) != null) {
                Row row = new Row(
                dataRow.getField("FullName"),
                dataRow.getField("AnimalGender"),
                getIntField(dataRow,"AgeAsOf2015"),
                dataRow.getField("BreedName"),
                dataRow.getField("Borough"),
                dataRow.getField("Size"),
                dataRow.getField("AreaCode"),
                dataRow.getField("PhoneNum") 
            );
            //v.add(dog);
            data.add(row);
            //currentNumberRows ++;
            //this.nameMap.put(dog.getData("AnimalName"), dog);
        }
        System.out.println("==> All done!");
    }
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

    private static int getIntField(CsvRow row, String field) {
        return Integer.parseInt(row.getField(field));
    }
    
    // /**
     // * Returns all dogs in the vector
     // * @return 
     // */
    // public Vector<Dog> getAllDogsVector() { 
        // return this.v;
    // }

    // /**
     // * Returns a mapping between names and Dogs
     // * @return a Map between each name in the dataset and the Dog that name
     // *         corresponds to.
     // */
    // public Map<String, Dog> getNameMap() {
        // return this.nameMap;
    // }
    
    /**
     * Returns the current filterableDataset created
     * @return a Map between each name in the dataset and the Dog that name
     *         corresponds to.
     */
    public final FilterableDataset getDataset() {
        //System.out.println(this.data);
        return this.data;
    }
}
