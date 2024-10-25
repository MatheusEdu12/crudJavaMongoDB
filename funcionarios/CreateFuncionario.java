package com.matheuseduardo.oficina.funcionarios;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class CreateFuncionario {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();        
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("funcionarios");

        Document f1 = new Document();
        Document f2 = new Document();
        Document f3 = new Document();

        f1
	        .append("nome", "Ana Beatriz")
	        .append("cpf", "123.456.789-00")
	        .append("telefone", "(82) 91234-5678");
    
	    f2
	        .append("nome", "Carlos Alberto")
	        .append("cpf", "234.567.890-11")
	        .append("telefone", "(82) 92345-6789");
	    
	    f3
	        .append("nome", "Fernanda Souza")
	        .append("cpf", "345.678.901-22")
	        .append("telefone", "(82) 93456-7890");
                

        try {
            colecao.insertOne(f1);            
            colecao.insertOne(f2);            
            colecao.insertOne(f3);            
            System.out.println("Funcionarios inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }

    
}
