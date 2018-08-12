import java.io.*;
import java.util.ArrayList;

public class CsvReader {
    private double amount;
    public CsvReader(File file) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file.getAbsolutePath()));

        String text = "";
        ArrayList<String[]> splitTextArrays = new ArrayList<>();
        amount = 0;

        while (text != null) {
            splitTextArrays.add(text.split(","));
            text = in.readLine();
        }

        System.out.println(splitTextArrays.get(0)[0]);
            for (int i = 2; i < splitTextArrays.size(); i++) {
                double charge = 0.0;
                if (splitTextArrays.get(i).length > 1) {
                    charge = Double.parseDouble(splitTextArrays.get(i)[2]);
                }
                if (charge < 0) {
                    amount += charge;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public double getAmount() {
        return amount;
    }
}
