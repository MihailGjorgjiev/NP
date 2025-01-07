package VtorKolokviumVezbi.Telco_30;

public class RingingState extends AbstractState {
    public RingingState(Call call) {
        super(call);
    }

    @Override
    public void createCall() {
        System.out.println("Invalid Operation");
    }

    @Override
    public void answer(long timestamp) {
        getCall().setTimestampStart(timestamp);
        getCall().setState(new InProgressState(getCall()));
    }

    @Override
    public void hold(long timestamp) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void resume(long timestamp) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void end(long timestamp) {
        getCall().setTimestampStart(timestamp);
        getCall().setTimestampEnd(timestamp);
        getCall().setState(new IdleState(getCall()));
    }
}
