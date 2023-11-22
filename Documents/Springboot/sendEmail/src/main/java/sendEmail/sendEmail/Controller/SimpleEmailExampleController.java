package sendEmail.sendEmail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sendEmail.sendEmail.Account.MyAccount;

@Controller
public class SimpleEmailExampleController {
    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyAccount.FRIEND_EMAIL);
        message.setSubject("BẠN ĐÃ BỊ HACK ĐIỆN THOẠI!!!");
        message.setText("GỬI 100TR VÀO TK 19037620335012 HOẶC BỊ PHÁT TÁN CLIP");

        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }
}
