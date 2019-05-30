import java.io.*;
import java.util.Scanner;

public class Ranking {
    String fileName = "C:\\Users\\simen\\Documents\\A Studier\\SKKU Studier\\Java Lab\\Prosjekt2\\src\\highscore.txt"; //change to wherever the file is

    public void displayScore() {
        String line = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("\n       HIGHSCORE\n************************");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            System.out.println("Unable to access highscore-file.");
            e.printStackTrace();
        }
    }

    public void appendScore(String player1, String player2, int moves) { //pass the WINNER as player1!!!!
        String line = "";
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(player1 + " beat " + player2 + " in " + moves + " moves.");
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println("Unable to access highscore-file.");
            e.printStackTrace();
        }
    }

    public void resetScore() { //works by deleting the file and creating a new one
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
