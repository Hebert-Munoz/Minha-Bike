package br.com.bicicleta.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// imports omitidos

public class GenerateAcessProviders {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.
          createEntityManagerFactory("bicicletas");

    factory.close();
  }
  
  
}