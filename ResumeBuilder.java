import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ResumeBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Resume Builder");
        System.out.println("Please enter your details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Education: ");
        String education = scanner.nextLine();

        System.out.print("Experience: ");
        String experience = scanner.nextLine();

        System.out.print("Skills: ");
        String skills = scanner.nextLine();

        System.out.print("Projects: ");
        String projects = scanner.nextLine();

        System.out.print("Certifications: ");
        String certifications = scanner.nextLine();

        System.out.print("Languages: ");
        String languages = scanner.nextLine();

        String resumeContent = generateResume(name, email, phone, education, experience, skills, projects, certifications, languages);

        System.out.println("\nYour resume has been generated:");
        System.out.println(resumeContent);

        // Save resume to a file
        try {
            FileWriter writer = new FileWriter("resume.txt");
            writer.write(resumeContent);
            writer.close();
            System.out.println("Your resume has been saved to resume.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the resume.");
            e.printStackTrace();
        }
    }

    public static String generateResume(String name, String email, String phone, String education, String experience,
                                        String skills, String projects, String certifications, String languages) {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Phone: ").append(phone).append("\n\n");

        sb.append("Education:\n").append(education).append("\n\n");

        sb.append("Experience:\n").append(experience).append("\n\n");

        sb.append("Skills:\n").append(skills).append("\n\n");

        sb.append("Projects:\n").append(projects).append("\n\n");

        sb.append("Certifications:\n").append(certifications).append("\n\n");

        sb.append("Languages:\n").append(languages).append("\n\n");

        return sb.toString();
    }
}
