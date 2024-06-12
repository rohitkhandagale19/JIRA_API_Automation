package JIRA_API_Automation;

public class Token {
    private static final String JIRA_TOKEN = "your jira api token";
    private static final String USER_NAME = "test@test.com";
    private static final String DOMAIN_URL = "https://test-customer.atlassian.net/";

    public static String getToken() {
        return JIRA_TOKEN;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getDomainUrl() {
        return DOMAIN_URL;
    }
}
