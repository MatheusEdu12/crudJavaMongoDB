package com.matheuseduardo.oficina.fornecedores;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class UpdateFornecedor {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("fornecedores");
                       
        try{
            Document fornecedor = (Document) colecao.find(
                Filters.eq("_id", 
                        new ObjectId("66dbbe4ddc68ba0595905418"))).first(); // MUDAR O ID
            
            colecao.updateOne(fornecedor,
            	    new Document("$set", new Document("nome", "Lucas Oliveira Santos")
            	        .append("cpf", "987.654.321-00")
            	        .append("Endereco", 
            	            new Document("Logradouro", "Avenida B") 
            	                .append("Numero", "202")
            	                .append("Bairro", "Centro")
            	                .append("Cidade", "Maceió")
            	        )
            	        .append("Telefone", "(82) 98888-9999"))
            	);
            System.out.print("Fornecedor alterado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    }

    

