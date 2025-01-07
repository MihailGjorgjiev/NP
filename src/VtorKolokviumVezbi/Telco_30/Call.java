package VtorKolokviumVezbi.Telco_30;

public class Call {
    private String uuid;
    private String dialer;
    private String receiver;
    private Long timestampInitialized;

    private Long timestampStart;
    private Long timestampEnd;
    private Long timestampHold;
    private Long totalHoldTime;
    State state;

    public Call() {
        this.timestampStart = null;
        this.timestampEnd = null;
        this.timestampHold = null;
        this.totalHoldTime = 0L;

        this.state = new IdleState(this);
    }

    public Call(String uuid, String dialer, String receiver, Long timestamp) {
        this();
        this.uuid = uuid;
        this.dialer = dialer;
        this.receiver = receiver;
        this.timestampInitialized = timestamp;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDialer() {
        return dialer;
    }

    public String getReceiver() {
        return receiver;
    }

    public Long getTimestampInitialized() {
        return timestampInitialized;
    }

    public Long getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(Long timestampStart) {
        this.timestampStart = timestampStart;
    }

    public Long getTimestampEnd() {
        return timestampEnd;
    }

    public void setTimestampEnd(Long timestampEnd) {
        this.timestampEnd = timestampEnd;
    }

    public Long getTimestampHold() {
        return timestampHold;
    }

    public void setTimestampHold(Long timestampHold) {
        this.timestampHold = timestampHold;
    }

    public Long getTotalHoldTime() {
        return totalHoldTime;
    }

    public void setTotalHoldTime(Long totalHoldTime) {
        this.totalHoldTime = totalHoldTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void createCall() {
        state.createCall();
    }

    public void update(long timestamp, String action) {
        switch (action) {
            case "ANSWER":
                state.answer(timestamp);
                break;
            case "END":
                state.end(timestamp);
                break;
            case "HOLD":
                state.hold(timestamp);
                break;
            case "RESUME":
                state.resume(timestamp);
                break;
        }
    }

    public long getDuration() {
        if (timestampStart == null && timestampHold == null) return 0;
        return timestampEnd - (timestampStart != null ? timestampStart : 0) - totalHoldTime;
    }

    public String report(String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.equals(dialer)) {
            sb.append("D ").append(receiver).append(" ");
        } else {
            sb.append("R ").append(dialer).append(" ");
        }
        sb.append(timestampStart).append(" ").append(!timestampEnd.equals(timestampStart) ? timestampEnd : "MISSED CALL");
        sb.append(" ").append(DurationConverter.convert(getDuration()));

        return sb.toString();
    }
}
