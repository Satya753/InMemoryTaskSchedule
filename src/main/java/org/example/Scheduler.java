package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Scheduler {

    public static int THREADS ;
    public PriorityQueue<ScheduledTask> schedulerQueue;
    public PoolWorker[] pollworkers;
    public Scheduler(List< ScheduledTask > task , int noOfThreads){
        this.THREADS = noOfThreads;
        this.pollworkers = new PoolWorker[noOfThreads];
        schedulerQueue = new PriorityQueue<>((a , b)-> Math.toIntExact((a.getPriority() - b.getPriority())));

        for (ScheduledTask t : task){
            schedulerQueue.offer(t);
        }
        for (int i = 0 ; i < THREADS ; i++){
            pollworkers[i] = new PoolWorker(schedulerQueue , i);
            pollworkers[i].start();
        }
    }

    public void addTask(ScheduledTask task){
        synchronized (schedulerQueue) {
            schedulerQueue.offer(task);
            schedulerQueue.notify();
        }
    }
}
