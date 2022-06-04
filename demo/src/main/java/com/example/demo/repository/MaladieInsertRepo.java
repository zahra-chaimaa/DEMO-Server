package com.example.demo.repository;



import com.example.demo.DTO.CaseToRetainDTO;
import com.example.demo.model.caseDescription;
import com.example.demo.model.caseSolution;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;

import java.sql.*;

public class MaladieInsertRepo {
    static final String DB_URL = "jdbc:mysql://localhost:3306/pfe";
    static final String USER = "root";
    static final String PASS = "";
public static CaseComponent manualSolutionMaking(String idOfCase) {
    caseSolution solll = new caseSolution();
    try {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String query =  "SELECT p, u, b, skt, autr, pas, conf FROM casebase WHERE id = ?";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1,idOfCase);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            solll.setId(idOfCase);
            solll.setAutr(Integer.parseInt(rs.getString("autr")));
            solll.setP(Integer.parseInt(rs.getString("p")));
            solll.setB(Integer.parseInt(rs.getString("b")));
            solll.setPas(Integer.parseInt(rs.getString("pas")));
            solll.setSkt(Integer.parseInt(rs.getString("skt")));
            solll.setU(Integer.parseInt(rs.getString("u")));
            solll.setConf(Integer.parseInt(rs.getString("conf")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    return solll;
}

    public void caseInsert(CaseToRetainDTO mycasetoretain) {
        int mynewid = 1;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Inserting ...");
            //https://www.tutorialspoint.com/jdbc/statement-object-example.htm
            PreparedStatement st = conn.prepareStatement("select id from maladies where id = ?");
            st.setDouble(1,mynewid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mynewid = Integer.parseInt(rs.getString(1));
                mynewid++;
                st.setDouble(1,mynewid);
                rs= st.executeQuery();
            }
            String sql = "Insert into malady (Age, sexe, Poids, Temperature, Pas, pad, Fc, tempextr, diurese," +
                    " marbure, trc, spo2, fr, cyanose, rales, EncBranchique, glasgow, tonus, conscient, convulsion," +
                    " vomissement, motrice, mouvement, reflexe, fracture, Oedeme, corpsE, hemoragie, o2ther, ssi, supportHemo," +
                    " sedation, intubation, ventilation, pic," +
                    " osmotherapie, Id) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement pst = conn.prepareStatement(sql);
            caseDescription description = mycasetoretain.getDescription();
            caseSolution solution = mycasetoretain.getSolution();
          //  pst.setDouble(1, description.getAge());


            pst.setString(37, String.valueOf(mynewid));

            pst.executeUpdate();
            System.out.println("Case with Id " +mynewid + " has been added to the database!");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public static void main(String[] args) {
//        // Open a connection
//        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement stmt = conn.createStatement();
//        ) {
//            // Execute a query
//            System.out.println("Inserting records into the table...");
//            String sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Ali', 18)";
//            stmt.executeUpdate(sql);
//            sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
//            stmt.executeUpdate(sql);
//            sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
//            stmt.executeUpdate(sql);
//            sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
//            stmt.executeUpdate(sql);
//            System.out.println("Inserted records into the table...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
