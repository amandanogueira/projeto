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
        if (nome != null && nome.trim().length() > 0) {
            Cidade cid = getCidadeNome(nome);
            return cid;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t != null) {
            String codigo = t.toString();
            Cidade cidade = getCidadeNome(codigo);
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
                return cid;
            }
        }
        return null;
    }

}
