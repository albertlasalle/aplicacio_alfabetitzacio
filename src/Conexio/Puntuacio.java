/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexio;

import Fills.SeleccionarFills;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author Albert
 */
public class Puntuacio {

    ConexioBD con = new ConexioBD();

    Connection cn = con.Conexion();
    
    

    public void RegistrarPuntuacio(int RespostaCorrecta, String TipusPuntuacio) {

        Statement stmt;

        try {
            stmt = (Statement) cn.createStatement();

            String sql = "UPDATE `puntuacio` SET `" + TipusPuntuacio + "`= `" + TipusPuntuacio + "`+ '" + RespostaCorrecta + "' WHERE fill_id = '" + SeleccionarFills.getIdFill() + "'";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            
            
            Logger.getLogger(Puntuacio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

   

    

    public void SumarPuntuacioTotal() {

        Statement stmt;

        try {
            stmt = (Statement) cn.createStatement();

            String sql = "UPDATE `puntuacio` SET `puntuacio_total`= puntuacio_lletres + puntuacio_numeros + puntuacio_paraules WHERE fill_id = '" + SeleccionarFills.getIdFill() + "'";
            System.out.println(sql);
            stmt.executeUpdate(sql);



        } catch (SQLException ex) {

            Logger.getLogger(Puntuacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int PuntuacioTotal(){
        
        int PuntuacioTotal = 0;
        
        Statement stmt;
        
        try{
            
            stmt = (Statement) cn.createStatement();
            
            String sql2 = "SELECT `puntuacio_total` FROM `puntuacio` WHERE fill_id = '" + SeleccionarFills.getIdFill() + "'";
            ResultSet rs = stmt.executeQuery(sql2);

            if (rs.next()) {

                PuntuacioTotal = rs.getInt("Puntuacio_total");

                

            }
            
        }catch(SQLException ex){
            Logger.getLogger(Puntuacio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return PuntuacioTotal;
    }

}
