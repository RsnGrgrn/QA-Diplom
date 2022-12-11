package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
public class Data {

    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static CardData getApprovedCard() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov Oleg", "123");
    }

    public static CardData getDeclinedCard() {
        return new CardData("9999 9999 9999 9999", "08", "24", "Volkov Oleg", "123");
    }

// ALL FIELDS ARE EMPTY

    public static CardData getCardDataIfEmptyAllFields() {
        return new CardData("", "", "", "", "");
    }

// FIELD CARD NUMBER

    public static CardData getEmptyCardNumber() {
        return new CardData("", "08", "24", "Volkov Oleg", "123");
    }

    public static CardData getInvalidCardNumberIfLess16Num() {
        return new CardData("1111 1111 1111 1", "08", "24", "Volkov Oleg", "123");
    }

    public static CardData getAnotherBankCardNumberOutOfBase() {
        return new CardData("7777 0000 0000 0001", "08", "24", "Volkov Oleg", "123");
    }

// FIELD MONTH

    public static CardData getEmptyMonth() {
        return new CardData("1111 1111 1111 1111", "", "24", "Volkov Oleg", "123");
    }

    public static CardData getInvalidNumberOfMonthIfOneNum() {
        return new CardData("1111 1111 1111 1111", "1", "24", "Volkov Oleg", "123");
    }

    public static CardData getInvalidNumberOfMonthIfMore12() {
        return new CardData("1111 1111 1111 1111", "20", "24", "Volkov Oleg", "123");
    }

    public static CardData getInvalidNumberOfMonthIfZero() {
        return new CardData("1111 1111 1111 1111", "00", "24", "Volkov Oleg", "123");
    }

// FIELD YEAR

    public static CardData getEmptyYear() {
        return new CardData("1111 1111 1111 1111", "08", "", "Volkov Oleg", "123");
    }

    public static CardData getYearIfOneNum() {
        return new CardData("1111 1111 1111 1111", "08", "1", "Volkov Oleg", "123");
    }

    public static CardData getEarlyYear() {
        return new CardData("1111 1111 1111 1111", "08", "16", "Volkov Oleg", "123");
    }

    public static CardData getInvalidYearIfZero() {
        return new CardData("1111 1111 1111 1111", "08", "00", "Volkov Oleg", "123");
    }

    public static CardData getFarFutureYear() {
        return new CardData("1111 1111 1111 1111", "08", "40", "Volkov Oleg", "123");
    }

// FIELD CARD HOLDER

    public static CardData getEmptyCardholderName() {
        return new CardData("1111 1111 1111 1111", "08", "24", "", "123");
    }

    public static CardData getInvalidCardholderNameIfOneWord() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov", "123");
    }

    public static CardData getInvalidCardholderNameIfThreeWords() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov Oleg Semenovich", "123");
    }

    public static CardData getInvalidCardholderNameIfRusSymbols() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Волков Олег", "123");
    }

    public static CardData getInvalidCardholderNameIfNumeric() {
        return new CardData("1111 1111 1111 1111", "08", "24", "9925 8237", "123");
    }

    public static CardData getInvalidOwnerWithSymbols() {
        return new CardData("1111 1111 1111 1111", "08", "24", "!@#", "123");
    }

// FEILD CVV

    public static CardData getEmptyCVV() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov Oleg", "");
    }

    public static CardData getInvalidCvvIfOneNum() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov Oleg", "3");
    }

    public static CardData getInvalidCvvIfTwoNum() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov Oleg", "08");
    }

    public static CardData getInvalidCvvIfThreeZero() {
        return new CardData("1111 1111 1111 1111", "08", "24", "Volkov Oleg", "000");
    }

}
