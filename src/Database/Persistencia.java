/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Conta;
import Model.Entrada;
import Model.Saida;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;

/**
 *
 * @author abelo
 */
public class Persistencia {
    public Persistencia() {
        
    }
    
    public void EscreveConta(ArrayList<Conta> contas, String arquivo){
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            //ObjectOutputStream oos = new ObjectOutputStream(fout);
            fout.write(getObjectContas(contas).getBytes());
            //oos.writeObject(object);

            //oos.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Conta> LeContas(String arquivo){
        ArrayList<Conta> object;        
        String line = null;
        StringBuilder json = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(arquivo);
//            ObjectInputStream ois = new ObjectInputStream(fin);
//            object = (ArrayList<Conta>)ois.readObject();
//            ois.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(fin));
            while((line = in.readLine()) != null) {
                json.append(line);
            }
            
            object = readObjectContas(json.toString());
            
            return object;
        } 
        catch (FileNotFoundException e){
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    ArrayList<Entrada> LeEntradas(String arquivo) {
        ArrayList<Entrada> object;        
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            object = (ArrayList<Entrada>)ois.readObject();
            ois.close();

            return object;
        } 
        catch (FileNotFoundException e){
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    ArrayList<Saida> LeSaidas(String arquivo) {
        ArrayList<Saida> object;        
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            object = (ArrayList<Saida>)ois.readObject();
            ois.close();

            return object;
        } 
        catch (FileNotFoundException e){
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getObjectContas(ArrayList<Conta> contas) {
        StringBuilder retorno = new StringBuilder();
        retorno.append("[");
        for (Conta conta : contas) {
            retorno.append("{");
            retorno.append("'nome':'");
            retorno.append(conta.getNome());
            retorno.append("','saldo':");
            retorno.append(conta.getSaldo());
            retorno.append("},");
        }
        retorno.append("]");
        return retorno.toString();
    }
    
    private ArrayList<Conta> readObjectContas(String json) {
        String[] lista = json.split("},");
        ArrayList<Conta> contas = new ArrayList();
        
        for (String item : lista) {
            if(item.length() > 14)
            {
                String nome = item.substring(item.indexOf("nome':'")+"nome':'".length(), item.indexOf("','saldo"));
                Double saldo = Double.parseDouble(item.substring(item.indexOf("saldo':")+"saldo':".length()));
                Conta conta = new Conta(nome, saldo);

                contas.add(conta);
            }
        }
        
        return contas;
    }
}
