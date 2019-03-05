package io.cucumber;

import com.saucelabs.saucerest.SauceREST;
import org.json.JSONException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SauceUtils {

        private static SauceREST sauceRESTClient;

        private static SauceREST getSauceRestClient(String username, String accessKey) {
            if (sauceRESTClient == null) {
                sauceRESTClient = new SauceREST(username, accessKey);
            }
            return sauceRESTClient;
        }

        public static void UpdateResults(String username, String accessKey, boolean testResults, String sessionId)
                throws JSONException {
            SauceREST client = getSauceRestClient(username, accessKey);
            Map<String, Object> updates = new HashMap<String, Object>();
            updates.put("passed", testResults);
            client.updateJobInfo(sessionId, updates);
        }

        public static void UpdateResults(WebDriver driver, boolean testResult){
            ((JavascriptExecutor)driver).executeScript("sauce:job-result=" + (testResult? "passed" : "failed"));
        }

        public static void addNote(WebDriver driver, String message){
            ((JavascriptExecutor)driver).executeScript("sauce:context=" + message);
        }
}
