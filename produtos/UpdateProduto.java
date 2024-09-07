package com.matheuseduardo.oficina.produtos;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class UpdateProduto {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("produtos");

        try {
            Document produto = (Document) colecao.find(
                Filters.eq("_id", 
                        new ObjectId("66dbbee566ae8c56480d7c9e"))).first(); // MUDAR O ID
            
            colecao.updateOne(produto, 
                new Document("$set", new Document("nome", "Corrente de bicicleta")
                        .append("descricao", "Corrente cromada para bicicletas"))
            );
            System.out.println("Produto atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
