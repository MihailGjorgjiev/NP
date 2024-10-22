package AV.AV2;

public class CombinationLock {
    private int passcode;
    private boolean isOpen;

    private boolean isValidPasscode(int passcode){
        return (100<=passcode && passcode<=999);
    }
    public CombinationLock(int passcode) throws IncorrectPasswordException {
        if(!isValidPasscode(passcode)){
            throw new IncorrectPasswordException("The passcode must be a 3-digit number");
        }
        this.passcode = passcode;
        this.isOpen=false;
    }

    public boolean lockUnlock(int attempt){
        this.isOpen=(this.passcode == attempt);
        return this.isOpen;
    }
    public boolean changeCombo(int oldPass,int newPass) throws IncorrectPasswordException {
        boolean isVerified=(this.passcode == oldPass);
        if (isVerified && isOpen){
            if(!isValidPasscode(passcode)){
                throw new IncorrectPasswordException("The passcode must be a 3-digit number");
            }
            this.passcode=newPass;
        }
        return (isVerified && isOpen);
    }

    public boolean isOpen() {
        return isOpen;
    }

    private static class IncorrectPasswordException extends Exception {
        public IncorrectPasswordException(String message) {
            super(message);
        }
    }
}
