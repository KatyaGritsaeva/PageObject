package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.commands.Click;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement transferHead = $(byText("Пополнение карты"));
    private SelenideElement errorMessage = $("[data-test-id='error-message']");

    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public DahsboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardsInfo cardsInfo) {
        makeTransfer(amountToTransfer, cardsInfo);
        return new DahsboardPage();
    }

    public void makeTransfer(String amountToTransfer, DataHelper.CardsInfo cardsInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardsInfo.getCardNumber());
        transferButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
