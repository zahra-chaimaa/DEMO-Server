package com.example.demo.model;




///https://gaia.fdi.ucm.es/research/colibri/jcolibri/doc/apidocs/src-html/es/ucm/fdi/gaia/jcolibri/test/test1/Test1.html



import com.example.demo.repository.MaladieInsertRepo;
import es.ucm.fdi.gaia.jcolibri.casebase.LinealCaseBase;

import es.ucm.fdi.gaia.jcolibri.cbraplications.StandardCBRApplication;
import es.ucm.fdi.gaia.jcolibri.cbrcore.*;
import es.ucm.fdi.gaia.jcolibri.connector.DataBaseConnector;
import es.ucm.fdi.gaia.jcolibri.exception.ExecutionException;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.GlobalSimilarityFunction;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.selection.SelectCases;
import es.ucm.fdi.gaia.jcolibri.util.FileIO;

import jcolibri.method.retrieve.NNretrieval.similarity.local.similaritry.Euclidienne;

import java.util.ArrayList;
import java.util.Collection;

//removing ABSTRACT when finishing implementation...
   public class Test1 implements StandardCBRApplication {


       Connector _connector;
       CBRCaseBase _caseBase;
       ArrayList<RetrievalResult> cases;
       public Collection<CBRCase> casestoreturn;
       public Collection<CBRCase> casestoreturnfirst;
       public Collection<RetrievalResult> evaltogather;
      public Collection<CBRCase> publiccasess = null;
       public void configure() throws ExecutionException {

// Create a data base connector
           try {
               _connector = (Connector) new DataBaseConnector();
//            // Init the ddbb connector with the config file
               _connector.initFromXMLfile(FileIO.findFile("C:\\DEMO-Server\\demo\\src\\main\\java\\com\\example\\demo\\model\\databaseconfig.xml"));
               // Create a Lineal case base for in-memory organization
               _caseBase = (CBRCaseBase) new LinealCaseBase();
           } catch (Exception e) {
               throw new ExecutionException(e);

           }
       }

       public CBRCaseBase preCycle() throws ExecutionException {

           _caseBase.init(_connector);
           publiccasess = _caseBase.getCases();
          Collection<CBRCase> cases = _caseBase.getCases();
           for (CBRCase c : _caseBase.getCases()) {
              // c.setSolution(MaladieInsertRepo.manualSolutionMaking((String) c.getID()));

              c.setSolution(MaladieInsertRepo.manualSolutionMaking((String) c.getID()));
               System.out.println(c);
               //System.out.println("****"+MaladieInsertRepo.manualSolutionMaking((String) c.getID()));
           }
           return _caseBase;

       }

    @Override
    public void cycle(CBRQuery query) throws ExecutionException {

    }


    public void cycle(CBRQuery cbrQuery, int k) {
           NNConfig config = new NNConfig();
           Attribute attribute;
           LocalSimilarityFunction function;
           attribute = new Attribute("sa", caseDescription.class);
           config.addMapping(attribute,new Equal());
           //fonction de similarite local
           attribute = new Attribute("t", caseDescription.class);
           config.addMapping(attribute,(LocalSimilarityFunction) new Equal());

           attribute = new Attribute("ht", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());


           attribute = new Attribute("aus", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT14");
           attribute = new Attribute("des", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT9");
           attribute = new Attribute("kt", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config.setWeight(attribute, 0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT22");
           attribute = new Attribute("abl", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config.setWeight(attribute, 0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT23");
           attribute = new Attribute("infkt", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config. setWeight(attribute,0.1);
           attribute = new Attribute("sec", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT10");
           attribute = new Attribute("msec", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());

           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT11");
           attribute = new Attribute("tou", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT12");
           attribute = new Attribute("dys", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT13");
           //JOptionPane.showConfirmDialog(null, "DEBUT15");
           attribute = new Attribute("su", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT16");
           attribute = new Attribute("pyu", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT17");
           attribute = new Attribute("brm", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT18");
           attribute = new Attribute("dsp", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT19");
           attribute = new Attribute("lu", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
          // config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT20");
           attribute = new Attribute("fr", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute,0.1);
           //JOptionPane.showConfirmDialog(null, "DEBUT21");
           attribute = new Attribute("gb", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute, 0.1);
           //JOptionPane.showConfirmDialog(null, "FIN5");
           //JOptionPane.showConfirmDialog(null, "DEBUT6");
           attribute = new Attribute("crp", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //JOptionPane.showConfirmDialog(null, "FIN6");
           //config.setWeight(attribute,0.1);
           //config.setWeight(attribute, similConfig.getWeight());
           //JOptionPane.showConfirmDialog(null, "DEBUT7");
           attribute = new Attribute("pct", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
          // config.setWeight(attribute, 1.0);
           //JOptionPane.showConfirmDialog(null, "DEBUT8");
           attribute = new Attribute("rx", caseDescription.class);
           config.addMapping(attribute, (LocalSimilarityFunction) new Equal());
           //config.setWeight(attribute, 0.1);

           config.setDescriptionSimFunction((GlobalSimilarityFunction) new Average());
           // Execute NN
           Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), cbrQuery, config);
           System.out.println(eval);
           evaltogather = eval;
           Collection<CBRCase> selectedcases = SelectCases.selectTopK(evaltogather,k);
           System.out.println("retrieve cases");
           for(RetrievalResult nse: eval)
               System.out.println(nse);
             System.out.println(selectedcases);
             showCases(eval, selectedcases);

       }


       public void postCycle() throws ExecutionException {
           this._caseBase.close();

       }


    public void showCases(Collection<RetrievalResult> eval, Collection<CBRCase> selected) {
        cases = new ArrayList<RetrievalResult>();
        for (RetrievalResult rr : eval) {
            if (selected.contains(rr.get_case())) {
                cases.add(rr);
            }
        }
        System.out.println("casessss");
        System.out.println(cases);
        System.out.println("I'm gonna print my cases from each one i get the description and the solution");
        for (int i = 0; i < cases.size(); i++) {
            RetrievalResult rr_case = cases.get(i);
            CBRCase mycase = rr_case.get_case();
            //for each case i get the description
            caseDescription desc =(caseDescription) mycase.getDescription();
            System.out.println("Case description");
            System.out.println(desc);
            //i get the solution
            //beggining of modifications
            //before getting it i will retrieve the id and modify the id and intead change it from the database since i have the id
            MaladieInsertRepo mip = new MaladieInsertRepo();

            mycase.setSolution(mip.manualSolutionMaking(desc.getId()));

            //end of modification
            caseSolution sol = (caseSolution) mycase.getSolution();
            System.out.println("Case solution");
            System.out.println("These are Individual Case Id");
            System.out.println("Case ID : " + desc.getId() );
            System.out.println(sol);
        }
    }


   }

