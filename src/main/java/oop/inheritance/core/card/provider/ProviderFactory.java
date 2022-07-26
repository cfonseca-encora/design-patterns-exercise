package oop.inheritance.core.card.provider;

import oop.inheritance.core.card.provider.ingenico.IngenicoCardProvider;
import oop.inheritance.core.card.provider.verifone.VerifoneV240MCardProvider;
import oop.inheritance.data.SupportedTerminal;

public class ProviderFactory {
    public static Provider getInstance(SupportedTerminal supportedTerminal) {
        return switch (supportedTerminal) {

            case INGENICO -> IngenicoCardProvider.getInstance();
            case VERIFONE_240_M -> VerifoneV240MCardProvider.getInstance();
            case VERIFONE_520 -> null;
            case VERIFONE_690 -> null;
        };
    }
}
