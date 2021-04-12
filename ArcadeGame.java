package org.sla;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;


public class ArcadeGame extends ElectronicGame {

    private Double RevWithoutInf;
    private Double RevWithInf;

    public ArcadeGame(int releaseDate, String gameTitle, int amountSold, double RevWithoutInf, double RevWithInf) {
        super(releaseDate, gameTitle, amountSold);

        this.RevWithoutInf = RevWithoutInf;
        this.RevWithInf = RevWithInf;
    }

    public Double getRevWithoutInf() {
        return RevWithoutInf;
    }

    public void setRevWithoutInf(Double revWithoutInf) {
        RevWithoutInf = revWithoutInf;
    }

    public Double getRevWithInf() {
        return RevWithInf;
    }

    public void setRevWithInf(Double revWithInf) {
        RevWithInf = revWithInf;
    }

    public String toString() {
        String description = "\"" + this.getGameTitle() + "\"" ;
        description = description + " was released in " + this.getReleaseDate();
        description = description + " It sold" + " " + this.getAmountSold() + " " + "units.";
        String FormatRev = new BigDecimal(this.getRevWithoutInf()).toPlainString();
        description = description + "The revenue without inflation was" + " " + FormatRev + ".";
        String Formatrev = new BigDecimal(this.getRevWithInf()).toPlainString();
        description = description + " " + "The revenue with inflation was" + " " + Formatrev()+ ".";
        return description;
    }
        static void read(String dataFilePath) {
            // try to create Scanner
            Scanner scanner = null;
            try {
                File file = new File(dataFilePath);
                scanner = new Scanner(file);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Problem opening file: " + dataFilePath);
            }
            if (scanner == null) {
                // I can't scan without a scanner, so we're done.
                return;
            }

            // Read from each line in data file until there are no more
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                // Construct a new scanner for each to get its tokens
                Scanner lineScanner = new Scanner(next);
                // Data tokens are separated by tabs
                lineScanner.useDelimiter("\t");


                String title = lineScanner.next();

                int year = lineScanner.nextInt();
                String next1 = lineScanner.next().trim();
                int unitsSold = Integer.parseInt(next1);
                long revwithoutint = 0;
                long revwithint = 0;

                if(lineScanner.hasNext()) {
                    String revString = lineScanner.next();
                    if (revString.contains("billion")) {
                        int Spacelocation = revString.indexOf(" ");
                        String numString = revString.substring(0, Spacelocation);
                        float numfloat = Float.parseFloat(numString);
                        numfloat = numfloat * 1000000000;
                        Float myFloat = new Float(numfloat);
                        revwithoutint = myFloat.longValue();
                    } else if (revString.contains("million")) {
                        int Spacelocation = revString.indexOf(" ");
                        String numString = revString.substring(0, Spacelocation);
                        float numfloat = Float.parseFloat(numString);
                        numfloat = numfloat * 1000000;
                        Float myFloat = new Float(numfloat);
                        revwithoutint = myFloat.longValue();
                    }

                    String revwithString = lineScanner.next();
                    if (revwithString.contains("billion")) {
                        int spacelocation = revwithString.indexOf(" ");
                        String numbString = revwithString.substring(0, spacelocation);
                        float numbfloat = Float.parseFloat(numbString);
                        numbfloat = numbfloat * 1000000000;
                        Float MyFloat = new Float(numbfloat);
                        revwithint = MyFloat.longValue();

                    } else if (revwithString.contains("million")) {
                        int spacelocation = revwithString.indexOf(" ");
                        String numbString = revwithString.substring(0, spacelocation);
                        float numbfloat = Float.parseFloat(numbString);
                        numbfloat = numbfloat * 1000000;
                        Float MyFloat = new Float(numbfloat);
                        revwithint = MyFloat.longValue();

                    }
                }



                ElectronicGame games = new ArcadeGame( year, title, unitsSold, revwithoutint, revwithint);
                System.out.println(games);
            }
    }
}
