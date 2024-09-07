package com.matheuseduardo.oficina.clientes;

import com.matheuseduardo.oficina.Conexao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Matheus
 */
public class Update {
    
    public static void main(String[] args) {
        
        Conexao conexao = new Conexao();
        MongoCollection colecao = conexao.getBanco().getCollection("clientes");
                       
        try{
            Document cliente = (Document) colecao.find(
                Filters.eq("_id", 
                        new ObjectId("66dbae2130025f36120506e2"))).first();
            
            colecao.updateOne(cliente,
                    new Document("$set", new Document("nome", "Matheus Eduardo Laurindo do Rego")                            
                            .append("cpf", "121.980.584-05")
                            .append("Endereco", 
                                    new Document("Logradouro", "Rua A") 
                                       .append("Numero", "101")
                                        .append("Bairro", "Farol")
                                        .append("Cidade", "Maceió")
                            )
                            .append("Curso", "Sistemas para Internet")
                            .append("Telefone", "(82)98724-7844"))
            );
            System.out.print("Cliente alterado com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    }

    

