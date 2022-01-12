package co.simplon.projetsql;

import co.simplon.projetsql.entity.Document;
import co.simplon.projetsql.entity.Medecin;
import co.simplon.projetsql.entity.Patient;
import co.simplon.projetsql.entity.Speciality;
import co.simplon.projetsql.entity.User;
import co.simplon.projetsql.repository.DocumentRepository;
import co.simplon.projetsql.repository.IDocumentRepository;
import co.simplon.projetsql.repository.IMedecinRepository;
import co.simplon.projetsql.repository.IPatientReposotory;
import co.simplon.projetsql.repository.ISpecialityRepository;
import co.simplon.projetsql.repository.MedecinRepository;
import co.simplon.projetsql.repository.PatientRepository;
import co.simplon.projetsql.repository.SpecialityRepository;
import co.simplon.projetsql.repository.UserRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      MedecinRepository medecinRepository = new MedecinRepository();
      Medecin medecin =  medecinRepository.findMedecinWithListOfPatients(1);
      System.out.println(medecin.getPatientsList());


      


        // IDocumentRepository documentRepository = new DocumentRepository();
        // Document document = new Document(1, "doc1");
        // Document document2 = new Document(1, "doc2");
        // System.out.println(documentRepository.addDocument(document)); 
        // System.out.println(documentRepository.addDocument(document2)); 
        // document2.setPatient_id(2);
        // System.out.println(documentRepository.modifyDocument(document2)); 
       
        // System.out.println(documentRepository.findAll());
        // System.out.println(documentRepository.displayDocument(1));
        // System.out.println(documentRepository.deleteDocument(2));


        // ISpecialityRepository specialityRepository = new SpecialityRepository();
        // System.out.println(specialityRepository.findAll());
        // System.out.println(specialityRepository.displaySpeciality(1));
        // Speciality speciality = new Speciality("Orthodentiste");
        // System.out.println(specialityRepository.addSpeciality(speciality));
        // speciality.setName("Orthodontiste");
        // System.out.println(specialityRepository.modifySpeciality(speciality));
        // System.out.println(specialityRepository.deleteSpeciality(speciality.getSpe_id()));

        // IMedecinRepository medecinRepository = new MedecinRepository();
        // Medecin medecin = new Medecin(5, 1, "adresse", "chirurgien", "presentation", 10);
        // medecinRepository.modifyMedecin(medecin);

        

        



    }
}
