/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

import Model.Homepage;
import java.util.List;

/**
 *
 * @author rafaelputra
 */
public interface ILaundryin
    {
        public List<Homepage> getAll();
        public List<Homepage> getCariId(int id);
    }
