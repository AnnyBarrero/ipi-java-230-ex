package com.ipiecoles.java.java230;
import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.model.Manager;
import com.ipiecoles.java.java230.model.Technicien;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.repository.ManagerRepository;
import com.ipiecoles.java.java230.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void run(String... strings) throws Exception {
        List<Technicien> techniciens = technicianRepository.findByManagerNom("Laine");
        for (Technicien t : techniciens){
            System.out.println(t);
            System.out.println(t.getManager());
        }
        Manager manager = managerRepository.findById(5L).get();
        System.out.println(manager.toString());
        for(Technicien t : manager.getEquipe()){
            System.out.println(t);
        }




    }

    public static void print(Object t) {
        System.out.println(t);
    }
}