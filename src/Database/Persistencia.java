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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

/**
 *
 * @author abelo
 */
public class Persistencia {
    public Persistencia() {
        
    }
    
    public void Escreve(Object object, String arquivo){
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            //fout.write(getObjectContas(contas).getBytes());
            oos.writeObject(object);

            oos.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public void EscreveEntrada(ArrayList<Entrada> entradas, String arquivo){
//        try {
//            FileOutputStream fout = new FileOutputStream(arquivo);
//            fout.write(getObjectEntradas(entradas).getBytes());
//            
//            System.out.println("Done");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
//    public void EscreveSaida(ArrayList<Saida> saidas, String arquivo){
//        try {
//            FileOutputStream fout = new FileOutputStream(arquivo);
//            fout.write(getObjectSaidas(saidas).getBytes());
//            
//            System.out.println("Done");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public Object Le(String arquivo){
        Object object;        
        String line = null;
        StringBuilder json = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            object = ois.readObject();
            ois.close();
//            BufferedReader in = new BufferedReader(new InputStreamReader(fin));
//            while((line = in.readLine()) != null) {
//                json.append(line);
//            }
            
//            object = readObjectContas(json.toString());
            
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
//
//    ArrayList<Entrada> LeEntradas(String arquivo) {
//        ArrayList<Entrada> object;   
//        String line = null;
//        StringBuilder json = new StringBuilder();
//        try {
//            FileInputStream fin = new FileInputStream(arquivo);
//            BufferedReader in = new BufferedReader(new InputStreamReader(fin));
//            while((line = in.readLine()) != null) {
//                json.append(line);
//            }
//            
//            object = readObjectEntradas(json.toString());
//
//            return object;
//        } 
//        catch (FileNotFoundException e){
//            return null;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    ArrayList<Saida> LeSaidas(String arquivo) {
//        ArrayList<Saida> object;        
//       String line = null;
//        StringBuilder json = new StringBuilder();
//        try {
//            FileInputStream fin = new FileInputStream(arquivo);
//            BufferedReader in = new BufferedReader(new InputStreamReader(fin));
//            while((line = in.readLine()) != null) {
//                json.append(line);
//            }
//            
//            object = readObjectSaidas(json.toString());
//
//            return object;
//        } 
//        catch (FileNotFoundException e){
//            return null;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private String getObjectContas(ArrayList<Conta> contas) {
//        StringBuilder retorno = new StringBuilder();
//        retorno.append("[");
//        for (Conta conta : contas) {
//            retorno.append("{");
//            retorno.append("'nome':'");
//            retorno.append(conta.getNome());
//            retorno.append("','saldo':");
//            retorno.append(conta.getSaldo());
//            retorno.append("},");
//        }
//        retorno.append("]");
//        return retorno.toString();
//    }
//    
//    private String getObjectEntradas(ArrayList<Entrada> entradas) {
//        StringBuilder retorno = new StringBuilder();
//        retorno.append("[");
//        for (Entrada entrada : entradas) {
//            retorno.append("{");
//            retorno.append("'data':'");
//            retorno.append(entrada.getData());
//            retorno.append("','conta':'");
//            retorno.append(entrada.getDescricao());
//            retorno.append("','valor':");
//            retorno.append(entrada.getValor());
//            retorno.append("},");
//        }
//        retorno.append("]");
//        return retorno.toString();
//    }
//    
//    private String getObjectSaidas(ArrayList<Saida> saidas) {
//        StringBuilder retorno = new StringBuilder();
//        retorno.append("[");
//        for (Saida saida : saidas) {
//            retorno.append("{");
//            retorno.append("'data':'");
//            retorno.append(saida.getData());
//            retorno.append("','conta':'");
//            retorno.append(saida.getDescricao());
//            retorno.append("','valor':");
//            retorno.append(saida.getValor());
//            retorno.append("},");
//        }
//        retorno.append("]");
//        return retorno.toString();
//    }
//    
//    private ArrayList<Conta> readObjectContas(String json) {
//        String[] lista = json.split("},");
//        ArrayList<Conta> contas = new ArrayList();
//        
//        for (String item : lista) {
//            if(item.length() > 14)
//            {
//                String nome = item.substring(item.indexOf("nome':'")+"nome':'".length(), item.indexOf("','saldo"));
//                Double saldo = Double.parseDouble(item.substring(item.indexOf("saldo':")+"saldo':".length()));
//                Conta conta = new Conta(nome, saldo);
//
//                contas.add(conta);
//            }
//        }
//        
//        return contas;
//    }
//    
//    private ArrayList<Entrada> readObjectEntradas(String json) {
//        String[] lista = json.split("},");
//        ArrayList<Entrada> entradas = new ArrayList();
//        
//        for (String item : lista) {
//            if(item.length() > 14)
//            {
//                String data = item.substring(item.indexOf("data':'")+"data':'".length(), item.indexOf("','conta"));
//                Conta conta = LocalDatabase.GetInstance().getConta(item.substring(item.indexOf("conta':'")+"conta':'".length(), item.indexOf("','valor")));
//                Double valor = Double.parseDouble(item.substring(item.indexOf("valor':")+"valor':".length()));
//                Entrada entrada = new Entrada(data, conta, valor);
//
//                entradas.add(entrada);
//            }
//        }
//        
//        return entradas;
//    }
//    
//    private ArrayList<Saida> readObjectSaidas(String json) {
//        String[] lista = json.split("},");
//        ArrayList<Saida> saidas = new ArrayList();
//        
//        for (String item : lista) {
//            if(item.length() > 14)
//            {
//                String data = item.substring(item.indexOf("data':'")+"data':'".length(), item.indexOf("','conta"));
//                Conta conta = LocalDatabase.GetInstance().getConta(item.substring(item.indexOf("conta':'")+"conta':'".length(), item.indexOf("','valor")));
//                Double valor = Double.parseDouble(item.substring(item.indexOf("valor':")+"valor':".length()));
//                Saida saida = new Saida(data, conta, valor);
//
//                saidas.add(saida);
//            }
//        }
//        
//        return saidas;
//    }
}
