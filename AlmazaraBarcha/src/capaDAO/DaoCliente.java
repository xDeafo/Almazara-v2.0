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

public class DaoCliente {

    /**
     * M�todo que, dado un Cliente, lo inserte.
     *
     * @param c
     * @return 
     * @throws BusinessException
     */
    public static boolean insertar(Cliente c) throws BusinessException {
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
                    "Error al insertar cliente", e);
            throw new BusinessException("Error al insertar cliente");
        }

        return result;
    }

    public static List<Cliente> getClientes() throws BusinessException {
        Session s = UtilesHibernate.getSession();

        List<Cliente> lista = new ArrayList<>();
        String hql = "SELECT c FROM Cliente c";

        try {
            lista = (List<Cliente>) s.createQuery(hql).list();

        } catch (Exception e) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al consultar la lista de los clientes", e);
            throw new BusinessException("Error al consultar lista de clientes");
        }

        return lista;
    }

    public static Cliente getCliente(String nombre) throws BusinessException {
        Session s = UtilesHibernate.getSession();

        Cliente c = new Cliente();

        try {
            String sql = "SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre";

            if (nombre != null) {
                c = (Cliente) (s.createQuery(sql).setParameter("nombre", nombre)).uniqueResult();

            }
        } catch (Exception e) {

            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al consultar los cliente", e);
            throw new BusinessException(
                    "Error al consultar usuarios por cliente");

        }

        return c;
    }

    public static boolean borrarCliente(String nombre) throws BusinessException {
        boolean result = false;
        Session s = UtilesHibernate.getSession();
        Transaction tx = s.beginTransaction();
        try {

            String borrarCliente = "DELETE FROM Cliente WHERE nombre = :nombre";

            (s.createQuery(borrarCliente).setParameter("nombre", nombre)).executeUpdate();

            tx.commit();
            result = true;

        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE,
                    "Error al borrar cliente", e);

            throw new BusinessException("Error al borrar cliente");
        }

        return result;
    }

    public static boolean update(Cliente c) throws BusinessException {
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
                    "Error al actualizar cliente", e);
            throw new BusinessException("Error al actualizar cliente");
        }

        return result;
    }

}
