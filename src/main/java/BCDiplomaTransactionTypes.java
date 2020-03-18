public enum BCDiplomaTransactionTypes {
    CERTIFICATE_MANAGER(0);

    private final int value;

    private BCDiplomaTransactionTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
