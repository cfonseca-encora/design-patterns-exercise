package oop.inheritance.core.transaction;

public class GenericTransactionResponse {
    private boolean approved;
    private String hostReference;
    private String message;

    public GenericTransactionResponse(boolean approved, String hostReference) {
        this.approved = approved;
        this.hostReference = hostReference;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getHostReference() {
        return hostReference;
    }

    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
