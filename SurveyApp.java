import java.util.ArrayList;
import java.util.List;

// Model class to represent survey responses
class SurveyResponse {
    private Long id;
    private String respondentEmail;
    private String response;

    public SurveyResponse(Long id, String respondentEmail, String response) {
        this.id = id;
        this.respondentEmail = respondentEmail;
        this.response = response;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespondentEmail() {
        return respondentEmail;
    }

    public void setRespondentEmail(String respondentEmail) {
        this.respondentEmail = respondentEmail;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

// Service class to handle survey operations
class SurveyService {
    private List<SurveyResponse> surveyResponses;

    public SurveyService() {
        this.surveyResponses = new ArrayList<>();
    }

    public void submitSurveyResponse(SurveyResponse surveyResponse) {
        surveyResponses.add(surveyResponse);
    }

    public List<SurveyResponse> getAllSurveyResponses() {
        return surveyResponses;
    }
}

// Class to send promotional emails
class EmailService {
    public void sendPromotionalEmail(String to, String subject, String text) {
        // Code to send email goes here
        System.out.println("Email sent to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + text);
    }
}

// Main class to run the application
public class SurveyApp {
    public static void main(String[] args) {
        // Creating instances of services
        SurveyService surveyService = new SurveyService();
        EmailService emailService = new EmailService();

        // Simulating survey submission
        SurveyResponse response1 = new SurveyResponse(1L, "user1@example.com", "Satisfied with the product.");
        SurveyResponse response2 = new SurveyResponse(2L, "user2@example.com", "The service could be improved.");
        surveyService.submitSurveyResponse(response1);
        surveyService.submitSurveyResponse(response2);

        // Getting all survey responses
        List<SurveyResponse> allResponses = surveyService.getAllSurveyResponses();
        for (SurveyResponse response : allResponses) {
            System.out.println("Survey Response:");
            System.out.println("ID: " + response.getId());
            System.out.println("Respondent Email: " + response.getRespondentEmail());
            System.out.println("Response: " + response.getResponse());
            System.out.println();
        }

        // Simulating sending promotional email
        String to = "targeteduser@example.com";
        String subject = "Special Offer for You!";
        String text = "Dear customer, here's a special offer just for you!";
        emailService.sendPromotionalEmail(to, subject, text);
    }
}
