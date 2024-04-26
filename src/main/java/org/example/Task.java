package org.example;

public abstract class Task implements Runnable{
    private long priority;
    private long id;

    public Task(long priority , long id){
        this.priority = priority;
        this.id = id;
    }
    @Override
    public void run(){

    }

    public long getPriority(){
        return this.priority;
    }

    public long getId(){
        return this.id;
    }
}
