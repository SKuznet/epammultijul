package com.epam.multi.lesson1;

public class LightThread extends Thread {

    LightStatus lightStatus;
    private Light currentLight;
    private Light nextLight;
    private CommonTime commonTime = new CommonTime();

    public LightThread(Light currentLight, Light nextLight, LightStatus lightStatus) {
        this.currentLight = currentLight;
        this.nextLight = nextLight;
        this.lightStatus = lightStatus;
        this.commonTime.time = 0;
    }

    @Override
    public void run() {
        while (commonTime.time < lightStatus.getReferencePoint()) {
            synchronized (lightStatus) {
                if (lightStatus.getColour().equals(currentLight.getColour())) {
                    System.out.print(this.currentLight.getColour() + " ");
                    try {
                        commonTime.time += currentLight.getTimeSeconds();
                        Thread.sleep(currentLight.getTimeSeconds());
                        System.out.println("| Current time is " + commonTime.time/1000 + "s");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    lightStatus.setLightStatus(this.nextLight);
                    lightStatus.notifyAll();
                } else {
                    try {
                        lightStatus.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
