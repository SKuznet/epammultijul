package com.epam.multi.lesson5;

public class SyncLockExample implements Runnable {
    private Resource resource;

    public SyncLockExample(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (this) {
            resource.writeToFile();
        }

        resource.doLogging();
    }
}
