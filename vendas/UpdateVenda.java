package com.matheuseduardo.oficina.vendas;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.Arrays;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class UpdateVenda {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("vendas");
        
        try {
            Document venda = colecao.find(Filters.eq("_id", new ObjectId("66dbc17e84ac040d89043db9"))).first(); // MUDAR ID
            
            colecao.updateOne(venda, 
                new Document("$set", new Document("dataVenda", new Date())
                        .append("cliente", new Document()
                                .append("id", "64abf5e7c1b0e1c6a9fdd999")
                                .append("nome:", "Matheus Eduardo Laurindo do Rego"))
                        .append("formaPagamento", "transferência")
                )
            );

            System.out.println("Venda atualizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
