package ru.netology.web.data;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.val;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.ElementsCollection;

public class DataHelper {
    private DataHelper() {
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }


    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static CardsInfo getFirstCardInfo() {
        return new CardsInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardsInfo getSecondCardInfo() {
        return new CardsInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static int generateValidAmount(int balance) {
        return new Random().nextInt(balance) + 1;
    }

    public static int generateInvalidAmount(int balance) {
        return Math.abs(balance) + new Random().nextInt(10000);
    }

    @Value
    public static class AuthInfo {
        public String login;
        public String password;
    }

    @Value
    public static class VerificationCode {
        String code;

    }

    @Value
    //  @AllArgsConstructor
    public static class CardsInfo {
        public String cardNumber;
        public String testId;
    }
}
