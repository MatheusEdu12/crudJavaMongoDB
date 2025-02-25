package com.matheuseduardo.oficina.clientes;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class ReadCliente {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco()
                .getCollection("clientes");                
        
        MongoCursor cursor = colecao.find().iterator();
        
        try {
            while (cursor.hasNext()) {
                Document cliente = (Document)cursor.next();
                System.out.println("--------- Detalhes --------");
                System.out.println("id: " + cliente.get("_id"));
                System.out.println("nome: " + cliente.get("nome"));
                System.out.println("cpf: " + cliente.get("cpf"));
                System.out.println("numero: " + cliente.get("numero"));                
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }
    }

    
}
