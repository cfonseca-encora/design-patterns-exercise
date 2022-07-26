package oop.inheritance.core.communicationdevices.factory;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.communicationdevices.ingenico.ethernet.IngenicoGenericEthernet;
import oop.inheritance.core.communicationdevices.ingenico.gps.IngenicoGenericGPS;
import oop.inheritance.core.communicationdevices.ingenico.modem.IngenicoGenericModem;
import oop.inheritance.core.communicationdevices.verifone.ethernet.VerifoneV240MGenericEthernet;
import oop.inheritance.core.communicationdevices.verifone.ethernet.VerifoneVx520GenericEthernet;
import oop.inheritance.core.communicationdevices.verifone.ethernet.VerifoneVx690GenericEthernet;
import oop.inheritance.core.communicationdevices.verifone.gps.VerifoneV240MGenericGPS;
import oop.inheritance.core.communicationdevices.verifone.gps.VerifoneVx520GenericGPS;
import oop.inheritance.core.communicationdevices.verifone.gps.VerifoneVx690GenericGPS;
import oop.inheritance.core.communicationdevices.verifone.modem.VerifoneV240MGenericModem;
import oop.inheritance.core.communicationdevices.verifone.modem.VerifoneVx520GenericModem;
import oop.inheritance.core.communicationdevices.verifone.modem.VerifoneVx690GenericModem;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;

public class CommunicationDeviceFactory {
    public static CommunicationDevice getInstance(SupportedTerminal supportedTerminal, CommunicationType communicationType) {
        switch (supportedTerminal) {
            case INGENICO -> {
                return switch (communicationType) {

                    case GPS -> IngenicoGenericGPS.getInstance();
                    case MODEM -> IngenicoGenericModem.getInstance();
                    case ETHERNET -> IngenicoGenericEthernet.getInstance();
                };
            }
            case VERIFONE_240_M -> {
                return switch (communicationType) {

                    case GPS -> VerifoneV240MGenericGPS.getInstance();
                    case MODEM -> VerifoneV240MGenericModem.getInstance();
                    case ETHERNET -> VerifoneV240MGenericEthernet.getInstance();
                };
            }
            case VERIFONE_520 -> {
                return switch (communicationType) {

                    case GPS -> VerifoneVx520GenericGPS.getInstance();
                    case MODEM -> VerifoneVx520GenericModem.getInstance();
                    case ETHERNET -> VerifoneVx520GenericEthernet.getInstance();
                };
            }
            case VERIFONE_690 -> {
                return switch (communicationType) {

                    case GPS -> VerifoneVx690GenericGPS.getInstance();
                    case MODEM -> VerifoneVx690GenericModem.getInstance();
                    case ETHERNET -> VerifoneVx690GenericEthernet.getInstance();
                };
            }
            case default -> {
                return null;
            }
        }
    }
}
