package evaluator.controller;

import evaluator.model.Intrebare;
import evaluator.repository.IntrebariRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest2 {

    static AppController appController;

    @BeforeAll
    static void init() {
        appController = new AppController();
    }

    @BeforeEach
    void clear() {
        appController = new AppController();
    }


    void addWithDifferentDomains() {
        try {
            appController.addNewIntrebare(new Intrebare("Enunt1?", "1)Varianta 11", "2)Varianta 21", "1", "Domeniu1"));
            appController.addNewIntrebare(new Intrebare("Enunt2?", "1)Varianta 12", "2)Varianta 22", "1", "Domeniu2"));
            appController.addNewIntrebare(new Intrebare("Enunt3?", "1)Varianta 13", "2)Varianta 23", "1", "Domeniu3"));
            appController.addNewIntrebare(new Intrebare("Enunt4?", "1)Varianta 14", "2)Varianta 24", "1", "Domeniu4"));
            appController.addNewIntrebare(new Intrebare("Enunt5?", "1)Varianta 15", "2)Varianta 25", "1", "Domeniu5"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    void getStatisticaInvalid() {
        try {
            appController.getStatistica();
            assert false;
        } catch (Exception ex) {
            assert true;
        }
    }

    @Test
    void getStatisticaValid() {
        try {
            addWithDifferentDomains();
            appController.getStatistica();
            assert true;
        } catch (Exception ex) {
            assert false;
        }
    }
}