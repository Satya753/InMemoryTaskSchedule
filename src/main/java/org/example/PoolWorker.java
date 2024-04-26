package org.example;

import java.util.PriorityQueue;


public class PoolWorker extends Thread {

    PriorityQueue<ScheduledTask> taskQueue;
    private  int workerId ;


    public  PoolWorker(PriorityQueue<ScheduledTask> taskQueue , int workerId){
        this.workerId = workerId;

        this.taskQueue = taskQueue;
    }

    public void run(){
        ScheduledTask scheduledTask;
        while(true){
            synchronized (taskQueue){
                while(taskQueue.isEmpty()){
                    try {
                        taskQueue.wait();
                    }
                    catch (Exception e){
                        System.out.println("No task available");
                    }
                }
                scheduledTask = taskQueue.poll();

                System.out.println("Executed by the worker " + this.workerId);
                scheduledTask.run();
            }
        }
    }
}
