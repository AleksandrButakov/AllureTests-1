package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("polyakovaea")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("������ � �����������") //�������� ����������������
    @Story("�������� ����� ������") //������� ��������
    @DisplayName("�������� �������� Issue ��� ��������������� ������������")
    @Description(
            "���� ���� ��������� �������� Issue, ����� ����������..."
    ) //��������� ��������
    @Link(value = "Testing", url = "https://github.com") //url ����������� ��������

    public void testAnnotatedLabels() {

    }

}
