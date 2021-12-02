/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

//import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.entidades.Categoria;
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

    public void create(Categoria dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            s.save(dto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void update(Categoria dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            s.update(dto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void delete (Categoria dto) {//Arreglar el delete, clase 27 youtube
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            s.delete(dto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }
    
        public Categoria read (Categoria dto) {
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try {
            tx.begin();
            dto=(s.get(dto.getClass(), dto.getIdCategoria()));
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
//            for (Categoria c: (List<Categoria>) q.list()) {
//                CategoriaDTO dto = new CategoriaDTO();
//                dto.setEntidad(c);
//                lista.add(dto);
//                
//            }
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
        
        Categoria dto = new Categoria();
        dto.setNombreCategoria("Categoria1");
        dto.setDescripcionCategoria("Descripcion categoria 1");
        //dto.setIdCategoria(1);
        //dao.create(dto);
        
        //dao.update(dto);
        
        System.out.println(dao.readAll());//linea que da null
    }
}
