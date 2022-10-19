package model;
import sort.AbstractSorter;
import sort.SortingStrategy;
import sort.SorterFactory;

public class SortingTask extends Task{
    private int[] array;
    private AbstractSorter sorter;

    public SortingTask(String taskId, String description, int[] array, SortingStrategy strategy) {
        super(taskId, description);
        this.array = array;
        this.sorter = SorterFactory.getInstance().createSorter(strategy);
    }

    @Override
    public void execute() {
        this.sorter.sort(array);
        for(int i =0; i< array.length; i++)
            System.out.print(array[i]+" ");
    }
}
