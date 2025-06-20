/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

import Model.Driverpage;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface IDriver {
    public List<Driverpage> getAllJob(String username);
   public List<Driverpage> getCariId(int id,String username);
   boolean updateStatus(String id, String status);
   public List<Driverpage> getAll();
   public List<Driverpage> getCariIdDriver(int id);
   public void insert(Driverpage b);
   public void delete(int id);
   public void update(Driverpage b);
}
