package JIRA_API_Automation;

public class JsonBody {


   public static String requestBody = "{\"fields\":{\"project\":{\"id\":\"10004\"},\"issuetype\":{\"id\":\"10015\"},\"summary\":\"TestSummaryText\",\"description\":{\"version\":1,\"type\":\"doc\",\"content\":[{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"This is a test description text\"}]}]},\"labels\":[\"Sanity\"],\"reporter\":{\"id\":\"626a8656e2f47a00682f1b2f\"}}}";

   public static String updateRequestBody = "{\"fields\":{\"summary\":\"UpdatedSummaryText\",\"description\":{\"version\":1,\"type\":\"doc\",\"content\":[{\"type\":\"paragraph\",\"content\":[{\"type\":\"text\",\"text\":\"Updated description text\"}]}]},\"labels\":[\"UpdatedLabel\"]}}";



}
