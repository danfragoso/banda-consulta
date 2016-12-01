/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bandas.dao;

import bandas.logica.Artista;

/**
 *
 */
public interface ArtistaDAO {
    
     public int salvar(Artista artista);
     public Artista consultaPorNome(String nomeArtista);

}
