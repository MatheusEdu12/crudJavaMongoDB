package com.matheuseduardo.oficina.vendas;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Matheus
 */
public class CreateVenda {
    
public static void main(String[] args) {
        
        Conexao conexao = new Conexao();        
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("vendas");

        Document venda1 = new Document();
        Document venda2 = new Document();
        Document venda3 = new Document();

        venda1
            .append("data", new Date()) 
            .append("cliente", new Document()
                .append("id", new ObjectId("671aecc3ea412d7214723b5b"))
                .append("nome", "Matheus Eduardo")
            )
            .append("produto", new Document()
                .append("id", new ObjectId("671aefbae0cd3853f9fde984"))
                .append("nome", "Óleo")
            )
            .append("funcionario", new Document()
                .append("id", new ObjectId("671aed03d4285a0c801c3fdf"))
                .append("nome", "Fernando Souza")
                
            );
        
        venda2
	        .append("data", new Date()) 
	        .append("cliente", new Document()
	            .append("id", new ObjectId("671aecc3ea412d7214723b5c"))
	            .append("nome", "Luccas Eduardo")
	        )
	        .append("produto", new Document()
	            .append("id", new ObjectId("671aefbae0cd3853f9fde985")) 
	            .append("nome", "Filtro de Ar")
	        )
	        .append("funcionario", new Document()
	            .append("id", new ObjectId("671aed12bdc5b717ec10b5df")) 
	            .append("nome", "Carlos Alberto")
	        );

	    venda3
	        .append("data", new Date()) 
	        .append("cliente", new Document()
	            .append("id", new ObjectId("671aecc3ea412d7214723b5d")) 
	            .append("nome", "Eduardo Wanderley")
	        )
	        .append("produto", new Document()
	            .append("id", new ObjectId("671aefbae0cd3853f9fde986")) 
	            .append("nome", "Bateria")
	        )
	        .append("funcionario", new Document()
	            .append("id", new ObjectId("671aed12bdc5b717ec10b5de"))
	            .append("nome", "Ana Beatriz")
	        );

    try {
        colecao.insertOne(venda1);            
        colecao.insertOne(venda2);            
        colecao.insertOne(venda3);           
            System.out.println("Vendas inseridas com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
