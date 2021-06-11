public abstract class Event{

    String id;
    Object additionalData;

    public Event(String id,Object additionalData) {
        this.id = id;
        this.additionalData = additionalData;
    }

    @Override
    public String toString(){
        return id;
    }
}
