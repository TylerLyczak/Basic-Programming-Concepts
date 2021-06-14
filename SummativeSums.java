import java.util.ArrayList;

public class SummativeSums {

    public static void main(String[] args)  {

        // Arraylist to store all the list from args
        ArrayList<ArrayList<Integer>> argList = new ArrayList<>();

        // Make a temp list to store ints from the given args lists
        ArrayList<Integer> tempList = new ArrayList<>();

        // Loop through each string in args
        for (String s: args)    {

            // If its the end of a list, add the list to the master list and remake the temp list
            if (s.equals("}")) {
                argList.add(tempList);
                tempList = new ArrayList<>();
            }
            // If its not a {, convert the int string into an int and add it to the temp list
            else if (!s.equals("{"))    {
                s = s.replace(",", "").replace(" ", "");
                int temp = Integer.parseInt(s);
                tempList.add(temp);
            }
        }

        // Loop over the list of lists, add up the ints in each separate list and display the sums
        int index = 0;
        for (ArrayList<Integer> ls : argList)   {
            int sum = 0;
            for (int i : ls)    {
                sum+=i;
            }
            System.out.printf("#%s Array Sum: %s%n", index, sum);
        }
    }
}
