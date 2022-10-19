package sort;

public class QuickSorter extends AbstractSorter{
    private int partition(int v[], int begin, int end){
        int pivot = v[end];
        int i = (begin-1);

        for(int j = begin; j < end; j++){
            if(v[j] <= pivot){
                i++;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        int aux = v[i+1];
        v[i+1] = v[end];
        v[end] = aux;
        return i+1;
    }
    public void quickSort(int v[], int begin, int end){
        if(begin<end){
            int paritionIndex = partition(v,begin,end);

            quickSort(v,begin, paritionIndex - 1);
            quickSort(v, paritionIndex+1, end);
        }
    }
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length);
    }
}
