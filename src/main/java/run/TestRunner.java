package run;

import container.Strategy;
import model.MessageTask;
import runner.DelayTaskRunner;
import runner.PrinterTaskRunner;
import runner.StrategyTaskRunner;
import sort.SortingStrategy;

import java.time.LocalDateTime;

public class TestRunner {
    public static MessageTask[] getMessages() {
        MessageTask taskLaborator = new MessageTask(
                "1","Seminar", "tema laborator",
                "Florentin", "Razvan", LocalDateTime.now());
        MessageTask taskTema = new MessageTask(
                "2","Laborator", "Solutie",
                "Razvan", "Florentin", LocalDateTime.now());
        MessageTask taskNota = new MessageTask(
                "3","Nota Lab", "10",
                "Florentin", "Razvan", LocalDateTime.now());
        return new MessageTask[]{
                taskLaborator, taskTema, taskNota
        };
    }

    public static void run(String arg) {
        Strategy strategy;
        try
        {
            strategy = Strategy.valueOf(arg);
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid strategy");
            return;
        }
        //via StrategyTaskRunner
        /*StrategyTaskRunner runner = new StrategyTaskRunner(strategy);
        MessageTask[] messages = getMessages();
        runner.addTask(messages[0]);
        runner.addTask(messages[1]);
        runner.addTask(messages[2]);
        runner.executeAll();*/

        //via DelayTaskRunner
        StrategyTaskRunner runner = new StrategyTaskRunner(strategy);
        DelayTaskRunner delay = new DelayTaskRunner(runner);

        MessageTask[] messages = getMessages();
        delay.addTask(messages[0]);
        delay.addTask(messages[1]);
        delay.addTask(messages[2]);
        delay.executeAll();

        //via PrinterTaskRunner
        /*StrategyTaskRunner runner = new StrategyTaskRunner(strategy);
        DelayTaskRunner delay = new DelayTaskRunner(runner);
        PrinterTaskRunner printer = new PrinterTaskRunner(delay);

        MessageTask[] messages = getMessages();
        printer.addTask(messages[0]);
        printer.addTask(messages[1]);
        printer.addTask(messages[2]);
        printer.executeAll();*/

        /*MessageTask[] messages = getMessages();
        for(MessageTask message : messages) {
            message.execute();
        }*/
    }
}
