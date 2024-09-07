package com.matheuseduardo.oficina.vendas;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

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
            .append("dataVenda", new Date()) 
            .append("cliente", new Document()
                .append("clienteNome", "Matheus Eduardo")
            ).append("formaPagamento", "cartão");
        
        venda2
            .append("dataVenda", new Date()) 
            .append("cliente", new Document()
                .append("clienteNome", "Luccas Eduardo")
            ).append("formaPagamento", "dinheiro");
        
        venda3
            .append("dataVenda", new Date())  
            .append("cliente", new Document()
                .append("clienteNome", "Eduardo Wanderley")
            ).append("formaPagamento", "transferência");
        
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
