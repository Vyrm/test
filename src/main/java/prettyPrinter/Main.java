package prettyPrinter;

import prettyPrinter.engine.CSVparser;

import java.io.IOException;

public class Main {
    private static final String PATH = "D:\\Java\\GlobalLogic\\src\\main\\resources\\file.csv";

    public static void main(String[] args) throws IOException {
        CSVparser csVparser = new CSVparser(PATH);
        csVparser.parse();
    }
}
