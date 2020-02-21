package com.p7.mse.controlleur;

import com.p7.mse.entity.Emprunt;
import com.p7.mse.entity.Users;
import com.p7.mse.exception.EmpruntNotFoundException;
import com.p7.mse.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class EmpruntController {

    @Autowired
    Emprunt emprunt;

    @Autowired
    EmpruntService empruntService;

    @GetMapping(value = {"/allEmprunt"})
    public List<Emprunt> getAllEmprunts() throws EmpruntNotFoundException {

        List<Emprunt> emprunts = null;
        try {
            emprunts = (List<Emprunt>) empruntService.getAllEmprunt();
        } catch(Exception e) {
            throw new EmpruntNotFoundException("Il n'y a pas d'emprunt dans la base de donnée "+e);
        }
        return emprunts;
    }

    @GetMapping(value = {"/allEmpruntByUsers"})
    public List<Emprunt> getEmpruntByUsers(Long id) throws EmpruntNotFoundException {

        List<Emprunt> emprunts = null;
        try {
            emprunts = (List<Emprunt>) empruntService.getEmpruntByUsersId(id);
        } catch(Exception e) {
            throw new EmpruntNotFoundException("Il n'y a pas d'emprunt pour cette utilisateur dans la base de donnée "+e);
        }
        return emprunts;
    }

    @GetMapping(value = {"/allEmpruntUsersLate"})
    public List<Users> getAllEmpruntUsersLate() throws EmpruntNotFoundException {

        List<Emprunt> allEmprunt = getAllEmprunts();
        List<Users> users = new ArrayList<Users>();

        Date todayDate = new Date();

        for (int i = 0; i < allEmprunt.size(); i++) {
            Date empruntDate = allEmprunt.get(i).getDate();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(empruntDate);

            calendar.add(Calendar.DATE, 30);

            Date empruntEndingDate = calendar.getTime();

            if (todayDate.compareTo(empruntEndingDate) > 0) {
                List<Users> user = null;
                try {
                    user = usersEmprunt(allEmprunt.get(i).getId());
                } catch (Exception e) {
                    throw new EmpruntNotFoundException("There isn't person for this loan..." + allEmprunt.get(i).getId() + ' ' + e);
                }
                Users usersX = user.get(0);

                users.add(usersX);
            }
        }
        return users;
    }

    @GetMapping(value = {"/getEmpruntUsers/{empruntId}"})
    private List<Users> usersEmprunt(@PathVariable Long empruntId) throws EmpruntNotFoundException {

            List<Users> users;
            try {
                Optional<Emprunt> optionalEmprunt = empruntService.getEmprunt(empruntId);
                Emprunt emprunt = optionalEmprunt.get();
                try {
                    users = emprunt.getUsersEmprunt();
                } catch (Exception e) {
                    throw new EmpruntNotFoundException("There is no person for this id "+empruntId+" "+e);
                }
            } catch(Exception e) {
                throw new EmpruntNotFoundException("There is no loans for this person id "+empruntId+" "+e);
            }

            return users;
        }

    }
