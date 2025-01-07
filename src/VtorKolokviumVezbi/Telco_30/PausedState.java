package VtorKolokviumVezbi.Telco_30;

public class PausedState extends AbstractState {
    public PausedState(Call call) {
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
        System.out.println("Invalid Operation");
    }

    @Override
    public void resume(long timestamp) {
        long timeOnHold = timestamp - getCall().getTimestampHold();
        getCall().setTotalHoldTime(getCall().getTotalHoldTime() + timeOnHold);
        getCall().setTimestampHold(null);

        getCall().setState(new InProgressState(getCall()));
    }

    @Override
    public void end(long timestamp) {
        getCall().setTimestampEnd(timestamp);

        long timeOnHold = timestamp - getCall().getTimestampHold();
        getCall().setTotalHoldTime(getCall().getTotalHoldTime() + timeOnHold);
        getCall().setTimestampHold(null);

        getCall().setState(new IdleState(getCall()));
    }
}
