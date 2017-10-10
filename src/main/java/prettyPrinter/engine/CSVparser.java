package prettyPrinter.engine;

import dnl.utils.text.table.TextTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVparser {
    private String path;
    private String line;
    private String[] rows;
    private String[] titles;
    private String[][] words;
    private StringBuilder stringBuilder;

    public CSVparser(String path) {
        this.path = path;
        line = "";
        this.stringBuilder = new StringBuilder();
    }

    public void parse() throws IOException {

        //read all *.csv into 1 String with adding \n for future splitting
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }

        //split by "\n"
        rows = stringBuilder.toString().split("\n");

        //titles for table
        titles = rows[0].split(";");

        //creating two-dimensional array
        words = new String[rows.length - 1][rows[0].split(";").length];
        for (int i = 0; i < rows.length - 1; i++) {
            for (int j = 0; j < rows[i].split(";").length; j++) {
                words[i][j] = rows[i + 1].split(";")[j];
            }
        }

        //creating table
        TextTable tt = new TextTable(titles, words);
        tt.printTable();
    }
}
