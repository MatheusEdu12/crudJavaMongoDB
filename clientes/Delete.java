package com.matheuseduardo.oficina.clientes;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class Delete {
    
     public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection colecao = conexao.getBanco().getCollection("clientes");
        
        colecao.deleteOne(
                Filters.eq("_id", 
                        new ObjectId("66dbae2130025f36120506e2")));
        System.out.println("Cliente excluído com sucesso"); 
            
    }

    
}
