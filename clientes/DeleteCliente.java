package com.matheuseduardo.oficina.clientes;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class DeleteCliente {
    
     public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection colecao = conexao.getBanco().getCollection("clientes");
        
        colecao.deleteOne(
                Filters.eq("_id", 
                        new ObjectId("66dbbe4ddc68ba0595905418"))); // MUDAR O ID
        System.out.println("Cliente excluído com sucesso"); 
            
    }

    
}
