/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bandas.dao;

import java.util.ArrayList;
import bandas.logica.Album;

/**
 *
 */
public interface AlbumDAO {
    
    public int salvar(Album album);
    public Album consultaPorTitulo(String titulo);
    public ArrayList<Album> consultaPorArtista(String nomeArtista);
}
