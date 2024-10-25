package com.matheuseduardo.oficina.funcionarios;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class DeleteFuncionario {
    
     public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("funcionarios");
        
        colecao.deleteOne(
                Filters.eq("_id", 
                        new ObjectId("66dbbe4ddc68ba0595905418"))); // MUDAR O ID
        System.out.println("Funcionario excluído com sucesso"); 
            
    }

    
}
