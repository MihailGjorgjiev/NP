package VtorKolokviumVezbi.Telco_30;

public interface State {
    void createCall();

    void answer(long timestamp);

    void hold(long timestamp);

    void resume(long timestamp);

    void end(long timestamp);
}
