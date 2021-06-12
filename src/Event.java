import java.io.Serializable;
import java.util.Objects;

public abstract class Event implements Serializable {

    String id;
    Object additionalData;

    public Event(String id,Object additionalData) {
        this.id = id;
        this.additionalData = additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return id;
    }
}
