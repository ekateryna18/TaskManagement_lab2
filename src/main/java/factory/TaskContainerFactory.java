package factory;

import container.Container;
import container.QueueContainer;
import container.StackContainer;
import container.Strategy;
import sort.SorterFactory;

public class TaskContainerFactory implements Factory {

    public TaskContainerFactory() {
    }
    // TO DO : Singleton
    public static TaskContainerFactory instance = null;

    public static TaskContainerFactory getInstance() {
        if(instance == null){
            instance = new TaskContainerFactory();
        }
        return instance;
    }

    @Override
    public Container createContainer(Strategy strategy) {
        if(strategy==Strategy.LIFO) {
            return new StackContainer();
        }
        else if(strategy==Strategy.FIFO) {
            return new QueueContainer();
        }
        return null;
    }
}
