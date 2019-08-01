package monartisant.com.projetartisant.ws;

import io.swagger.annotations.ApiOperation;
import monartisant.com.projetartisant.config.SecurityConstants;
import monartisant.com.projetartisant.errorHandle.InvalidTokenRequestException;
import monartisant.com.projetartisant.errorHandle.UserNotFoundException;
import monartisant.com.projetartisant.model.*;
import monartisant.com.projetartisant.repository.TokenRepository;
import monartisant.com.projetartisant.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Collections;
import java.util.HashSet;
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
    private ServiceTwilio service;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "retreive user image from id")
    @GetMapping(path = "photouser/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getUserPhoto(@PathVariable("id") Long id) throws Exception {
        User user = userRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/image/" + user.getPhotoName() + ".png").toURI()));
    }

    @ApiOperation(value = "retreive all Users ")
    @GetMapping("allUsers")
    public List<User> getAllUsers() throws Exception {
        return userRepository.chercherUsers(PageRequest.of(0, 4));
    }

    //    @GetMapping("/usersbyville")
//    public List<User> getUserByVille(@RequestBody SearchParam param){
//   //   return userRepository.findByProfession_nameContainsAndAdresse_villeContainsAndProfession_Category_name(param.getProfessionName(),param.getVille(), param.getCategoryName());
//    }
    @ApiOperation(value = "update user rating", response = User.class)
    @Transactional
    @PostMapping("updatenote")
    public User updateRatting(@RequestBody SearchParamNote param) throws Exception {
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

    @ApiOperation(value = "send Email of user to professionel")
    @PostMapping("sendemailcontacterme")
    public String sendEmailContactMe(@RequestBody SearchParamforContacterMe param) throws Exception {
        return sendMail(param.getName(), param.getMail(), param.getMessage());
    }

    private String sendMail(String... arg) throws Exception {
        Context context = new Context();
        context.setVariable("title", "Vous avez une demande de devis");
        context.setVariable("body", "Mr." + arg[0]);
        context.setVariable("suite", "Email:  " + arg[1]);
        context.setVariable("description", arg[2]);
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
    public User addProfessional(@RequestBody AddProfessional addProfessional) {
        User user = new User();
        Adresse adresse = new Adresse();
        Pays pays = new Pays();
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
    @PostMapping("searchuserbyville")
    public List<User> getUsersByVille(@RequestBody MapData mapData) {
        return userRepository.findByAdresse_Pays_nameAndAdresse_ville("senegal".toUpperCase(), mapData.getVille().toUpperCase());

    }

    @ApiOperation(value = "update user by params")
    @PostMapping("updateusermdp")
    public User updateMPD(@RequestBody LoginParam loginParam) throws UserPrincipalNotFoundException {

        User user = userRepository.findByEmail(loginParam.getEmail());
        if (user == null) {
            throw new UserPrincipalNotFoundException("this user dosenot exist {user }" + loginParam.getEmail());
        }
        try {
            sendMail(loginParam.getEmail(), loginParam.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @ApiOperation(value = "login user by params")
    @PostMapping("loginuser")
    public User login(@RequestBody LoginParam loginParam)  {

//        User user = userRepository.findByemailAndpassword(loginParam.getEmail(),loginParam.getPassword());
//        if(user == null){
//            throw new UserPrincipalNotFoundException("this user dosenot exist {user }" + loginParam.getEmail());
//        }
        return null;
    }
    @ApiOperation(value = "login user by params")
    @PostMapping("/signin")
    public Response signin(@RequestBody LoginParam form) throws Exception {
        User user = null;
        try {
            if (form == null || !form.getEmail().equals(form.getEmail())) {
                LOGGER.error(" User is  empty or null in {signin} ", form);
                throw new UsernameNotFoundException("this user does not  exists  please register with correct user or emails ares not match  {email}" + form.getEmail());
            }
            user = userRepository.findByEmailAndPassword(form.getEmail(), form.getPassword());

            if (user == null) {
                LOGGER.error("User is FORBIDDEN or Not existe ", user);
                return Response.status(Response.Status.FORBIDDEN).entity(user).build();

            }
        } catch (UserNotFoundException users) {
            LOGGER.error(" in {signin} user tried to register with forbidden email {users} :" + users);
            throw new UserNotFoundException("in {signUp} user tried to register with forbidden email {users} :" + users);
        }

        return Response.status(Response.Status.OK).entity(user).build();
    }

    @ApiOperation(value = "confirmRegister user by token")
    @PostMapping("/confirmregister")
    public User confirmRegister(@RequestBody ConfirmRegister token, @javax.ws.rs.core.Context HttpServletResponse response) throws Exception {

        try {
            if (Strings.isBlank(token.getJwtToken())) {
                LOGGER.error(" Token is empty or null in {signUp}:" + token);
                throw new IllegalArgumentException("Token is required in confirmRegistration {token} = " + token.getJwtToken());
            }
            Token verificationToken = tokenRepository.findByTokenTransit(token.getJwtToken());
            if (verificationToken == null) {
                LOGGER.error("This token is not available at {signUp}", verificationToken);
                return null;
            }
            if (!token.getJwtToken().equals(verificationToken.getTokenTransit())) {
                LOGGER.error("This token is not available at {signUp}", verificationToken);
                return null;
            }
            Boolean isValidTokenFromUrl = tokenProvider.validateToken(token.getJwtToken());
            LOGGER.debug("token validation in  {signUp } = " + isValidTokenFromUrl);
            Boolean isTokenFromBackValid = tokenProvider.validateToken(verificationToken.getTokenTransit());
            LOGGER.debug("token validation in  {signUp } = " + isTokenFromBackValid);
            LOGGER.debug("token verification in  {signUp } = " + verificationToken);
            User userVerification = verificationToken.getUser();
            if (userVerification == null) {
                LOGGER.error("this user does not   exists {userVerification } = " + userVerification);
                return null;
            }
            if (userVerification != null && userVerification.isBanned()) {
                LOGGER.error("this user is banned  {userVerification } = " + userVerification);
                return null;
            }
            userRepository.save(userVerification);
            LOGGER.debug("User verification in  {confirmregister } = " + userVerification);
            response.addHeader(SecurityConstants.HEADER_STRING,
                    SecurityConstants.TOKEN_PREFIX + verificationToken.getTokenTransit());
            return userVerification;
        } catch (InvalidTokenRequestException ex) {
            if (ex.getTokenType().toUpperCase().equals("ExpiredJWT".toUpperCase())) {
                Token verificationToken = tokenRepository.findByTokenTransit(token.getJwtToken());
                User userVerification = verificationToken.getUser();
                String newToken = tokenProvider.generateToken(userVerification);
                tokenRepository.setTransitToken(newToken, verificationToken.getId());
                LOGGER.error(" update token = " + newToken);
                Token newTok = tokenRepository.findByTokenTransit(newToken);
                userVerification = newTok.getUser();
                userRepository.save(userVerification);
                response.addHeader(SecurityConstants.HEADER_STRING,
                        SecurityConstants.TOKEN_PREFIX + newTok.getTokenTransit());
                return userVerification;
            } else
                return null;
        }
    }

    @PostMapping("/register")
    public Response register(@RequestBody Register register, @javax.ws.rs.core.Context HttpServletRequest request,@javax.ws.rs.core.Context HttpServletResponse response) throws Exception {
        User user = new User();
        try {
            if (register == null || !register.getEmail().equals(register.getEmail())) {
                LOGGER.error(" User is  empty or null in {signin} ", register);
                throw new UsernameNotFoundException("this user does not  exists  please register with correct user or emails ares not match  {email}" + register.getEmail());
            }
            user = userRepository.findByEmail(register.getEmail());

            if (user != null) {
                LOGGER.error("User already existe ", user);
                return Response.status(Response.Status.FORBIDDEN).entity(user).build();

            }
            if (register.getPassword().toUpperCase().equals(register.getConfirmPassword().toUpperCase())) {
                LOGGER.error("Passwords are not matched", user);
                return Response.status(Response.Status.FORBIDDEN).entity(user).build();
            }
            user.setPassword(register.getPassword());
            user.setEmail(register.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
            user.setNom(register.getName());
            user.setPrenom(register.getLasName());
            user.setRoles(new HashSet<>(Collections.singleton(RoleEnum.USER)));
            userRepository.save(user);
            String jwtToken = tokenProvider.generateToken(user);
            response.addHeader(SecurityConstants.HEADER_STRING,
                    SecurityConstants.TOKEN_PREFIX + jwtToken);
            tokenService.createUserWithToken(user, jwtToken);
            LOGGER.debug("User {user}= " + user + " token {jwtToken}= " + jwtToken);
            Token verificationToken = tokenRepository.findByUser(user);

            LOGGER.info("User is signin ", user.getEmail(), "with this token {}", verificationToken.getTokenTransit());
            sendMailJWT(user.getEmail(), verificationToken.getTokenTransit());
        } catch (UserNotFoundException users) {
            LOGGER.error(" in {signin} user tried to register with forbidden email {users} :" + users);
            throw new UserNotFoundException("in {signUp} user tried to register with forbidden email {users} :" + users);
        }
        return Response.status(Response.Status.OK).entity(user).build();
    }

    private String sendMailJWT(String... arg) throws Exception {
        Context context = new Context();
        context.setVariable("title", "Click sur le token pour confirmer votre inscription");
        context.setVariable("body", "Clicker sur le lien" + arg[0]);
        context.setVariable("Token", "Email:  " + arg[1]);
        EmailStatus emailStatus = emailHtmlSender.send("diaguilysociete@gmail.com", "DEMANDE DE DEVIS", "email/template-1", context);
        if (emailStatus.getStatus().equalsIgnoreCase("SUCCESS")) {
            return "true";
        } else
            throw new Exception("This message not send");
    }
}
