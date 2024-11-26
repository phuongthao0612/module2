import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("src/countries.csv"));

            while ((line = br.readLine()) != null) {
                Country country = parseCsvLine(line);
                printCountry(country);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Country parseCsvLine(String csvLine) {
        if (csvLine != null && !csvLine.isEmpty()) {
            String[] splitData = csvLine.split(",");
            if (splitData.length == 3) {
                return new Country(Integer.parseInt(splitData[0]), splitData[1], splitData[2]);
            }
        }
        return null;
    }

    private static void printCountry(Country country) {
        if (country != null) {
            System.out.println(country);
        }
    }
}