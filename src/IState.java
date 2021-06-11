public interface IState {
    State transit(Event e);
}
