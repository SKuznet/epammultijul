package com.epam.multi.lesson8.homework7;

public class LiveLockWithPhoneEx {



    public static void main(String[] args) {

        final PhoneCall dear = new PhoneCall("Alex");
        final PhoneCall darling = new PhoneCall("Annie");
        final HangUpPermission hgp = new HangUpPermission(dear);

        new Thread(new Runnable() {

            public void run() {
                dear.talkTo(hgp, darling);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                darling.talkTo(hgp, dear);
            }
        }).start();
    }



    static class HangUpPermission {

        private PhoneCall owner;

        public HangUpPermission(PhoneCall owner) {
            this.owner = owner;
        }

        synchronized void setOwner(PhoneCall diner) {
            owner = diner;
        }

        synchronized void use() {
            System.out.printf("%s has talked", owner.name);
        }
    }



    static class PhoneCall {

        private String name;
        private boolean isTalking;

        public PhoneCall(String name) {
            this.name = name;
            isTalking = true;
        }

        public String getName() {
            return name;
        }


        public void talkTo(HangUpPermission hgp, PhoneCall call) {
            while (isTalking) {
                if(hgp.owner != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                if (call.isTalking) {
                    System.out.printf("%s: Hang up you  first my darling  %s!%n", name, call.getName());
                    hgp.setOwner(call);
                    continue;
                }

                hgp.use();
                isTalking = false;
                System.out.printf("%s: I am stuffed, my darling %s!%n", name, call.getName());
                hgp.setOwner(call);
            }
        }
    }
}
