package oop.inheritance.core.communicationdevices.verifone.util;

import oop.inheritance.core.transaction.GenericTransactionResponse;
import oop.inheritance.core.transaction.GenericTransaction;

import java.nio.charset.StandardCharsets;

public final class VerifoneGenericUtils {

    public static byte[] dataBuilder(GenericTransaction genericTransaction) {
        String data = genericTransaction.getCard().getAccount() + "," +
                genericTransaction.getCard().getExpirationDate() + "," +
                genericTransaction.getCard().getEntryMode() + "," +
                genericTransaction.getAmountInCents();
        return data.getBytes(StandardCharsets.UTF_8); // When using String.getBytes is completely necessary to indicate the charset
    }

    public static GenericTransactionResponse responseProcessor(byte[] response) {
        String responseCode = getBCDCodes(response[0]);

        String hostReference = null;
        boolean success = false;
        String approvalCode = null;
        String message = null;

        if(responseCode.equals("00")) {
            success = true;
            approvalCode = new String(response,1,6);
            message = new String(response, 7, response.length - 1, StandardCharsets.UTF_8);
        } else {
            success = false;
            message = new String(response, 1, response.length - 1, StandardCharsets.UTF_8);
        }

        hostReference = hostReferenceBuilder(success, approvalCode, message);
        return new GenericTransactionResponse(success, hostReference);
    }

    public static String getBCDCodes(byte bcd) {
        StringBuffer sb = new StringBuffer();

        byte high = (byte) (bcd & 0xf0); //                1111 0000
        high >>= (byte) 4;              // HEX = 65; BIN = 0110 0101
        high = (byte) (high & 0x0f);     // 0000 0110
        byte low = (byte) (bcd & 0x0f);

        sb.append(high);
        sb.append(low);

        return sb.toString();
    }

    public static String hostReferenceBuilder(boolean success, String approvalCode, String message) {
        if(success)
            return approvalCode + message;

        return message;
    }
}
