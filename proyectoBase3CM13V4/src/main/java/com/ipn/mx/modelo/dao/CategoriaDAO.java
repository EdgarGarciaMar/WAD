/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.utilerias.hibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import lombok.Data;
import lombok.AllArgsConstructor;
import org.hibernate.query.Query;


/**
 *
 * @author edgargarcia
 */
@Data
@AllArgsConstructor
public class CategoriaDAO implements Serializable{

    public void create(CategoriaDTO dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            s.save(dto.getEntidad());
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void update(CategoriaDTO dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            s.update(dto.getEntidad());
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void delete (CategoriaDTO dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            s.delete(dto.getEntidad());
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }
    
        public CategoriaDTO read (CategoriaDTO dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            dto.setEntidad(s.get(dto.getEntidad().getClass(), dto.getEntidad().getIdCategoria()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return dto;
    }
        
        public List readAll () {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();//Linea que da null
        Transaction tx = s.getTransaction();
        List lista = new ArrayList();
        try {
            tx.begin();
            Query q= s.createQuery("from Categoria c order by c.idCategoria");
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
        CategoriaDAO dao = new CategoriaDAO();
        System.out.println(dao.readAll());//linea que da null
    }
}
