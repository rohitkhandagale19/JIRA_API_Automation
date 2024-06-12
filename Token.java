package JIRA_API_Automation;

public class Token {
    private static final String JIRA_TOKEN = "ATATT3xFfGF0P86k3AlIVD7rlcKzHgvB_chj4efhpBPFkQn_f258p2MsgQC6p4uJUwPeWjsOKdLS-_Xpb68Rya6CwsyF4EQ7BEVI1ZkoYaJi5pAQZaEJ4XE93mQb4uaEV5TaHrVtIKDiJ-Mv82w51wXMnQ4_1TT4qpDnjCbGWJlK-_BdAP1HRJ0=DD981CA0";
    private static final String USER_NAME = "rohitkhandagale@gmail.com";
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