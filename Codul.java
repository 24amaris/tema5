import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Interval {
    private double start, end;
    private int total = 0, inside = 0; 

    public Interval(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public void test(double number) {
        total++; 
        if (number >= start && number <= end) inside++;
    }

    public double percentage() {
        return total == 0 ? 0 : (double) inside / total * 100;
    }

    public String toString() {
        return "[" + start + ", " + end + "]: " + percentage() + "%";
}

public class Codul {
    public void main(String[] args) 
    {
        String intervalsFile = "intervale.dat"; 
        String numbersFile = "numere.dat"; 
        String outputFile = "statistica.dat";

        List<Interval> intervalList = new ArrayList<>();

        try (BufferedReader intervalReader = new BufferedReader(new FileReader(intervalsFile)); 
             BufferedReader numberReader = new BufferedReader(new FileReader(numbersFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) 
        {
            for (Interval interval : intervalList) 
            {   
                writer.write(interval.toString()); 
                writer.newLine();
            }

        } catch (IOException e) { 
            System.out.println("Eroare la citirea sau scrierea fișierelor: " + e.getMessage()); 
        } catch (NumberFormatException e) { 
            System.out.println("Eroare: Numărul nu poate fi parsat: " + e.getMessage()); 
        }
    }
}}