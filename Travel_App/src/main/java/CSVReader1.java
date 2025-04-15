import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader1 {
    public static void main(String[] args) {
        CSVReader csvReader1 = null;

        try {
            csvReader1 = new CSVReaderBuilder( new FileReader( "./travel.csv") ).build();

            List<String[]> lines = csvReader1.readAll();

            for (String[] line : lines) {
                System.out.println( line[0] + "\t" + line[1] + "\t" + line[2] + "\t" + line[3]);
            }

        } catch (FileNotFoundException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (CsvException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } finally {
            if ( csvReader1 != null ) try { csvReader1.close(); } catch (IOException e) { }
        }
    }
}
