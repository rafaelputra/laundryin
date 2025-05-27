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
    public List<Driverpage> getAllJob(String Username);
}
