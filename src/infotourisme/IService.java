/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infotourisme;

import java.sql.SQLException;
import java.util.List;



public interface IService<T> {
    void ajouter(T v) throws SQLException;
    boolean delete(T v) throws SQLException;
    void update(T v) throws SQLException;
    List<T> readAll() throws SQLException;
}


    

