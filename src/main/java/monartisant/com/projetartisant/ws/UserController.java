package monartisant.com.projetartisant.ws;

import io.swagger.annotations.ApiOperation;
import monartisant.com.projetartisant.model.User;
import monartisant.com.projetartisant.repository.AdresRepository;
import monartisant.com.projetartisant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdresRepository adresRepository;
    @Autowired
    private EmailHtmlSender emailHtmlSender;
    @Autowired
    private Service service;
    @ApiOperation(value = "retreive user image from id")
    @GetMapping(path = "photouser/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getUserPhoto(@PathVariable("id") Long id) throws Exception {
        User user = userRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/image/" + user.getPhotoName() + ".png").toURI()));
    }

    //    @GetMapping("/usersbyville")
//    public List<User> getUserByVille(@RequestBody SearchParam param){
//   //   return userRepository.findByProfession_nameContainsAndAdresse_villeContainsAndProfession_Category_name(param.getProfessionName(),param.getVille(), param.getCategoryName());
//    }
    @ApiOperation(value = "update user rating", response = User.class)
    @Transactional
    @PostMapping("updatenote")
    public User update(@RequestBody SearchParamNote param) throws Exception {
        User user = userRepository.findById(param.getId()).get();
        if (user == null) {
            throw new Exception("user not existe");
        }
        user.setNote(param.getNote());
        userRepository.save(user);
        return userRepository.findById(param.getId()).get();
    }
    @ApiOperation(value = "search user by params")
    @PostMapping("search")
    public List<User> search(@RequestBody SearchParam param) {
        return userRepository.findByProfession_NameContainingAndAdresse_VilleContaining(
                param.getProfessionName(), param.getVille());

    }

    @ApiOperation(value = "send Email of user to professionel")
    @PostMapping("sendemail")
    public String sendEmail(@RequestBody SearchParamforDevis param) throws Exception {
        Context context = new Context();
        context.setVariable("title", "Vous avez une demande de devis");
        context.setVariable("body", "Mr." + param.getUser_name() + " " + param.getUser_lastName());
        context.setVariable("suite", "Adresse:  " + param.getUser_town() + "  " + param.getUser_codePostal());
        context.setVariable("description", param.getUser_message());
        EmailStatus emailStatus = emailHtmlSender.send("diaguilysociete@gmail.com", "DEMANDE DE DEVIS", "email/template-1", context);
        if (emailStatus.getStatus().equalsIgnoreCase("SUCCESS")) {
            return "true";
        } else
            throw new Exception("This message not send");
    }

    @PostMapping("smssender")
    @ApiOperation(value = "send sms of user to professionel")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        service.smsdSms(smsRequest);
    }
}
