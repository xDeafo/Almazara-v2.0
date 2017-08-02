package capaDAO;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Molturacion;
import pojos.Proveedor;

public class DaoMolturacion {

    public static List<Molturacion> getMolturaciones(Proveedor p) throws BusinessException {

        Session s = UtilesHibernate.getSession();

        List<Molturacion> lista = new ArrayList<>();
        String hql = "SELECT idMolturacion, kgOliva, fecha FROM Molturacion m WHERE m.Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre = :nombre";

        try {
            lista = (List<Molturacion>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de molturaciones", e);
            throw new BusinessException("Error al consultar lista de molturaciones");
        }

        return lista;

    }



    public static boolean insertar(Molturacion m) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            s.save(m);
            result = true;

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al insertar molturacion", e);
            throw new BusinessException("Error al insertar molturacion");
        }

        return result;

    }

    public static boolean update(Molturacion m) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            s.update(m);
            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al actualizar la molturacion", e);
            throw new BusinessException("Error al actualizar la molturacion");
        }

        return result;
    }

    public static List<Molturacion> getMolturacionesNoPagadas(Proveedor p) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Molturacion> lista = new ArrayList<>();
        String hql = "SELECT m FROM Molturacion m WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE :nombre) AND Pagada = 0";

        try {
            lista = (List<Molturacion>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de molturaciones", e);
            throw new BusinessException("Error al consultar lista de molturaciones");
        }

        return lista;
    }

    public static List<Molturacion> getMolturacionesPagadas(Proveedor p) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Molturacion> lista = new ArrayList<>();
        String hql = "SELECT m FROM Molturacion m WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE :nombre) AND Pagada = 1";

        try {
            lista = (List<Molturacion>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de molturaciones", e);
            throw new BusinessException("Error al consultar lista de molturaciones");
        }

        return lista;
    }

    public static List<Molturacion> getMolturacionesTotales() throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Molturacion> lista = new ArrayList<>();
        String hql = "SELECT m FROM Molturacion m";
        //WHERE Proveedor_idProveedor = "
        //+ "(SELECT idProveedor FROM Proveedor WHERE nombre NOT LIKE 'almazara' OR nombre NOT LIKE 'Almazara')
        try {
            lista = (List<Molturacion>) s.createQuery(hql).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de molturaciones", e);
            throw new BusinessException("Error al consultar lista de molturaciones");
        }

        return lista;
    }

    public static List<Molturacion> getMolturacionesAlmazara() throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Molturacion> lista = new ArrayList<>();
        String hql = "SELECT m FROM Molturacion m WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE 'almazara')";
        //WHERE Proveedor_idProveedor = "
        //+ "(SELECT idProveedor FROM Proveedor WHERE nombre NOT LIKE 'almazara' OR nombre NOT LIKE 'Almazara')
        try {
            lista = (List<Molturacion>) s.createQuery(hql).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de molturaciones", e);
            throw new BusinessException("Error al consultar lista de molturaciones");
        }

        return lista;
    }

}
