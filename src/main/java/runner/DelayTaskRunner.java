package runner;

public class DelayTaskRunner extends AbstractTaskRunner{
    public DelayTaskRunner(TaskRunner runner) {
        super(runner);
    }
    @Override
    public void executeOneTask() {
        runner.executeOneTask();
        delayTaskRunner();
    }

    private void delayTaskRunner(){
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
