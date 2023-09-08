import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generate {

    public static void main(String[] args) {
        String file = "src/TestData.txt";
        try (BufferedWriter rn = new BufferedWriter(new FileWriter((file)))){
            Random random = new Random();
            int mag = random.nextInt(10000);
            rn.write(Integer.toString(mag));
            rn.newLine();
            int i = 0;
            while(i < mag){
                int group = random.nextInt(10000);
                rn.write(Integer.toString(group));
                rn.write(" ");
                i++;
            }
            System.out.println("Succeeded!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
