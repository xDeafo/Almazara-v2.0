package capaDAO;

import excepciones.BusinessException;
import hibernate.UtilesHibernate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Cliente;
import pojos.Compra;
import pojos.Proveedor;

public class DaoCompra {
    
   public static List<Compra> getCompras(Cliente c) throws BusinessException {

        Session s = UtilesHibernate.getSession();

        List<Compra> lista = new ArrayList<>();
        String hql = "SELECT idCompra, kgOliva, precioKg, fecha FROM Compra c WHERE c.Cliente_idCliente = "
                + "(SELECT idCliente FROM Cliente WHERE nombre = :nombre";

        try {
            lista = (List<Compra>) s.createQuery(hql).setParameter("nombre", c.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoCompra.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de compras", e);
            throw new BusinessException("Error al consultar lista de compras");
        }

        return lista;

    }

    public static boolean insertar(Compra c) throws BusinessException {
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
                    "Error al insertar compra", e);
            throw new BusinessException("Error al insertar compra");
        }

        return result;

    }

    public static List<Compra> getComprasNoPagadas(Proveedor p) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Compra> lista = new ArrayList<>();
        String hql = "SELECT c FROM Compra c WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE :nombre) AND Pagado = 0";

        try {
            lista = (List<Compra>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoCompra.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de Compras", e);
            throw new BusinessException("Error al consultar lista de Compras");
        }

        return lista;
    }

    public static List<Compra> getComprasPagadas(Proveedor p) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Compra> lista = new ArrayList<>();
        String hql = "SELECT c FROM Compra c WHERE Proveedor_idProveedor = "
                + "(SELECT idProveedor FROM Proveedor WHERE nombre LIKE :nombre) AND Pagado = 1";

        try {
            lista = (List<Compra>) s.createQuery(hql).setParameter("nombre", p.getNombre()).list();

        } catch (Exception e) {

            Logger.getLogger(DaoCompra.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de Compras", e);
            throw new BusinessException("Error al consultar lista de Compras");
        }

        return lista;
    }
    
    public static List<Compra> getTodasCompras() throws BusinessException {

        Session s = UtilesHibernate.getSession();

        List<Compra> lista = new ArrayList<>();
        String hql = "SELECT c FROM Compra c";

        try {
            lista = (List<Compra>) s.createQuery(hql).list();

        } catch (Exception e) {

            Logger.getLogger(DaoCompra.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de compras", e);
            throw new BusinessException("Error al consultar lista de compras");
        }

        return lista;

    }

    public static boolean update(Compra compra) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            s.update(compra);
            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoCompra.class.getName()).log(Level.SEVERE,
                    "Error al actualizar la molturacion", e);
            throw new BusinessException("Error al actualizar la molturacion");
        }

        return result;
    }
}
