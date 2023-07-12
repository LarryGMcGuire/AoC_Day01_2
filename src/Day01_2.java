import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day01_2 {

    // Advent of Code 2022 Day 1   Part 2
    //  Read about the problem here  https://adventofcode.com/2022/day/1#part2
    public static void main(String[] args) throws IOException, FileNotFoundException{
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        File inputTxt = new File("Day01_2/src/2022/day01/input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputTxt));

        String string;
        int calories = 0;
        int caloriesFirst = 0, caloriesSecond= 0, caloriesThird= 0;
        ArrayList<Integer> caloriesList = new ArrayList<>();

        while ((string = input.readLine()) != null){
            if (string.isEmpty()){
                caloriesList.add(calories);
                calories = 0;
            }
            else {
                calories += Integer.parseInt(string);
            }
        }
        input.close();

        for (int i = 0; i<caloriesList.size(); i++){
            if (caloriesFirst < caloriesList.get(i)){
                caloriesThird = caloriesSecond;
                caloriesSecond = caloriesFirst;
                caloriesFirst = caloriesList.get(i);
            }
            else if (caloriesFirst > caloriesList.get(i) && caloriesSecond < caloriesList.get(i)){
                caloriesThird = caloriesSecond;
                caloriesSecond = caloriesList.get(i);
            }
            else if (caloriesFirst > caloriesList.get(i) && caloriesSecond > caloriesList.get(i) && caloriesThird < caloriesList.get(i))
            {
                caloriesThird = caloriesList.get(i);
            }
        }
        System.out.println(caloriesFirst);
        System.out.println(caloriesFirst+caloriesSecond+caloriesThird);


    }

}
