package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideListenerTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void beforeEach() {
        open("https://github.com");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    @Owner("polyakovaea")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("������ � �����������") //�������� ����������������
    @Story("�������� ����� ������") //������� ����� �������� ��� ����������� ������
    @DisplayName("�������� ������� ���������� Issue � �����������")
    @Description(
            "���� ���� ��������� �������� Issue, ����� ����������..."
    ) //��������� ��������
    @Link(value = "github", url = "https://github.com") //url ����������� ��������

    public void testIssueExist() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".header-search-input").setValue("Soolaim95/AllureTests").submit();
        $(By.linkText("Soolaim95/AllureTests")).click();
        $(By.partialLinkText("Issues")).click();
        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        $(withText("Test Title")).should(Condition.exist);
    }

    //����������� ������� (����� ������������)
    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "polyakovaea");
        Allure.label("severity", SeverityLevel.MINOR.value());
        Allure.feature("������ � �����������");
        Allure.story("�������� ����� ������");
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("�������� �������� Issue ��� ��������������� ������������");
        });
        Allure.description("���� ���� ��������� �������� Issue, ����� ����������....");
        Allure.link("github", "https://github.com");
    }

    //������� ��������� ��� ����������� � ������
    @Test
    public void testParameters() {
        Allure.parameter("������", "���������� �������");
        Allure.parameter("�����", "������");
    }
}
