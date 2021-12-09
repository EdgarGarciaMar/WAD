/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Producto;
import com.ipn.mx.utilerias.hibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author edgargarcia
 */
public class ProductoDAO implements Serializable {

    public void create(Producto dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.save(dto);
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public void update(Producto dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(dto);
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public void delete(Producto dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(dto);
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public Producto read(Producto dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            dto = (s.get(dto.getClass(), dto.getIdProducto()));
            t.commit();
        } catch (HibernateException he) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
        return dto;
    }

    public List readAll() {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();//Linea que da null
        Transaction tx = s.getTransaction();
        List lista = new ArrayList();
        try {
            tx.begin();
            Query q = s.createQuery("from producto c order by c.idproducto");
            lista = q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return lista;
    }
    public static void main(String[] args) {
        Producto dto = new Producto();
        dto.setIdProducto(3);
        ProductoDAO dao = new ProductoDAO();
        System.out.println(dao.read(dto));
    }
}
