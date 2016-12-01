package bandas.logica;

import java.util.ArrayList;
import bandas.dao.ArtistaDAOSQL;
import bandas.dao.AlbumDAOSQL;
import bandas.dao.ArtistaDAO;
import bandas.dao.AlbumDAO;

/**
 *
 
 */
public class Bandas {
    
	private static AlbumDAO albumDAO = new AlbumDAOSQL();
	private static ArtistaDAO artistaDAO = new ArtistaDAOSQL();
	
    public static int cadastrarAlbum(Album novoAlbum) 
	{
		if ( (getAlbum(novoAlbum.getTitulo())!= null) ||
				(getArtista(novoAlbum.getNomeArtista())== null) )
			return 0;
		else
			return albumDAO.salvar(novoAlbum);
	}
    
    public static int cadastrarArtista(Artista novoArtista)
    {
        if (getArtista(novoArtista.getNomeArtista())!= null)
            return 0;
        else
            return artistaDAO.salvar(novoArtista);
    }
    
    public static Album getAlbum(String titulo)
    {
        return albumDAO.consultaPorTitulo(titulo);
    }
    
    public static ArrayList<Album> getAlbumsArtista(String nomeArtista) 
    {
        return albumDAO.consultaPorArtista(nomeArtista);
    }
    
    public static Artista getArtista(String nome) 
    {
        return artistaDAO.consultaPorNome(nome);
    }
    
}
