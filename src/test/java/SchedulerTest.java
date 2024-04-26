import org.example.ScheduledTask;
import org.example.Scheduler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SchedulerTest {

    @Test
    public void runAndAddTask() throws InterruptedException {
        List< ScheduledTask > listOfTask = new ArrayList<>();
        listOfTask.add(new ScheduledTask(1 , 100 , 112  ));
        listOfTask.add(new ScheduledTask(2,200 , 113)  );
        listOfTask.add(new ScheduledTask(3,100 , 23222 ));
        listOfTask.add(new ScheduledTask(4,100 , 232));
        Scheduler scheduler = new Scheduler(listOfTask , 5);

        scheduler.addTask(new ScheduledTask(5 , 123 , 432));
        scheduler.addTask(new ScheduledTask(7 , 12 , 43212));

        Thread.sleep(2000);



    }
}
