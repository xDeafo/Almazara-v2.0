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
import pojos.Proveedor;

/**
 *
 * @author Usuario
 */
public class DaoProveedor {
    
    public enum GENEROS {terror,sci};
/**
     * M�todo que, dado un Cliente, lo inserte.
     *
     * @param p
     * @return 
     * @throws BusinessException
     */
    public static boolean insertar(Proveedor p) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {
            s.save(p);
            result = true;
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE,
                    "Error al insertar cliente", e);
            throw new BusinessException("Error al insertar cliente");
        }

        return result;
    }

    public static List<Proveedor> getProveedores() throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Proveedor> lista = new ArrayList<>();
        String hql = "SELECT p FROM Proveedor p";

        try {
            lista = (List<Proveedor>) s.createQuery(hql).list();

        } catch (Exception e) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de los proveedores", e);
            throw new BusinessException("Error al consultar lista de proveedores");
        }

        return lista;
    }

    public static Proveedor getProveedor(String nombre) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        Proveedor p = new Proveedor();

        try {
            String sql = "SELECT p FROM Proveedor p WHERE p.nombre LIKE :nombre";

            if (nombre != null) {
                p = (Proveedor) (s.createQuery(sql).setParameter("nombre", nombre)).uniqueResult();

            }
        } catch (Exception e) {

            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE,
                    "Error al consultar los proveedores", e);
            throw new BusinessException(
                    "Error al consultar usuarios por proveedor");

        }

        return p;
    }

    public static boolean borrarProveedor(String nombre) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            String borrarCliente = "DELETE FROM Proveedor WHERE nombre = :nombre";

            (s.createQuery(borrarCliente).setParameter("nombre", nombre)).executeUpdate();

            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE,
                    "Error al borrar proveedor", e);

            throw new BusinessException("Error al borrar proveedor");
        }

        return result;
    }

    public static boolean update(Proveedor p) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {
            
            s.merge(p);
            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al actualizar proveedor", e);
            throw new BusinessException("Error al actualizar proveedor");
        }

        return result;
    }

}
