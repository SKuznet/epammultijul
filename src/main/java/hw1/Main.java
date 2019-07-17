package hw1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("trafficSystem");
        try {
            final ActorRef trafficActor =
                    system.actorOf(TrafficActor.props(), "trafficActor");

            trafficActor.tell("Start", ActorRef.noSender());
        } finally {
            system.terminate();
        }
    }
}
