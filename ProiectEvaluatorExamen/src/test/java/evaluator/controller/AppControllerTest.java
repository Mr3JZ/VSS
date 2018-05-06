package evaluator.controller;

import evaluator.model.Intrebare;
import evaluator.repository.IntrebariRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    static AppController appController;
    @BeforeAll
    static void init() {
        appController = new AppController();
    }
    @BeforeEach
    void clear() {
        appController = new AppController();
    }

    void addWithSameDomains() {
        try {
            appController.addNewIntrebare(new Intrebare("Enunt1?", "1)Varianta 11", "2)Varianta 21", "1", "Domeniu"));
            appController.addNewIntrebare(new Intrebare("Enunt2?", "1)Varianta 12", "2)Varianta 22", "1", "Domeniu"));
            appController.addNewIntrebare(new Intrebare("Enunt3?", "1)Varianta 13", "2)Varianta 23", "1", "Domeniu"));
            appController.addNewIntrebare(new Intrebare("Enunt4?", "1)Varianta 14", "2)Varianta 24", "1", "Domeniu"));
            appController.addNewIntrebare(new Intrebare("Enunt5?", "1)Varianta 15", "2)Varianta 25", "1", "Domeniu"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    void Req02_TC01() {
        try {
            appController.createNewTest();
            assert false;
        } catch(Exception ex) {
            assert true;
        }
    }

    @Test
    void Req02_TC02() {
        try {
            addWithSameDomains();
            appController.createNewTest();
            assert false;
        } catch(Exception ex) {
            assert true;
        }
    }

    @Test
    void Req02_TC03() {
        try {
            addWithDifferentDomains();
            appController.createNewTest();
            assert true;
        } catch(Exception ex) {
            assert false;
        }
    }
}