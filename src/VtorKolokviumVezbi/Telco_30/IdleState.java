package VtorKolokviumVezbi.Telco_30;

public class IdleState extends AbstractState{
    public IdleState(Call call) {
        super(call);
    }

    @Override
    public void createCall() {
        getCall().setState(new RingingState(getCall()));
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
        System.out.println("Invalid Operation");
    }

    @Override
    public void end(long timestamp) {
        System.out.println("Invalid Operation");
    }
}
