package run;
import container.Strategy;
import model.Task;
import model.SortingTask;
import sort.SortingStrategy;

public class TestSorting {
    public static void run(String arg){
        SortingStrategy strategy;
        try
        {
            strategy = SortingStrategy.valueOf(arg);
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid sorting strategy");
            return;
        }
        System.out.println("Sorting array 3,5,1,4,0");
        System.out.println("Sorting " + arg);
        int[] array = {3,5,1,4,0};
        SortingTask sortareT = new SortingTask("1", "Curs", array, strategy);
        sortareT.execute();
    }
}
