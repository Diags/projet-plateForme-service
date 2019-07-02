package monartisant.com.projetartisant.ws;

import io.swagger.annotations.ApiOperation;
import monartisant.com.projetartisant.model.*;
import monartisant.com.projetartisant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
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
    @Qualifier("userRepository")
    private UserRepository userRepository;
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
    @ApiOperation(value = "retreive all Users ")
    @GetMapping("allUsers")
    public List<User> getAllUsers() throws Exception {
        return userRepository.chercherUsers(PageRequest.of(0,4));
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

    @Transactional
    @ApiOperation(value = "search user by params")
    @PostMapping("search")
    public List<User> search(@RequestBody SearchParam param) {
        return userRepository.getUsers(
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
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.smsdSms(smsRequest);
    }

    @PostMapping("addprofessional")
    public User addProfessional(@RequestBody AddProfessional addProfessional){
        User  user = new User();
        Adresse adresse =new Adresse();
        Pays pays  = new Pays();
        pays.setName(addProfessional.getPays());
        adresse.setPays(pays);
        addProfessional.getTags().stream().forEach(ville -> adresse.setVille(ville));
        Profession profession = new Profession();
        Category category = new Category();
        category.setName(addProfessional.getCategoryName());
        profession.setCategory(category);
        user.setProfession(profession);
        user.setContacterViasTel(addProfessional.getContacterViasTel());
        user.setContacterViasTelWhatshap(addProfessional.getContacterViasWhatshap());
        user.setCout(Double.parseDouble(addProfessional.getCout()));
        user.setEntrepriseName(addProfessional.getEntrepriseName());
        user.setExperience(Double.parseDouble(addProfessional.getExperience()));
        user.setIfu(addProfessional.getIfu());
        user.setJour(addProfessional.getJour());
        user.setLangueEnum(LangueEnum.EN);
        user.setLangueEnum(LangueEnum.FR);
        user.setAdresse(adresse);
        user.setRaison(addProfessional.getRaison());
        user.setTele(Integer.valueOf(addProfessional.getTelephone()));
        user.setTelephone2(addProfessional.getTelephone2());
        user.setWhatsapp(addProfessional.getWhatsapp());
        return user;
    }

    @ApiOperation(value = "search user by params")
    @PostMapping("mapsearch")
    public List<User> getUsersByVille(@RequestBody MapData mapData) {
        return userRepository.findByAdresse_Pays_nameAndAdresse_ville("senegal".toUpperCase(),mapData.getVille().toUpperCase());

    }

}
