package com.example.demo.Controller;

import com.example.demo.model.Test1;
import com.example.demo.model.caseDescription;
import com.example.demo.model.caseSolution;

import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;

import es.ucm.fdi.gaia.jcolibri.exception.ExecutionException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class mainController {
    @GetMapping("/home")
    public String index(){
        return "Hello";
    }

    //THis next function is to return a trauma description case structure (as JSON)
    @GetMapping(value = "/getADescription")
    public caseDescription getAcaseDescription() {
        caseDescription desc = new caseDescription();
        return desc;
    }
    //THis next function is to return a trauma Solutiopn case structure (as JSON)
    @GetMapping(value = "/getASolution")
    public caseSolution getAcaseSolution() {
        caseSolution sol = new caseSolution();
        return sol;
    }
    @GetMapping(value = "/getACase")
    public CBRCase getAcase() {
        CBRCase mycase = new CBRCase();
        mycase.setDescription(new caseDescription());
        mycase.setSolution( new caseSolution());
        return mycase;
    }

    @GetMapping("/allCases")
            //passer un nouveau cas comme parmater ok
    public void showAllCases(@RequestBody caseDescription newcas) {
        //here we'll add a code just to import the casebase and print it to the console
        //We may return it to the client in JSON format jsut for example

        CBRQuery cbrQuery =new  CBRQuery();
        cbrQuery.setDescription(newcas);


        System.out.println("All cases has ben executed");
        Test1 test1 = new Test1() {
           // @Override
            public void cycle(CBRQuery cbrQuery) throws ExecutionException {
            }
        };
        try {
            //cle(hakda oui wach derti nti lfou9 raki );
            test1.configure();
            test1.preCycle();
            System.out.println("*********************************************************************");
            test1.cycle(cbrQuery,3);
            System.out.println("*********************************************************************");

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}
