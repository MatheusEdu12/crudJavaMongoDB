package com.matheuseduardo.oficina.produtos;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class DeleteProduto {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("produtos");
        
        colecao.deleteOne(
                Filters.eq("_id", 
                        new ObjectId("66dbbee566ae8c56480d7c9e"))); // MUDAR ID
        System.out.println("Produto excluído com sucesso."); 
            
    }
    
}
