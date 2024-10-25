package com.matheuseduardo.oficina.funcionarios;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class UpdateFuncionario {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection<Document> colecao = conexao.getBanco().getCollection("funcionarios");
                       
        try{
            Document funcionario = (Document) colecao.find(
                Filters.eq("_id", 
                        new ObjectId("66dbbe4ddc68ba0595905418"))).first(); // MUDAR O ID
            
            colecao.updateOne(funcionario,
            	    new Document("$set", new Document("nome", "João Pedro Almeida")
            	        .append("cpf", "123.456.789-00")
            	        .append("Endereco", 
            	            new Document("Logradouro", "Rua Nova") 
            	                .append("Numero", "303")
            	                .append("Bairro", "Jatiúca")
            	                .append("Cidade", "Maceió")
            	        )
            	        .append("Telefone", "(82) 99999-8888"))
            	);

            System.out.print("Funcionario alterado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    }

    

