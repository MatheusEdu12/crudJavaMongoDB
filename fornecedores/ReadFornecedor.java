package com.matheuseduardo.oficina.fornecedores;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class ReadFornecedor {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco()
                .getCollection("fornecedores");                
        
        MongoCursor<Document> cursor = colecao.find().iterator();
        
        try {
            while (cursor.hasNext()) {
                Document fornecedor = (Document)cursor.next();
                System.out.println("--------- Detalhes --------");
                System.out.println("id: " + fornecedor.get("_id"));
                System.out.println("nome: " + fornecedor.get("nome"));
                System.out.println("cpf: " + fornecedor.get("cpf"));
                System.out.println("numero: " + fornecedor.get("numero"));                
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }
    }

    
}
