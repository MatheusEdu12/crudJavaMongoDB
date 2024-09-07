package com.matheuseduardo.oficina.produtos;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class ReadProduto {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco()
                .getCollection("produtos");

        MongoCursor<Document> cursor = colecao.find().iterator();

        try {
            while (cursor.hasNext()) {
                Document produto = cursor.next();
                System.out.println("--------- Detalhes --------");
                System.out.println("id: " + produto.get("_id"));
                System.out.println("nome: " + produto.get("produtoNome"));
                System.out.println("descrição: " + produto.get("descricao"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }
}
