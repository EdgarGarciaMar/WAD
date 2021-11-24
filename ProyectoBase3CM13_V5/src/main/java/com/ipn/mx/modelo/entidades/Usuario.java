/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author edgargarcia
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "apellidoPaterno", length = 50)
    private String paterno;
    @Column(name = "apellidoMaterno", length = 50)
    private String materno;
    @Column(name = "email", length = 100, unique = true)
    private String email;

    private String imagen;
    @Size(min = 8, max = 20, message = "El nombre debe tener un tamaño entre 8 y 20")
    @Column(name = "nombreUsuario", length = 20)
    private String nombreUsuario;

    @NotNull
    @Size(min = 5, max = 20, message = "La clave debe tener un tamaño entre 5 y 20")
    @Column(name = "claveUsuario", length = 20)
    private String claveUsuario;
    @Column(name = "tipoUsuario", length = 1)
    private String tipoUsuario;
    @Column(name = "createAt")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public static void main(String[] args) {
        Usuario u = new Usuario();
//        u.setNombre("Edgar");
//        u.setPaterno("Edgar");
//        u.setMaterno("Edgar");
//        u.setEmail("mail3@mail.com");
//        u.setNombreUsuario("EdgarGar");
//        u.setClaveUsuario("EdgarGar");
//        u.setTipoUsuario("A");
//        u.setImagen("sin imagen");
        //u.setIdUsuario(1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoBase3CM13V5PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //em.persist(u);//insertar
        //em.merge(u);//actualizar
        //System.out.println(em.find(Usuario.class, u.getIdUsuario()));//BUSCAR
        //u=em.find(Usuario.class, u.getIdUsuario());//buscar
        //em.remove(u);//eliminar
        TypedQuery<Usuario> q = em.createQuery("Select u from Usuario u", Usuario.class);//consulta
        System.out.println(q.getResultList());//obtenemos la lista de la base, la base debe estar creada previamente para poder hacer todo esto

        em.getTransaction().commit();
    }
}
