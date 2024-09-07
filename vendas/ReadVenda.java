package com.matheuseduardo.oficina.vendas;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author Matheus
 */
public class ReadVenda {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco()
                .getCollection("vendas");
        
        MongoCursor<Document> cursor = colecao.find().iterator();
        
        try {
            while (cursor.hasNext()) {
                Document venda = cursor.next();
                System.out.println("--------- Detalhes --------");                
                System.out.println("id: " + venda.get("_id"));
                System.out.println("data venda: " + venda.getDate("dataVenda"));
                
                Document cliente = (Document) venda.get("cliente");
                System.out.println("nome: " + cliente.getString("clienteNome"));
                System.out.println("Forma de Pagamento: " + venda.getString("formaPagamento"));
                System.out.println("----------------------------");
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }
}
