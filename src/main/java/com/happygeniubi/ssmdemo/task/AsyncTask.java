package com.happygeniubi.ssmdemo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Async
@Component
public class AsyncTask {

    public void taskOne() {
        try {
            Thread.sleep(4000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("taskOne...");
    }

    public void taskTwo() {
        try {
            Thread.sleep(4000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("taskTwo...");
    }

    public void taskThree() {
        try {
            Thread.sleep(4000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("taskThree...");
    }

    public Future<String> task4() {
        try {
            Thread.sleep(4000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task4...");
        return new AsyncResult<String>("任务4");
    }

    public Future<String>  task5() {
        try {
            Thread.sleep(4000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("task5...");
        return new AsyncResult<String>("任务5");
    }
}
