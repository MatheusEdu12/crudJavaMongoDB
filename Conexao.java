package com.matheuseduardo.oficina;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Matheus
 */
public class Conexao {
    
    private MongoClient cliente;
    private MongoDatabase banco;
    
    public Conexao(){
        cliente = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        banco = cliente.getDatabase("oficina");
        
        System.out.println("Conexão realizada com sucesso!");
    }

    public MongoDatabase getBanco() {
        return banco;
    }        
    
    public static void main(String[] args) {
        Conexao conn = new Conexao();
    }

    
}
