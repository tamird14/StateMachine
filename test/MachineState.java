public class MachineState extends State {

    private Event prevEvent;
    private Event prevPrevEvent;

    public MachineState(String id) {
        super(id);
    }

    @Override
    public void doSomething(Event e) {
        if (e.equals(prevPrevEvent) && e.equals(prevEvent)) {
            System.out.println("The event '" + e + "' was fired 3 times in a row");
        }
        prevPrevEvent = prevEvent;
        prevEvent = e;
    }

    @Override
    protected String saveRestOfState() {
        return prevEvent+";"+prevPrevEvent+"\n";
    }
}
