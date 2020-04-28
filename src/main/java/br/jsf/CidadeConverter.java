/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.model.Cidade;
import br.rs.CidadeRest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter {

    @Override
    public Cidade getAsObject(FacesContext fc, UIComponent uic, String nome) {
        //System.out.println("String recebida no converter: " + string);
        if (nome != null && nome.trim().length() > 0) {
            Cidade cid = getCidadeNome(nome);
            System.out.println("Cidade que está sendo retornada: " + cid.getNome() + " " + cid.getCodigo());
            return cid;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t != null) {
            System.out.println("Objeto recebido no converter: " + t.toString());
            String codigo = t.toString();
            Cidade cidade = getCidadeNome(codigo);
            System.out.println("Objeto recebido no converter: " + cidade.toString());
            return cidade.getNome();
        }
        return null;
    }

    private Cidade getCidadeNome(String string) {
        CidadeRest cr = new CidadeRest();
        ArrayList<Cidade> lista = cr.get(ArrayList.class);
        cr.close();
        Iterator itel = lista.iterator();
        while (itel.hasNext()) {
            HashMap<String, String> hash = (HashMap<String, String>) itel.next();
            if (hash.get("nome").equals(string)) {
                String nome = hash.get("nome");
                String scod = String.valueOf(hash.get("codigo"));
                int cod = Integer.parseInt(scod);
                Cidade cid = new Cidade(cod, nome);
                System.out.println("Valores que cidade está recebendo: " + cod + " " + nome);
                return cid;
            }
        }
        return null;
    }

}
