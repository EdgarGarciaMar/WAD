/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

Hay error
 */
package com.ipn.mx.utilerias;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author edgargarcia
 */
public class hibernateUtil {
    
    private static StandardServiceRegistry registry;
    private static SessionFactory SessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(SessionFactory ==null){
            try {
                registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                MetadataSources mds = new MetadataSources(registry);
                Metadata metadata = mds.getMetadataBuilder().build();
                SessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                if(registry !=null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return SessionFactory;
    }
    
    public static void shutdown(){
        if(registry !=null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
