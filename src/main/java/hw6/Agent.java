package hw6;

public class Agent {
    private String name;

    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void say(String message){
        System.out.println(this.getName() + ": " + message);
    }
}
