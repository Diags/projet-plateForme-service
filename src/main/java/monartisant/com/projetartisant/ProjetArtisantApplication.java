package monartisant.com.projetartisant;

import monartisant.com.projetartisant.model.*;
import monartisant.com.projetartisant.repository.CategoryRepository;
import monartisant.com.projetartisant.repository.ProfessionRepository;
import monartisant.com.projetartisant.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SpringBootApplication
public class ProjetArtisantApplication implements CommandLineRunner {
    @Autowired(required = true)
    private UserRepository userRepository;
    @Autowired(required = true)
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private ProfessionRepository professionRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetArtisantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Context context = new Context();
//        context.setVariable("title", "Vous avez une demande de devis:");
//        context.setVariable("body", "Mr. Dupont voudrait un devis sur le coffrage de son appartement.");
//        context.setVariable("description", "Description:");
//
//        EmailStatus emailStatus = emailHtmlSender.send("diaguilysociete@gmail.com", "DEMANDE DE DEVIS", "email/template-1", context);

        repositoryRestConfiguration.exposeIdsFor(User.class, Category.class, Adresse.class, Profession.class, Token.class);
        //  Adresse a = new Adresse(null, 12, "rue", "emeraude", 69006, "lyon");
        Random rd = new Random();
        categoryRepository.save(new Category(null, "BATIMENT", RandomString.make(12), "macon1", null));
        categoryRepository.save(new Category(null, "FABRICATION", RandomString.make(12), "conducteuTraveau", null));
        categoryRepository.save(new Category(null, "ARTISTE-PEINTRE", RandomString.make(12), "peintre1", null));
        categoryRepository.save(new Category(null, "COIFFURE", RandomString.make(12), "coiffeur", null));
        categoryRepository.save(new Category(null, "MEUNUISIER", RandomString.make(12), "menuisier1", null));
        categoryRepository.save(new Category(null, "HAUTE COUTURE", RandomString.make(12), "couturier1", null));
        categoryRepository.save(new Category(null, "ELECTRICIEN", RandomString.make(12), "electricien", null));
        categoryRepository.save(new Category(null, "SOUDEUR", RandomString.make(12), "soudeur", null));
        categoryRepository.save(new Category(null, "MAINTENANIER", RandomString.make(12), "maintenancier", null));
        categoryRepository.save(new Category(null, "PRESSING", RandomString.make(12), "presseur", null));


        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("img_avatar4");
        ArrayList<String>  villes = new ArrayList<String>();
        villes.add("Bakel");
        villes.add("Bargny");
        villes.add("Bignona");
        villes.add("Cap-Skirring");
        villes.add("Dagana");
        villes.add("Dakar");
        villes.add("Diourbel");
        villes.add("Elinkine");
        villes.add("Fatick");
        villes.add("Gorée");
        villes.add("Guédé");
        villes.add("Guediawaye-Iwol");
        villes.add("Joal-Fadiouth");
        villes.add("Kaolack");
        villes.add("Karabane");
        villes.add("Kayar");
        villes.add("Kébémer");
        villes.add("Kédougou");
        villes.add("Kolda");
        villes.add("Louga");
        villes.add("Matam");
        villes.add("Mbacké");
        villes.add("Mbour");
        villes.add("Mlomp");
        villes.add("Ngor");
        villes.add("Nguenienne");
        villes.add("Nianing");
        villes.add("Ourossogui");
        villes.add("Oussouye");
        villes.add("Pikine");
        villes.add("Podor");
        villes.add("Popinguine");
        villes.add("Richard Toll");
        villes.add("Rosso");
        villes.add("Rufisque");
        villes.add("Saint-Louis");
        villes.add("Saly-Portudal");
        villes.add("Sédhiou");
        villes.add("Somone");
        villes.add("Tambacounda");
        villes.add("Thiès");
        villes.add("Tivaouane");
        villes.add("Touba");
        villes.add("Toubab Dialaw");
        villes.add("Ziguinchor");


        ArrayList<String>  nom = new ArrayList<String>();
        nom.add("Aïdara");
        nom.add("Bathily");
        nom.add("Bayo");
        nom.add("Camara");
        nom.add("Cissé");
        nom.add("Cissoko");
        nom.add("Coulibaly");
        nom.add("Dabo");
        nom.add("Demba");
        nom.add("Doumbia");
        nom.add("Doumbouya");
        nom.add("Diabang");
        nom.add("Diabira");
        nom.add("Diagana");
        nom.add("Diakhaby");
        nom.add("Diakhaté");
        nom.add("Diakité");
        nom.add("Dansokho ");
        nom.add("Diakho");
        nom.add("Diarra");
        nom.add("Diawara ");
        nom.add("Dibané");
        nom.add("Djimera");
        nom.add("Dramé");
        nom.add("Doucouré");
        nom.add("Fadiga");
        nom.add("Faty");
        nom.add("Fofana");
        nom.add("Gakou");
        nom.add("Gandega ");
        nom.add("Gassama");
        nom.add("Kanté");
        nom.add("Kanouté");
        nom.add("Kébé");
        nom.add("Keïta");
        nom.add("Koïta");
        nom.add("Konaté");
        nom.add("Koroboume");
        nom.add("Marega");
        nom.add("Niangane ");
        nom.add("Sabaly");
        nom.add("Sadio");
        nom.add("Sakho ");
        nom.add("Samassa");
        nom.add("Sané");
        nom.add("Sawane");
        nom.add("Sidibé");
        nom.add("Sissoko");
        nom.add("Soukho");
        nom.add("Soumaré ");
        nom.add("Tamba");
        nom.add("Tambadou ");
        nom.add("Tambedou ");
        nom.add("Tandia");
        nom.add("Tandian");
        nom.add("Tandjigora");
        nom.add("Timera ");
        nom.add("Traoré ");
        nom.add("Wagué");
        nom.add("Yatéra");
        nom.add("Touré");
        ArrayList<String> prenom = new ArrayList<String>();
        prenom.add("Abdoulaye");
        prenom.add("Adjoua");
        prenom.add("Affoué");
        prenom.add("Ahou");
        prenom.add("Aïssata");
        prenom.add("Aissatou");
        prenom.add("Akissi");
        prenom.add("Alassane");
        prenom.add("Demba");
        prenom.add("Alioune");
        prenom.add("Amenan");
        prenom.add("Aminata ");
        prenom.add("Amoin");
        prenom.add("Assa ");
        prenom.add("Assane ");
        prenom.add("Awa ");
        prenom.add("Aya ");
        prenom.add("Baron ");
        prenom.add("Bintou");
        prenom.add("Boku");
        prenom.add("Boubacar ");
        prenom.add("Djenaba");
        prenom.add("Fatimata");
        prenom.add("Fatou");
        prenom.add("Fatoumata");
        prenom.add("Kadiatou");
        prenom.add("Kame ");
        prenom.add("Kani");
        prenom.add("Koffi ");
        prenom.add("Konan");
        prenom.add("Kouadio");
        prenom.add("Kouakou");
        prenom.add("Kouamé");
        prenom.add("Kouassi");
        prenom.add("Lassana");
        prenom.add("Madani");
        prenom.add("Mamadou");
        prenom.add("Mbomela");
        prenom.add("Mbuyi ");
        prenom.add("Milandu");
        prenom.add("Sadio");
        prenom.add("Mobuka-Mpanze ");
        prenom.add("Mokonzo");
        prenom.add("Mumboko");
        prenom.add("Mupondo");
        prenom.add("N'Guessan");
        prenom.add("Nana");
        prenom.add("Ngolomingi");
        prenom.add("Ngu ");
        prenom.add("Nzuzi");
        prenom.add("Oumou ");
        prenom.add("Ousmane ");
        prenom.add("Rokia");
        prenom.add("Yao");



        //--Architecte - BTP - Urbanisme
        ArrayList<String> menuiseriue = new ArrayList<String>();
        menuiseriue.add("Ebéniste");
        menuiseriue.add("charpentier bois");
        menuiseriue.add("menuisier aluminium-verre");
        menuiseriue.add("Menuisier naval embarqué");
        menuiseriue.add("Tonnelier réparateur/Tonnelière ");
        menuiseriue.add("Menuisier-maquettiste/Menuisière-maquettiste");
        menuiseriue.add("Menuisier-agenceur");
        menuiseriue.add("Traceur/Traceuse en menuiserie");

        //Batiment
        ArrayList<String> batiment = new ArrayList<String>();
        batiment.add("carreleur");
        batiment.add("terrassier");
        batiment.add("géomaticien");
        batiment.add("terrassier");
        batiment.add("charpentier bois");
        batiment.add("chaudronnier et tuyauteur");
        batiment.add("coffreur-boiseur");
        batiment.add("couvreur");
        batiment.add("domoticien");
        batiment.add("échafaudeur)");
        batiment.add("électricien d’équipement");
        batiment.add("maçon");
        batiment.add("mécanicien robinetier");
        batiment.add("métallier");
        batiment.add("peintre en bâtiments");
        batiment.add("peintre en lettres");
        batiment.add("peintre solier");
        batiment.add("plâtrier");
        batiment.add("plombier");
        batiment.add("solier-moquettiste");
        batiment.add("serrurier métallier");
        batiment.add("chauffagiste");
        batiment.add("aménageur lotisseur");
        batiment.add("aménageur lotisseur");
        batiment.add(" architecte");
        batiment.add("promoteur immobilier");
        batiment.add("géomètre expert");
        batiment.add("démolisseur");

        //Automobile
        ArrayList<String> automobile = new ArrayList<String>();
        automobile.add(" carrossier-peintre");
        automobile.add("technicien plasturgiste");
        automobile.add("électronicien automobile");
        automobile.add("designer industriel");
        automobile.add("maquettiste automobile");
        automobile.add("ingénieur calcul");
        automobile.add("vendeur automobile");
        automobile.add("dépanneur-remorqueur");
        automobile.add("carrossier réparateur");
        automobile.add("mécanicien réparateur");

        //Esthétique - Beauté - Coiffure
        ArrayList<String> esthetique = new ArrayList<String>();
        esthetique.add("coiffeur");
        esthetique.add("barbier");
        esthetique.add(" conseiller en image");
        esthetique.add("maquilleur");
        esthetique.add("Styliste/modéliste");
        esthetique.add("esthéticienne");
        esthetique.add(" hydrothérapeute");
        esthetique.add(" styliste ongulaire");
        esthetique.add("diététicien");
        esthetique.add("brodeuse");
        esthetique.add(" costumier");
        esthetique.add("dentellière");
        esthetique.add("sellier/maroquinier");

        //pressing
        ArrayList<String> pressing = new ArrayList<String>();
        pressing.add("Aide manage");
        pressing.add("gouverante de maison");
        pressing.add("Repassage des vetements");
        pressing.add("Livreur et D'habits propre");


        //electricien
        ArrayList<String> electricien = new ArrayList<String>();
        electricien.add("Installateur d’éclairage");
        electricien.add("electricien");
        electricien.add("Technicien de sécurité");
        electricien.add("Monteur de réseau de distribution électrique");
        electricien.add("Electricien de process");
        electricien.add("Thermicien - climaticien");

        //peintres
        ArrayList<String> peintres = new ArrayList<String>();
        peintres.add("Peintre tapissier");
        peintres.add("plâtrier");
        peintres.add("Peinture extérieure");
        peintres.add("intérieure");
        peintres.add("murale");
        peintres.add("intérieure");
        //soudeur
        ArrayList<String> soudeur = new ArrayList<String>();
        soudeur.add("soudeur");
        soudeur.add("Chef d'atelier");
        soudeur.add("Monteur-câbleur");
        soudeur.add("Technicien installation d'équipements industriels");
        soudeur.add("Technicien de production");
        //Fabircation
        ArrayList<String> fabric = new ArrayList<String>();
        fabric.add("Meunuisier");
        fabric.add("ebainniste");
        fabric.add("poliiseur");
        fabric.add("designer");
        categoryRepository.findAll().forEach(c -> {
            for (int i = 0; i < 10; i++) {
                Profession profession = new Profession();
                switch (c.getName()) {
                    case "BATIMENT":
                        Collections.shuffle(batiment, new Random());
                        profession.setName(batiment.get(0));
                        //  Collections.shuffle(mylist, new Random());
                        profession.setPhoto("immo");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "FABRICATION":
                        Collections.shuffle(fabric, new Random());
                        profession.setName(fabric.get(0));
                        //   Collections.shuffle(mylist, new Random());
                        profession.setPhoto("menuisierie");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "ARTISTE-PEINTRE":
                        Collections.shuffle(peintres, new Random(3));
                        profession.setName(peintres.get(0));
                        //Collections.shuffle(educa, new Random());
                        profession.setPhoto("peintreOk");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "ELECTRICIEN":
                        Collections.shuffle(electricien, new Random());
                        profession.setName(electricien.get(0));
                        //   Collections.shuffle(restau, new Random());
                        profession.setPhoto("electrician");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "HAUTE COUTURE":
                        Collections.shuffle(esthetique, new Random(3));
                        profession.setName(esthetique.get(0));
                        //  Collections.shuffle(mylist, new Random());
                        profession.setPhoto("couture");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "MAINTENANCE":
                        Collections.shuffle(fabric, new Random(3));
                        profession.setName(fabric.get(0));
                        Collections.shuffle(fabric, new Random());
                        profession.setPhoto("menuisierie");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "PRESSING":
                        Collections.shuffle(pressing, new Random());
                        profession.setName(pressing.get(0));
                        //Collections.shuffle(agriculture, new Random());
                        profession.setPhoto("presing");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "SOUDEUR":
                        Collections.shuffle(soudeur, new Random());
                        profession.setName(soudeur.get(0));
                        profession.setPhoto("soudeur1");
                        profession.setDescription(RandomString.make(25));
                        break;

                    case "MEUNUISIER":
                        Collections.shuffle(menuiseriue, new Random());
                        profession.setName(menuiseriue.get(0));
                        // Collections.shuffle(mylist, new Random());
                        profession.setPhoto("urbaniste");
                        profession.setDescription(RandomString.make(25));
                        break;
//                    case "ART":
//                        Collections.shuffle(professions, new Random(3));
//                        profession.setName(professions.get(0));
//                       // Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("Art");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "SANTE":
//                        Collections.shuffle(professions, new Random(3));
//                        profession.setName(professions.get(0));
//                        //Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("evenema");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "AGROALIMENTAIRE":
//                        Collections.shuffle(agroalimentaire, new Random(3));
//                        profession.setName(agroalimentaire.get(0));
//                      //  Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("agroAlima");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "COMMUNICATION":
//                        Collections.shuffle(comm, new Random(3));
//                        profession.setName(comm.get(0));
//                     //   Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("comm");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "ESTHETIQUE":
//                        Collections.shuffle(esthetique, new Random(3));
//                        profession.setName(esthetique.get(0));
//                        Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("never");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "EVENEMENTIEL":
//                        Collections.shuffle(evenement, new Random(3));
//                        profession.setName(evenement.get(0));
//                       // Collections.shuffle(evenement, new Random());
//                        profession.setPhoto("evenema");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "SOCIAL":
//                        Collections.shuffle(social, new Random(3));
//                        profession.setName(social.get(0));
//                     //   Collections.shuffle(social, new Random());
//                        profession.setPhoto("social");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "SPORT":
//                        Collections.shuffle(sport, new Random(3));
//                        profession.setName(sport.get(0));
//                      //  Collections.shuffle(sport, new Random());
//                        profession.setPhoto("sport");
//                        profession.setDescription(RandomString.make(25));
//                        break;

                    default:
                }
                profession.setCategory(c);
                professionRepository.save(profession);
            }
        });
        professionRepository.findAll().forEach(profession -> {
            for (int i = 0; i < 10; i++) {
                User user = new User();
                Pays pays = new Pays();
                pays.setName("SENEGAL");
                Adresse adresse = new Adresse();
                adresse.setNumeroRue(1 + rd.nextInt(100));
                adresse.setRue("rue");
                adresse.setName("emeraude");
                adresse.setCodePostal(10 + rd.nextInt(20018));
                Collections.shuffle(villes, new Random());
                adresse.setVille(villes.get(0));
                adresse.setPays(pays);
                Collections.shuffle(nom, new Random());
                user.setNom(nom.get(0));
                Collections.shuffle(prenom, new Random());
                user.setPrenom(prenom.get(0));
                user.setAge(1988 + rd.nextInt(20018));
                user.isBanned();
                user.setNumeroSiret(100001988 + rd.nextInt(1000020018));
                //   user.setAdresse(new Adresse(null, 1 + rd.nextInt(100), "rue", "emeraude", 10 + rd.nextInt(20018), "lyon"));
                Collections.shuffle(mylist, new Random());
                user.setPhotoName("img");
                user.setAdresse(adresse);
                user.setNote(3.5);
                user.setProfession(profession);
                user.setTele(1980008025 + rd.nextInt(2000001823));
                userRepository.save(user);
            }
        });

//        categoryRepository.findAll().forEach(c -> {
//            for (int i = 0; i < 10; i++) {
//                User user = new User();
//                Adresse adresse = new Adresse();
//                adresse.setNumeroRue(1 + rd.nextInt(100));
//                adresse.setRue("rue");
//                adresse.setName("emeraude");
//                adresse.setCodePostal(10 + rd.nextInt(20018));
//                Collections.shuffle(mylist1, new Random());
//                adresse.setVille(mylist1.get(0));
//                user.setNom(RandomString.make(8));
//                user.setPrenom(RandomString.make(9));
//                user.setAge(1988 + rd.nextInt(20018));
//                user.isBanned();
//                user.setNumeroSiret(100001988 + rd.nextInt(1000020018));
//                //   user.setAdresse(new Adresse(null, 1 + rd.nextInt(100), "rue", "emeraude", 10 + rd.nextInt(20018), "lyon"));
//                Collections.shuffle(mylist, new Random());
//                user.setPhotoName(mylist.get(0));
//                user.setAdresse(adresse);
//                user.setNote(3.5);
//                userRepository.save(user);
//            }
//        });
    }

}
