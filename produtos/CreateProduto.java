package com.matheuseduardo.oficina.produtos;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


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
            .append("produtoNome", "Óleo Lubrificante")
            .append("descricao", "Óleo para motores de veículos");

        produto2
            .append("produtoNome", "Filtro de Óleo")
            .append("descricao", "Filtro para remoção de impurezas do óleo do motor");

        produto3
            .append("produtoNome", "Corrente de Bike")
            .append("descricao", "Corrente para pneus de bicicleta");

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
