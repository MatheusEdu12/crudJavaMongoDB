package com.matheuseduardo.oficina.clientes;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class Create {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();        
        MongoCollection colecao = conexao.getBanco().getCollection("clientes");

        Document c1 = new Document();
        Document c2 = new Document();
        Document c3 = new Document();

        c1
            .append("nome", "Matheus Eduardo")
            .append("cpf", "121.584.648-55")
            .append("telefone", "(82)9829-8465") ;
        c2
            .append("nome", "Luccas Eduardo")
            .append("cpf", "122.698.684-10")
            .append("telefone", "(82)9857-8465") ;
        c3
            .append("nome", "Eduardo Wanderley")
            .append("cpf", "122.698.684-10")
            .append("telefone", "(82)99110-3509") ;
                

        try {
            colecao.insertOne(c1);            
            colecao.insertOne(c2);            
            colecao.insertOne(c3);            
            System.out.println("Clientes inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }

    
}
