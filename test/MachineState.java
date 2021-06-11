public class MachineState extends State {

    private Event prevEvent;
    private Event prevPrevEvent;

    public MachineState(String id) {
        super(id);
    }

    @Override
    public void doSomething(Event e) {
        if (prevEvent == prevPrevEvent && prevEvent == e) {
            System.out.println("The event '" + e + "' was fired 3 times in a row");
        }
        prevPrevEvent = prevEvent;
        prevEvent = e;
    }
}
