package capaDAO;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Producto;

public class DaoProducto {

    public static boolean insertar(Producto p) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();

        try {
            s.save(p);
            result = true;
        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al insertar producto", e);
            throw new BusinessException("Error al insertar producto");
        }

        return result;
    }

    public static Producto getProducto(String nombre) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        Producto p = new Producto();

        try {
            String sql = "SELECT p FROM Producto p WHERE p.nombre LIKE :nombre";

            if (nombre != null) {
                p = (Producto) (s.createQuery(sql).setParameter("nombre", nombre)).uniqueResult();

            }
        } catch (Exception e) {

            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al consultar los productos", e);
            throw new BusinessException(
                    "Error al consultar productos");

        }

        return p;
    }

    public static List<Producto> getProductos() throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Producto> lista = new ArrayList<>();
        String hql = "SELECT p FROM Producto p";

        try {
            lista = (List<Producto>) s.createQuery(hql).list();

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de productos", e);
            throw new BusinessException("Error al consultar lista de productos");
        }

        return lista;
    }

    public static boolean update(Producto p) throws BusinessException {
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
                    "Error al actualizar producto", e);
            throw new BusinessException("Error al actualizar producto");
        }
        
        s.close();
        return result;
    }
}
