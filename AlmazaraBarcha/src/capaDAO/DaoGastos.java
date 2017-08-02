/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDAO;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Gastos;

/**
 *
 * @author Ventura
 */
public class DaoGastos {
    public static List<Gastos> getGastos() throws BusinessException {

        Session s = UtilesHibernate.getSession();

        List<Gastos> lista = new ArrayList<>();
        String hql = "SELECT g FROM Gastos g";

        try {
            lista = (List<Gastos>) s.createQuery(hql).list();

        } catch (Exception e) {

            Logger.getLogger(DaoGastos.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de gastos", e);
            throw new BusinessException("Error al consultar lista de gastos");
        }

        return lista;

    }
    
    public static boolean insertar(Gastos g) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {
            
            s.save(g);
            result = true;

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoGastos.class.getName()).log(Level.SEVERE,
                    "Error al insertar gasto", e);
            throw new BusinessException("Error al insertar gasto");
        }

        return result;

    }
    public static boolean borrarGasto(int id) throws BusinessException {
        boolean result = false;      
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            String borrarGasto = "DELETE FROM Gastos WHERE idGasto = :id";

            (s.createQuery(borrarGasto).setParameter("id", id)).executeUpdate();

            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE,
                    "Error al borrar gasto", e);

            throw new BusinessException("Error al borrar gasto");
        }

        return result;
    }
}
