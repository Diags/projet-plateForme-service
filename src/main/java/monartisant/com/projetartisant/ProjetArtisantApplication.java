package monartisant.com.projetartisant;

import monartisant.com.projetartisant.model.*;
import monartisant.com.projetartisant.repository.*;
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
    @Autowired(required=true)
    private UserRepository userRepository;
    @Autowired(required=true)
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
        categoryRepository.save(new Category(null, "MACON", RandomString.make(12), "macon1", null));
        categoryRepository.save(new Category(null, "MECANICIEN", RandomString.make(12), "conducteuTraveau",null));
        categoryRepository.save(new Category(null, "PEINTRE", RandomString.make(12), "peintre1", null));
        categoryRepository.save(new Category(null, "COIFFURE", RandomString.make(12), "coiffeur", null));
        categoryRepository.save(new Category(null, "MEUNUISIER", RandomString.make(12), "menuisier1", null));
        categoryRepository.save(new Category(null, "HAUTE COUTURE", RandomString.make(12), "couturier1", null));
        categoryRepository.save(new Category(null, "ELECTRICIEN", RandomString.make(12), "electricien", null));
        //  categoryRepository.save(new Category(null, "SERVICE", RandomString.make(12), "doctor", null));
        categoryRepository.save(new Category(null, "MAINTENANIER", RandomString.make(12), "maintenancier", null));
        categoryRepository.save(new Category(null, "PRESSING", RandomString.make(12), "presseur", null));
//        categoryRepository.save(new Category(null, "AGROALIMENTAIRE", RandomString.make(12), "agroAlima", null));
//        categoryRepository.save(new Category(null, "COMMUNICATION", RandomString.make(12), "comm", null));
//        categoryRepository.save(new Category(null, "ASSURANCE", RandomString.make(12), "assurance", null));
//        categoryRepository.save(new Category(null, "ART", RandomString.make(12), "Art", null));
//      //  categoryRepository.save(new Category(null, "AUDIOVISUEL", RandomString.make(12), "cinema", null));
//        categoryRepository.save(new Category(null, "AUTOMOBIL", RandomString.make(12), "automobil", null));
//     //   categoryRepository.save(new Category(null, "BANQUE-FINANCE", RandomString.make(12), "finance", null));
//        // categoryRepository.save(new Category(null, "ESTHETIQUE", RandomString.make(12), "never", null));
//        categoryRepository.save(new Category(null, "SOCIAL", RandomString.make(12), "social", null));
//        categoryRepository.save(new Category(null, "SPORT", RandomString.make(12), "sport", null));
//        categoryRepository.save(new Category(null, "EVENEMENTIEL", RandomString.make(12), "doctor", null));
//      //  categoryRepository.save(new Category(null, "CULTURE", RandomString.make(12), "peintre", null));

        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("barack");
        mylist.add("ba");
        ArrayList<String> mylist1 = new ArrayList<String>();
        mylist1.add("Lyon");
        mylist1.add("Dijon");
        mylist1.add("Paris");
        mylist1.add("Marseil");
        mylist1.add("Bordeau");
        mylist1.add("Nante");
        mylist1.add("Stranbourgue");
        mylist1.add("Toulouse");
        ArrayList<String> professions = new ArrayList<String>();
        //---Santé---
        professions.add("Medecin Generalist");
        professions.add("chirurgien-dentiste");
        professions.add("sage-femme");
        professions.add("biologiste médical");
        professions.add("manipulateur d’électroradiologie médicale");
        professions.add("chirurgien");
        professions.add("gynécologue-obstétricien");
        professions.add("cardiologue");
        professions.add("psychiatre");
        professions.add("pédiatre");
        professions.add("dermatologue");
        professions.add(" médecin légiste");
        professions.add("nutritionniste");
        professions.add("chirurgien esthétique");
        ArrayList<String> Admistratif = new ArrayList<String>();
        //-- Admistratif---
        Admistratif.add("attaché d’administration scolaire et universitaire");
        Admistratif.add("chargé de mission");
        Admistratif.add("responsable de l’administration personnel");
        Admistratif.add("directeur des ressources humaines.");
        //--Aeronautique---
        ArrayList<String> aeronautique = new ArrayList<String>();
        aeronautique.add("ingénieur en aéronautique");
        aeronautique.add(" ingénieur en systèmes embarqués");
        aeronautique.add("technicien supérieur en électronique");
        aeronautique.add("technicien d’essai dessinateur");
        aeronautique.add("ingénieur d’affaires");
        aeronautique.add("technicien support clients");
        aeronautique.add("mécanicien moteur");
        aeronautique.add("Pilote");
        //----Agriculture--
        ArrayList<String> agriculture = new ArrayList<String>();
        agriculture.add("aquaculteur");
        agriculture.add("bûcheron");
        agriculture.add("élagueur");
        agriculture.add("caviste");
        agriculture.add(" horticulteur");
        agriculture.add("maître de chai");
        agriculture.add("ouvrier sylviculteur");
        agriculture.add("pépiniériste");
        agriculture.add(" jardinier paysagiste");
        agriculture.add("maraîcher");
        agriculture.add("responsable d’élevage");
        agriculture.add("céréalier");
        agriculture.add("vigneron");
        // ---Agroalimentaire
        ArrayList<String> agroalimentaire = new ArrayList<String>();
        agroalimentaire.add("conducteur de ligne de fabrication et de conditionnement");
        agroalimentaire.add("ingénieur nutritionniste");
        agroalimentaire.add("chargé de packaging");
        agroalimentaire.add("responsable d’atelier de fabrication");
        agroalimentaire.add(" responsable de logistique");
        agroalimentaire.add("attaché(e) commercial merchandising");
        //--Architecte - BTP - Urbanisme
        ArrayList<String> immobilier = new ArrayList<String>();
        immobilier.add("architecte");
        immobilier.add("architecte d’intérieur");
        immobilier.add("géomètre topographe");
        immobilier.add("géomètre expert");
        immobilier.add("paysagiste");
        immobilier.add("urbaniste");
        immobilier.add("technicien d’études");
        immobilier.add("ingénieur du BTP");
        immobilier.add("technicien d’études");
        immobilier.add("démolisseur");
        immobilier.add(" monteur en isolation thermique (calorifugeur)");
        //Batiment<
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
        batiment.add("menuisier");
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
        //---Communication---
        ArrayList<String> comm = new ArrayList<String>();
        comm.add("acheteur d’art et TV producer)");
        comm.add("directeur artistique");
        comm.add("infographiste");
        comm.add("graphiste");
        comm.add("wedding planner");
        comm.add("attaché de presse dans le sport");
        comm.add("directeur de communication");
        comm.add("attaché de presse");
        comm.add("chargé de communication en collectivité");
        comm.add("Griot");
        //Art
        ArrayList<String> art = new ArrayList<String>();
        art.add(" architecte d’intérieur");
        art.add(" décorateur d’intérieur");
        art.add("artiste peintre");
        art.add("graphiste");
        art.add("designer graphique");
        art.add("designer produit");
        art.add("céramiste");
        art.add("aphotographe");
        art.add("chargé de communication en collectivité");
        art.add("Griot");
        //--Assurance
        ArrayList<String> assurance = new ArrayList<String>();
        assurance.add(" agent général d’assurances");
        assurance.add(" conseiller en assurances");
        assurance.add("courtier");
        assurance.add("chargé de clientèle");
        assurance.add("Les gestionnaires");
        assurance.add("risk-manager");
        assurance.add("actuaires");
        assurance.add("gestionnaire actifs-passifs");
        assurance.add("chargé de communication en collectivité");
        assurance.add("contrôleur sinistres");
        //--Audiovisuel - Cinéma
        ArrayList<String> audiovisuel = new ArrayList<String>();
        audiovisuel.add(" comédien");
        audiovisuel.add("cascadeur");
        audiovisuel.add(" professionnels du dessin animé");
        audiovisuel.add("scénariste");
        audiovisuel.add("infographiste");
        audiovisuel.add("maquilleur");
        audiovisuel.add("chef décorateur");
        audiovisuel.add("assistant réalisateur");
        audiovisuel.add("costumier");
        audiovisuel.add("accessoiriste");
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
        //Banque - Finance
        ArrayList<String> banque = new ArrayList<String>();
        banque.add("chargé d’accueil");
        banque.add("chargé d’affaires");
        banque.add(" chargé d’affaires agricoles");
        banque.add("chargé d’études commerciales");
        banque.add("chargé de clientèle de particuliers");
        banque.add("chargé de clientèle de professionnels");
        banque.add("analyste-financier");
        banque.add("gestionnaire d’actifs");
        banque.add("directeur d’investissement");
        banque.add("mécanicien réparateur");
        //Commerce - Vente - Distribution
        ArrayList<String> CommVentedistri = new ArrayList<String>();
        CommVentedistri.add("acheteur");
        CommVentedistri.add("marketeur");
        CommVentedistri.add(" conseiller en vente directe");
        CommVentedistri.add("attaché commercial");
        CommVentedistri.add("ingénieur commercial");
        CommVentedistri.add("télévendeur");
        CommVentedistri.add("vendeur en magasin");
        CommVentedistri.add("vendeur export");
        //Esthétique - Beauté - Coiffure
        ArrayList<String> esthetique = new ArrayList<String>();
        esthetique.add("coiffeur");
        esthetique.add("barbier");
        esthetique.add(" conseiller en image");
        esthetique.add("maquilleur");
        esthetique.add("coiffeur");
        esthetique.add("esthéticienne");
        esthetique.add(" hydrothérapeute");
        esthetique.add(" styliste ongulaire");
        esthetique.add("diététicien");
        esthetique.add("esthéticienne");
        esthetique.add(" hydrothérapeute");
        esthetique.add("tatoueur");
        //Social
        ArrayList<String> social = new ArrayList<String>();
        social.add("agent de développement local");
        social.add("aide médico-psychologique");
        social.add(" conseillère conjugale et familiale");
        social.add("conseiller pénitentiaire d’insertion et probation");
        social.add("conseiller en insertion sociale et professionnelle");
        social.add("conseiller en économie sociale et familiale");
        social.add(" coordinateur social");
        social.add("délégué à la tutelle");
        social.add("directeur d’une maison de retraite");
        social.add("directeur d’une structure d’insertion");
        social.add(" Association");
        //Sport
        ArrayList<String> sport = new ArrayList<String>();
        sport.add("éducateur sportif");
        sport.add("éducateur sportif des métiers de la forme");
        sport.add(" entraîneur");
        sport.add("guide de haute montagne");
        sport.add("maître nageur sauveteur");
        sport.add("arbitre");
        sport.add(" animateur/responsable d’animation");
        sport.add("Lutteur");
        //Événementiel
        ArrayList<String> evenement = new ArrayList<String>();
        evenement.add("chef de projet événementiel");
        evenement.add(" animateur/responsable d’animation");
        evenement.add(" wedding planner");
        evenement.add(" organisateur d’événements");
        evenement.add(" animateur/responsable d’animation");
        evenement.add("Agences evenement");
        //Culture
        ArrayList<String> culture = new ArrayList<String>();
        culture.add("administrateur des monuments historiques");
        culture.add("archéologue");
        culture.add("chargé d’études documentaires");
        culture.add("conservateur des archives");
        culture.add("régisseur d’œuvre d’art");
        //Transport
        ArrayList<String> transport = new ArrayList<String>();
        transport.add("Chauffeur de bus");
        transport.add("Pilote");
        transport.add("BlaBlaCariste");
        transport.add("conducteur de grands traveaux");
        transport.add("Conducteur de Charet");
        //education
        ArrayList<String> educa = new ArrayList<String>();
        educa.add("Proffesseur universite");
        educa.add("Proffesseur enseignant");
        educa.add("Proffessuer ecole");
        educa.add("Maîtraisse");
        //Alimentation
        ArrayList<String> restau = new ArrayList<String>();
        restau.add("Serveur");
        restau.add("Cuisinier");
        restau.add("Commis Cuisinier");
        restau.add("Chef de rang");
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
                    case "MACON":
                        Collections.shuffle(immobilier, new Random(3));
                        profession.setName(immobilier.get(0));
                      //  Collections.shuffle(mylist, new Random());
                        profession.setPhoto("immo");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "MECANICIEN":
                        Collections.shuffle(transport, new Random(3));
                        profession.setName(transport.get(0));
                     //   Collections.shuffle(mylist, new Random());
                        profession.setPhoto("automobil");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "PEINTRE":
                        Collections.shuffle(educa, new Random(3));
                        profession.setName(educa.get(0));
                        //Collections.shuffle(educa, new Random());
                        profession.setPhoto("education");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "ELECTRICIEN":
                        Collections.shuffle(restau, new Random(3));
                        profession.setName(restau.get(0));
                     //   Collections.shuffle(restau, new Random());
                        profession.setPhoto("restau");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "HAUTE COUTURE":
                        Collections.shuffle(esthetique, new Random(3));
                        profession.setName(esthetique.get(0));
                      //  Collections.shuffle(mylist, new Random());
                        profession.setPhoto("peintre");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "MAINTENANCE":
                        Collections.shuffle(fabric, new Random(3));
                        profession.setName(fabric.get(0));
                        Collections.shuffle(fabric, new Random());
                        profession.setPhoto("meunuisier");
                        profession.setDescription(RandomString.make(25));
                        break;
                    case "Pressing":
                        Collections.shuffle(agriculture, new Random(3));
                        profession.setName(agriculture.get(0));
                        //Collections.shuffle(agriculture, new Random());
                        profession.setPhoto("agriculture");
                        profession.setDescription(RandomString.make(25));
                        break;
//                    case "ASSURANCE":
//                        Collections.shuffle(assurance, new Random(3));
//                        profession.setName(assurance.get(0));
//                     //   Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("assurance");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "AERONAUTIQUE":
//                        Collections.shuffle(aeronautique, new Random(3));
//                        profession.setName(aeronautique.get(0));
//                       // Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("aeraunotic");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "AUTOMOBIL":
//                        Collections.shuffle(automobile, new Random(3));
//                        profession.setName(automobile.get(0));
//                       // Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("automobil");
//                        profession.setDescription(RandomString.make(25));
//                        break;
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
                Adresse adresse = new Adresse();
                adresse.setNumeroRue(1 + rd.nextInt(100));
                adresse.setRue("rue");
                adresse.setName("emeraude");
                adresse.setCodePostal(10 + rd.nextInt(20018));
                Collections.shuffle(mylist1, new Random());
                adresse.setVille(mylist1.get(0));
                user.setNom(RandomString.make(8));
                user.setPrenom(RandomString.make(9));
                user.setAge(1988 + rd.nextInt(20018));
                user.isBanned();
                user.setNumeroSiret(100001988 + rd.nextInt(1000020018));
                //   user.setAdresse(new Adresse(null, 1 + rd.nextInt(100), "rue", "emeraude", 10 + rd.nextInt(20018), "lyon"));
                Collections.shuffle(mylist, new Random());
                user.setPhotoName(mylist.get(0));
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
