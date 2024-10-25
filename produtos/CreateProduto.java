package com.matheuseduardo.oficina.produtos;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;


/**
 *
 * @author Matheus
 */
public class CreateProduto {
    
public static void main(String[] args) {
        
        Conexao conexao = new Conexao();        
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("produtos");

        Document produto1 = new Document();
        Document produto2 = new Document();
        Document produto3 = new Document();

        
        produto1
            .append("produtoNome", "Óleo")
            .append("descricao", "Óleo para motores de veículos")
            .append("fornecedor", new Document()
                .append("id", new ObjectId("671aed03d4285a0c801c3fdf"))
                .append("nome", "Carlos Pereira")
            );
        
        
        produto2
        .append("produtoNome", "Filtro de Ar")
        .append("descricao", "Filtro de ar para veículos")
        .append("fornecedor", new Document()
            .append("id", new ObjectId("671aed03d4285a0c801c3fde")) 
            .append("nome", "Maria Oliveira")
        );

	    produto3
	        .append("produtoNome", "Bateria")
	        .append("descricao", "Bateria automotiva de 60Ah")
	        .append("fornecedor", new Document()
	            .append("id", new ObjectId("671aed03d4285a0c801c3fdd")) 
	            .append("nome", "João Silva")
	        );

	    try {
	        colecao.insertOne(produto1);            
	        colecao.insertOne(produto2);            
	        colecao.insertOne(produto3);            
            System.out.println("Produtos inseridos com sucesso!");
        } catch (MongoWriteException e) {
            e.printStackTrace();
        }
    }
}
