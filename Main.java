import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        try {
            BufferedReader in = new BufferedReader(new FileReader("statement.csv"));
            String text = "";
            ArrayList<String[]> splitTextArrays = new ArrayList<>();
            double amount = 0;

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

            System.out.println("You have spent $" + Math.round(amount*100.0)/100.0 + " this year.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
