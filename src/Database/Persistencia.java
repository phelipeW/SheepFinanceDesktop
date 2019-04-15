/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Conta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            oos.writeObject(object);

            oos.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Object Le(String arquivo){
        Object object;        
        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            object = ois.readObject();
            ois.close();

            return object;
            
        } 
        catch (FileNotFoundException e){
            Escreve("", arquivo);
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
