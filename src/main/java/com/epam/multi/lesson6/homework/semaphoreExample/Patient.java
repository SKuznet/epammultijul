package com.epam.multi.lesson6.homework.semaphoreExample;

public class Patient implements Runnable {

    private int patientId;

    public Patient(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public void run() {
        System.out.println("Patient number " + patientId + " wait for free ward beds in hospital");
        try {
            Hospital.INSTANCE.SEMAPHORE.acquire();

            int wardBedNumber = -1;

            synchronized (Hospital.INSTANCE.WARD_BEDS) {
                for (int i = 0; i < Hospital.INSTANCE.WARD_BEDS.length; i++) {
                    if (!Hospital.INSTANCE.WARD_BEDS[i]) {
                        Hospital.INSTANCE.WARD_BEDS[i] = true;
                        wardBedNumber = i;
                        System.out.println("Patient number " + patientId + " books ward bed by number " + wardBedNumber);
                        break;
                    }
                }
            }

            Thread.sleep(3000);

            synchronized (Hospital.INSTANCE.WARD_BEDS) {
                Hospital.INSTANCE.WARD_BEDS[wardBedNumber] = false;
            }

            Hospital.INSTANCE.SEMAPHORE.release();
            System.out.println("Patient by number " + patientId + " feel better now and go home!");
        } catch (InterruptedException e) {
            new RuntimeException();
        }
    }
}
