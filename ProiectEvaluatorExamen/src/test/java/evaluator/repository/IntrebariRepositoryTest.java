package evaluator.repository;

import evaluator.controller.AppController;
import evaluator.model.Intrebare;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class IntrebariRepositoryTest {

    static IntrebariRepository intrebariRepository;

    @BeforeAll
    static void init() {
        intrebariRepository = new IntrebariRepository();
    }
    void addIntrebare(String enunt, String raspuns1, String raspuns2, String raspunsCorect, String categoria) throws Exception{
        Intrebare intrebare = new Intrebare(enunt, raspuns1, raspuns2, raspunsCorect, categoria);
        intrebariRepository.addIntrebare(intrebare);
    }

    @org.junit.jupiter.api.Test
    void TC01_EP() {
        String enunt = "Care este capitala Romaniei?";
        String raspuns1 = "1)Bucuresti";
        String raspuns2 = "2)Barcelona";
        String raspunsCorect = "1";
        String categoria = "Geografie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC01_EP -> intrebare adaugata");
            assert(true);
        } catch (Exception ex) {
            System.out.println("TC01_EP -> " + ex.getMessage());
            assert(false);
        }
    }

    @org.junit.jupiter.api.Test
    void TC03_EP() {
        String enunt = "Care este capitala Romaniei?";
        String raspuns1 = "1)Bucuresti";
        String raspuns2 = "2)Barcelona";
        String raspunsCorect = "asd";
        String categoria = "Geografie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC03_EP -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC03_EP -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC04_EP() {
        String enunt = "Care este capitala Romaniei?";
        String raspuns1 = "1)Bucuresti";
        String raspuns2 = "Pinguin";
        String raspunsCorect = "1";
        String categoria = "Geografie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC04_EP -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC04_EP -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC05_EP() {
        String enunt = "Care este capitala Romaniei?";
        String raspuns1 = "Pinguin";
        String raspuns2 = "2)Barcelona";
        String raspunsCorect = "1";
        String categoria = "Geografie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC05_EP -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC05_EP -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC07_EP() {
        String enunt = "Care este capitala Romaniei?";
        String raspuns1 = "1)Bucuresti";
        String raspuns2 = "2)Barcelona";
        String raspunsCorect = "4";
        String categoria = "Geografie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC07_EP -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC07_EP -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC02_BVA() {
        String enunt = "pinguin";
        String raspuns1 = "1)Pinguin";
        String raspuns2 = "2)Pinguin";
        String raspunsCorect = "1";
        String categoria = "Categorie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC02_BVA -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC02_BVA -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC05_BVA() {
        String enunt = "Pinguin?";
        String raspuns1 = "1)Pinguin";
        String raspuns2 = "2)Pinguin";
        String raspunsCorect = "1";
        String categoria = "Categorie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC05_BVA -> intrebare adaugata");
            assert(true);
        } catch (Exception ex) {
            System.out.println("TC05_BVA -> " + ex.getMessage());
            assert(false);
        }
    }

    @org.junit.jupiter.api.Test
    void TC08_BVA() {
        String enunt = "Pinguin?";
        String raspuns1 = "pinguin";
        String raspuns2 = "2)Pinguin";
        String raspunsCorect = "1";
        String categoria = "Categorie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC08_BVA -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC08_BVA -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC15_BVA() {
        String enunt = "Pinguin?";
        String raspuns1 = "1)Pinguin";
        String raspuns2 = "2)Pinguin";
        String raspunsCorect = "";
        String categoria = "Categorie";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC15_BVA -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC15_BVA -> " + ex.getMessage());
            assert(true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC22_BVA() {
        String enunt = "Pinguin?";
        String raspuns1 = "1)Pinguin";
        String raspuns2 = "2)Pinguin";
        String raspunsCorect = "1";
        String categoria = "pinguin";
        try {
            addIntrebare(enunt,raspuns1,raspuns2,raspunsCorect,categoria);
            System.out.println("TC22_BVA -> intrebare adaugata");
            assert(false);
        } catch (Exception ex) {
            System.out.println("TC15_BVA -> " + ex.getMessage());
            assert(true);
        }
    }
}