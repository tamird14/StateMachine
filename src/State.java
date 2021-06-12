import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class State implements IState, Serializable {

    String id;
    Map<Event, State> transitions;

    public State(String id) {
        transitions = new HashMap<>();
        this.id = id;
    }

    public void registerTransition(Event e, State s) {
        if (e == null || s == null) {
            throw new IllegalArgumentException("Received null as a parameter");
        }
        transitions.put(e, s);
    }

    public State transit(Event e) {
        if (!transitions.containsKey(e)) {
            throw new IllegalArgumentException("Event '" + e + "' is not registered for state " + id);
        }
        State s = transitions.get(e);
        s.doSomething(e);
        return s;
    }

    public abstract void doSomething(Event e);

    public String saveState() {
        StringBuilder str = new StringBuilder(this.getClass().getSimpleName() + ";" + id + ";");
        for (Event e : transitions.keySet()) {
            str.append(e.toString()).append(",").append(transitions.get(e).toString());
        }
        str.append(";").append(saveRestOfState());
        return str.toString();
    }

    protected abstract String saveRestOfState();
}
