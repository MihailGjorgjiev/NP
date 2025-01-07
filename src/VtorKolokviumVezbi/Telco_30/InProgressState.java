package VtorKolokviumVezbi.Telco_30;

public class InProgressState extends AbstractState{
    public InProgressState(Call call) {
        super(call);
    }

    @Override
    public void createCall() {
        System.out.println("Invalid Operation");
    }

    @Override
    public void answer(long timestamp) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void hold(long timestamp) {
        getCall().setTimestampHold(timestamp);
        getCall().setState(new PausedState(getCall()));
    }

    @Override
    public void resume(long timestamp) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void end(long timestamp) {
        getCall().setTimestampEnd(timestamp);
        getCall().setState(new IdleState(getCall()));
    }
}
