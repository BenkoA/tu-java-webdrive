package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickAccept();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results text incorrect!");
    }

    @Test
    public void testGettextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickDismiss();
        assertEquals(text, "I am a JS Confirm", "Results text incorrect!");
    }

    @Test
    public void testSetInputInAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "tau rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text incorrect!");
    }
}
