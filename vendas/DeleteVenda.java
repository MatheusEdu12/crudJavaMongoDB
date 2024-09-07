package com.matheuseduardo.oficina.vendas;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class DeleteVenda {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection colecao = conexao.getBanco().getCollection("vendas");
        
        colecao.deleteOne(
                Filters.eq("_id", 
                        new ObjectId("66dbc17e84ac040d89043db9"))); // MUDAR ID
        System.out.println("Venda excluída com sucesso"); 
            
    }
    
}
