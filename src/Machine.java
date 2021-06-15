import java.io.*;
import java.util.Set;

public class Machine implements Serializable {

    Set<Event> events;
    Set<State> states;
    State currentState;

    public Machine(Set<Event> events, Set<State> states, State beginningState) {
        if (events == null || states == null || beginningState == null) {
            throw new IllegalArgumentException("Received null as a parameter");
        }
        this.events = events;
        if (!states.contains(beginningState)) {
            throw new IllegalArgumentException("Beginning state not included in the group of all states");
        }
        this.states = states;
        currentState = beginningState;
    }

    public Machine(){
    }

    public void transit(Event e) {
        if (e == null) {
            throw new IllegalArgumentException("Received null as a parameter");
        }
        if (!events.contains(e)) {
            throw new IllegalArgumentException("Received an unknown event " + e);
        }
        currentState = currentState.transit(e);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void save(){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("saved machine.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Machine load(){
        Machine machine = null;
        try {
            FileInputStream fileIn = new FileInputStream("saved machine.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            machine = (Machine) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Machine class not found");
            c.printStackTrace();
        }
        return machine;
    }

}
