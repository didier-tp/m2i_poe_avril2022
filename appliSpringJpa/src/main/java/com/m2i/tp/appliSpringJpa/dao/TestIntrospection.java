package com.m2i.tp.appliSpringJpa.dao;

import java.lang.reflect.Field;

import com.m2i.tp.appliSpringJpa.entity.Employe;

public class TestIntrospection {

	public static void main(String[] args) {
		Employe emp1 = new Employe(1L,"jean","Bon","0102030405","jean.Bon@xyz.com","login","pwd");
        
			try {
				Class c = emp1.getClass();
				for(Field f : c.getDeclaredFields()) {
					//Field est objet technique qui décrit d'un attribut de la classe
					f.setAccessible(true);//pour pouvoir accéder aux éléments privés
					Object valeur = f.get(emp1);
					System.out.println(f.getName() + " " + f.getType().getName() +  " " + valeur);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	
	}

}
