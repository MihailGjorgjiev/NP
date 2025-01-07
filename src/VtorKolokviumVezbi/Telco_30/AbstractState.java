package VtorKolokviumVezbi.Telco_30;

public abstract class AbstractState implements State{
    private Call call;

    public AbstractState(Call call) {
        this.call = call;
    }

    public Call getCall() {
        return call;
    }
}
