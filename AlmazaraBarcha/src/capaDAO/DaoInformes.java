package capaDAO;

import almazarabarcha.Modelo.Informes;
import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Cambio;
import pojos.Cliente;
import pojos.Molturacion;
import pojos.Producto;
import pojos.Proveedor;

public class DaoInformes {

    public static ArrayList<String> getOlivaEntrada() throws BusinessException {

        Session s = UtilesHibernate.getSession();

        List<String> lista = new ArrayList<>();
        String hql = "SELECT kgOliva FROM Molturacion m Order by fecha";

        try {
            lista = (List<String>) s.createQuery(hql).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de molturaciones", e);
            throw new BusinessException("Error al consultar lista de molturaciones");
        }

        return (ArrayList<String>) lista;

    }

    public static boolean insertar(Cambio c) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {
            s.save(c);
            result = true;

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al insertar cambio", e);
            throw new BusinessException("Error al insertar cambio");
        }

        return result;
    }
    
     public static List<Cambio> getTodosCambios() throws BusinessException {

        Session s = UtilesHibernate.getSession();

        List<Cambio> lista = new ArrayList<>();
        String hql = "SELECT c FROM Cambio c";

        try {
            lista = (List<Cambio>) s.createQuery(hql).list();

        } catch (Exception e) {

            Logger.getLogger(DaoMolturacion.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de cambios", e);
            throw new BusinessException("Error al consultar lista de cambios");
        }

        return lista;

    }

    public static List<Cambio> getCambiosNoPagadas(Proveedor p) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Cambio> lista = new ArrayList<>();
        String hql = "SELECT c FROM Cambio c WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE :nombre) AND paga = 0";

        try {
            lista = (List<Cambio>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoCambio.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de Cambios", e);
            throw new BusinessException("Error al consultar lista de Cambios");
        }

        return lista;
    }

    public static List<Cambio> getCambiosPagadas(Proveedor p) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Cambio> lista = new ArrayList<>();
        String hql = "SELECT c FROM Cambio c WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE :nombre) AND paga = 1";

        try {
            lista = (List<Cambio>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoCambio.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de Cambios", e);
            throw new BusinessException("Error al consultar lista de Cambios");
        }

        return lista;
    }
    
    public static boolean update(Cambio c) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            s.merge(c);
            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al actualizar un cambio", e);
            throw new BusinessException("Error al actualizar un cambio");
        }
        
        s.close();
        return result;
    }
    
}
