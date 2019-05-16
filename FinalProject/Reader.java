/**
 * Takes a CSV datafile and converts it into data rows 
 * (created based on Reader by Angelina Li from Problem Set 6)
 * 
 * @author (Shirley Lei, Willa Sun, Emily Yin)
 * @version (16 May 2019)
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Vector;
import java.util.HashMap;
import fastcsv.*;
public class Reader {
    //declare empty FilterableDataset to hold the data 
    private final FilterableDataset data;
    /**
     * Constructor reads in data from a given filepath 
     * @param filepath the path to the file containing the data
     * @throws IOException
     * 
     */
    public Reader(String filepath) throws IOException {
        this.data = new FilterableDataset();

        File file = new File(filepath);
        CsvReader reader = new CsvReader();
        reader.setContainsHeader(true);
        //System.out.println("Reading in Dog dataset:");
        
        try (CsvParser parser = reader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow dataRow;
            //while next row
            while  ((dataRow = parser.nextRow()) != null) {
                //get data in the fields of the row
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
                //add the read row into the data
                data.add(row);
            }
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

    /**
     * Helper method to get the integer field (for getting Age of the dog)
     *
     * @param row - the row we are trying to get the age from.
     * @param field - the data field
     * @return the integer that is the content of the field
     */
    private static int getIntField(CsvRow row, String field) {
        return Integer.parseInt(row.getField(field));
    }

    /**
     * Returns the data created from reading the dataset
     * @return the data created from reading the dataset.
     */
    public final FilterableDataset getDataset() {
        //System.out.println(this.data);
        return this.data;
    }
}
