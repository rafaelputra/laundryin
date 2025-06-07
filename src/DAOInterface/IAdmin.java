/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

import Model.Adminpage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rafaelputra
 */
public interface IAdmin
    {
        public List<Adminpage> getAll();
        public void insert(Adminpage b);
        public Map<String, Integer> getDriverNameIdMap();
        public List<Adminpage> getCariId(int id);
        public void update(Adminpage b);
        public void delete(int id);
    }
