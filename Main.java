

public class Main {
    public static void main(String[] args) {
        FileOpener openFile = new FileOpener("csv");
        openFile.findFile();
        CsvReader reader = new CsvReader(openFile.getSelectedFile());
        System.out.println("You have spent $" + Math.round(reader.getAmount()*100.0)/100.0 + " "
                                           + "this year.");

    }
}
