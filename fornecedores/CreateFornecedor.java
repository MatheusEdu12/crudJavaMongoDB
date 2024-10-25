package com.matheuseduardo.oficina.fornecedores;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class CreateFornecedor {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();        
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("fornecedores");

        Document f1 = new Document();
        Document f2 = new Document();
        Document f3 = new Document();

        f1
	        .append("nome", "João Silva")
	        .append("cpf", "111.222.333-44")
	        .append("telefone", "(82) 91234-5678");
    
	    f2
	        .append("nome", "Maria Oliveira")
	        .append("cpf", "222.333.444-55")
	        .append("telefone", "(82) 92345-6789");
	    
	    f3
	        .append("nome", "Carlos Pereira")
	        .append("cpf", "333.444.555-66")
	        .append("telefone", "(82) 93456-7890");
                

        try {
            colecao.insertOne(f1);            
            colecao.insertOne(f2);            
            colecao.insertOne(f3);            
            System.out.println("Fornecedores inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }

    
}
