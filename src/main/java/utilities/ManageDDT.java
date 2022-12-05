package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {


   @DataProvider(name = "data-provider" )
    public Object[][] getDataObject() {
        return getDataFromCsv("./DDTFiles/csvData");
    }

    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return lines;
    }

    public static Object[][] getDataFromCsv(String filepath) {
        Object[][] data = new Object[2][2];
        List<String> csvData = readCSV(filepath);
        for (int i = 0; i < csvData.size(); i = i + 1) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

}


