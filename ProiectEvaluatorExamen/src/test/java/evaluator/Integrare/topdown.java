package evaluator.Integrare;

import evaluator.controller.AppController;
import evaluator.model.Intrebare;
import evaluator.repository.IntrebariRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class topdown {

    AppController appController;
    IntrebariRepository intrebariRepository;

    @BeforeEach
    void clear() {
        appController = new AppController();
        intrebariRepository = new IntrebariRepository();
    }


    void addIntrebare(String enunt, String raspuns1, String raspuns2, String raspunsCorect, String categoria) throws Exception {
        Intrebare intrebare = new Intrebare(enunt, raspuns1, raspuns2, raspunsCorect, categoria);
        intrebariRepository.addIntrebare(intrebare);
    }

    @Test
    void firstTest() {
        try {
            appController.createNewTest();
            assert false;
        } catch (Exception ex) {
            assert true;
        }
    }

    @Test
    void secondTest() {
        firstTest();
        String enunt = "Care este capitala Romaniei?";
        String raspuns1 = "1)Bucuresti";
        String raspuns2 = "2)Barcelona";
        String raspunsCorect = "1";
        String categoria = "Geografie";
        try {
            addIntrebare(enunt, raspuns1, raspuns2, raspunsCorect, categoria);
            System.out.println("TC01_EP -> intrebare adaugata");
            assert (true);
        } catch (Exception ex) {
            System.out.println("TC01_EP -> " + ex.getMessage());
            assert (false);
        }
    }

    @Test
    void thirdTest() {
        secondTest();
        try {
            appController.getStatistica();
            assert false;
        } catch (Exception ex) {
            assert true;
        }
    }
}
