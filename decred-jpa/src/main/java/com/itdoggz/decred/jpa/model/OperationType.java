package com.itdoggz.decred.jpa.model;

/*** ENUM OPERATION TYPE CONSTS FOR DEBET-CREDIT ITEM
 * DEBET, true value, because money input you budget
 * CREDIT, false value, because money output from your budget
 */
public enum OperationType {
    DEBET(true), CREDIT(false);

    private final boolean value;

    OperationType(boolean value) {
        this.value = value;
    }

    public static OperationType fromValue(boolean bVal) {
        return bVal ? DEBET : CREDIT;
    }

    public boolean getValue() {
        return value;
    }
}
