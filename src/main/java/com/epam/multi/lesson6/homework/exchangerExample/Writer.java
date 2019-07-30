package com.epam.multi.lesson6.homework.exchangerExample;

public class Writer implements Runnable {
    private String novelText;
    private String writerName;

    public Writer(String writerName, String novelText) {
        this.writerName = writerName;
        this.novelText = novelText;
    }

    @Override
    public void run() {
        try {
            System.out.println("Writer " + writerName + " write: " + novelText);
            novelText = Novel.EXCHANGER.exchange(novelText);
            System.out.println("Writer " + writerName + " get for correction: " + novelText);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
