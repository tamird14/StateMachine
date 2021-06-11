import java.util.HashSet;
import java.util.Set;

public class TestMachine {
    public static void main(String[] args) {
        MachineState state = new MachineState("State 1");
        EventA e1 = new EventA("Event 1", null);
        EventB e2 = new EventB("Event 2", null);
        state.registerTransition(e1, state);
        state.registerTransition(e2, state);
        Set<Event> eventSet=new HashSet<>();
        eventSet.add(e1);
        eventSet.add(e2);
        Set<State> stateSet=new HashSet<>();
        stateSet.add(state);
        Machine machine = new Machine(eventSet,stateSet,state);
        machine.transit(e1);
        machine.transit(e2);
        machine.transit(e1);
        machine.transit(e1);
        machine.transit(e2);
        machine.transit(e2);
        machine.transit(e2);
        machine.transit(e1);
        machine.transit(e1);
        machine.transit(e2);
        machine.transit(e1);
        machine.transit(e1);
        machine.transit(e1);
        machine.transit(e1);
    }
}
