package com.company.jdbc;

import com.company.domain.*;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteDB {
    private static WriteDB wdb = null;
    private final DBconn dbconn = DBconn.getInstance();
    private Statement stmt = null;

    private WriteDB() {
    }

    public static WriteDB getInstance() {
        if(wdb == null)
            wdb = new WriteDB();
        return wdb;
    }

    public void writeStudent(Student student){
        if(dbconn.getConn() != null){
            try{
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO studenti VALUES("+
                        "\"" + student.getPrenume() + "\"" + "," +
                        "\"" + student.getNume() + "\"" + "," +
                        "\"" + student.getClasa() + "\"" + "," +
                        "\"" + student.getGrupa() + "\"" + "," +
                        "\"" + student.getAn() + "\"" + "," +
                        ")");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void writeCurs(Curs curs){
        if(dbconn.getConn() != null){
            try{
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO cursuri VALUES("+
                        "\"" + curs.getNume() + "\"" + "," +
                        "\"" + curs.getOra() + "\"" + "," +
                        "\"" + curs.getZi() + "\"" + "," +
                        "\"" + curs.getExamen().getData_examen() + "\"" + "," +
                        "\"" + curs.getExamen().getOra_examen() + "\"" + "," +
                        "\"" + curs.getExamen().getSala() + "\"" + "," +
                        ")");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void writeProfesor(Profesor profesor){
        if(dbconn.getConn() != null){
            try{
                stmt = dbconn.getConn().createStatement();
                stmt.execute("INSERT INTO profesori VALUES("+
                        "\"" + profesor.getPrenume() + "\"" + "," +
                        "\"" + profesor.getNume() + "\"" + "," +
                        "\"" + profesor.getCurs().getNume() + "\"" + "," +
                        "\"" + profesor.getCurs().getOra() + "\"" + "," +
                        "\"" + profesor.getCurs().getZi() + "\"" + "," +
                        "\"" + profesor.getCurs().getExamen().getData_examen() + "\"" + "," +
                        "\"" + profesor.getCurs().getExamen().getOra_examen() + "\"" + "," +
                        "\"" + profesor.getCurs().getExamen().getSala() + "\"" + "," +
                        ")");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
