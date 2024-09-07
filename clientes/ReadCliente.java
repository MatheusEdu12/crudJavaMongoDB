package com.matheuseduardo.oficina.clientes;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class Read {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection colecao = conexao.getBanco()
                .getCollection("clientes");                
        
        MongoCursor cursor = colecao.find().iterator();
        
        try {
            while (cursor.hasNext()) {
                Document cliente = (Document)cursor.next();
                System.out.println("--------- Detalhes --------");
                System.out.println(cliente.get("_id"));
                System.out.println(cliente.get("nome"));
                System.out.println(cliente.get("cpf"));
                System.out.println(cliente.get("numero"));                
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }
    }

    
}
