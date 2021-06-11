import java.util.Set;

public class Machine {

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

}
