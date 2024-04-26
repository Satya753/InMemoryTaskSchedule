package org.example;

public class ScheduledTask extends Task{

    public long executionTimestamp;
    public long executionTime;

    public ScheduledTask(long id , long executionTime , long executionTimestamp){
        super(executionTimestamp , id);
        this.executionTime = executionTime;
        this.executionTimestamp = executionTimestamp;
    }
    @Override
    public void run(){

        try {
            System.out.println("Currently executing task " + this.getId() + " " + this.getPriority());
            Thread.sleep(executionTime);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
