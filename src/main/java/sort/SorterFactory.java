package sort;

public class SorterFactory {
    public SorterFactory() {
    }

    public AbstractSorter createSorter(SortingStrategy strategy){

        if(strategy == SortingStrategy.BubbleSort)
            return new BubbleSorter();
        else
            if(strategy == SortingStrategy.QuickSort)
                return new QuickSorter();
       return null;
    }
    //singleton pattern
    private static SorterFactory instance = null;

    public static SorterFactory getInstance() {
        if(instance == null){
            instance = new SorterFactory();
        }
        return instance;
    }
}
