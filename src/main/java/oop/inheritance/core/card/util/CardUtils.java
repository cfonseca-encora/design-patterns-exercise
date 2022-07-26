package oop.inheritance.core.card.util;

import oop.inheritance.core.card.EntryMode;

public class CardUtils {
    public static EntryMode getGenericEntryMode(oop.library.ingenico.model.EntryMode entryMode) {
        return switch (entryMode) {
            case INSERTED -> EntryMode.INSERTED;
            case SWIPED -> EntryMode.SWIPED;
            case MANUAL -> EntryMode.MANUAL;
        };
    }

    public static EntryMode getGenericEntryMode(oop.library.verifone.model.EntryMode entryMode) {
        return switch (entryMode) {
            case INSERTED -> EntryMode.INSERTED;
            case SWIPED -> EntryMode.SWIPED;
            case MANUAL -> EntryMode.MANUAL;
        };
    }
}
