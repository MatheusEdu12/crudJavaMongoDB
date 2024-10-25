package com.matheuseduardo.oficina.funcionarios;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class ReadFuncionario {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco()
                .getCollection("funcionarios");                
        
        MongoCursor<Document> cursor = colecao.find().iterator();
        
        try {
            while (cursor.hasNext()) {
                Document funcionario = (Document)cursor.next();
                System.out.println("--------- Detalhes --------");
                System.out.println("id: " + funcionario.get("_id"));
                System.out.println("nome: " + funcionario.get("nome"));
                System.out.println("cpf: " + funcionario.get("cpf"));
                System.out.println("numero: " + funcionario.get("numero"));                
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }
    }

    
}
