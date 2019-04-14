/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author abelo
 */
public class Persistencia {
    private File arquivo;

    public Persistencia(File arq) {
        arquivo = arq;
    }

    public boolean Escreve(String aux, boolean append) {
        boolean r = false;
        try {
            BufferedWriter escritabuffer
                    = new BufferedWriter(new FileWriter(
                            getArquivo(), append));
            escritabuffer.write(aux + "\n");
            escritabuffer.flush();
            escritabuffer.close();
            r = true;
        } catch (IOException erro) {
            System.err.println("Erro de escrita");
        } finally {
            return r;
        }
    }

    public String Le() {
        StringBuffer aux = new StringBuffer();
        try {
            FileReader leitor = new FileReader(getArquivo());
            BufferedReader leitorbuffer = new BufferedReader(leitor);
            while (leitorbuffer.ready()) {
                aux.append(leitorbuffer.readLine()).append("\n");
            }
            leitorbuffer.close();

        } catch (IOException erro) {
            System.err.println("Erro ao ler arquivo. " + erro);
        } finally {
            return aux.toString();
        }
    }

    /**
     * @return the arquivo
     */
    private File getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    private void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
}
