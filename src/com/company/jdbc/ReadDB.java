package com.company.jdbc;

import com.company.domain.*;
import com.company.exceptions.InvalidDataException;
import com.company.service.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDB {
    private static ReadDB rdb = null;

    private ReadDB(){
    }

    public static ReadDB getInstance(){
        if(rdb == null)
            rdb = new ReadDB();
        return rdb;
    }

    public void loadStudent(StudentService s, Statement stmt){
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM studenti");
            while(rs.next()){
                s.registerNewStudent(
                                rs.getString("prenume"),
                                rs.getString("nume"),
                                rs.getString("clasa"),
                                rs.getString("grupa"),
                                rs.getString("an")
                        );
            }

        }catch (SQLException e){
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public void loadCurs(CursService c,Statement stmt){
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM cursuri");
            while(rs.next()){
                c.registerNewCurs(
                        rs.getString("nume"),
                        rs.getString("ora"),
                        rs.getString("zi"),
                        rs.getString("data_examen"),
                        rs.getString("ora_examen"),
                        rs.getString("sala_examen")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public void loadProfesor(ProfesorService p,Statement stmt){
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM profesori");
            while(rs.next()){
                p.registerNewProfesor(
                        rs.getString("prenume"),
                        rs.getString("nume"),
                        rs.getString("nume_curs"),
                        rs.getString("ora_curs"),
                        rs.getString("zi_curs"),
                        rs.getString("data_examen"),
                        rs.getString("ora_examen"),
                        rs.getString("sala_examen")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (InvalidDataException e){
            e.printStackTrace();
        }
    }

    public void loadObjects(StudentService s,ProfesorService p,CursService c){
        try{
            DBconn dbconn = DBconn.getInstance();
            Statement stmt = dbconn.getConn().createStatement();
            loadCurs(c,stmt);
            loadProfesor(p,stmt);
            loadStudent(s,stmt);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}