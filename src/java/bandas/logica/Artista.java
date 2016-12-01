package bandas.logica;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * 
 */
@ManagedBean (name="Artista")
@RequestScoped
public class Artista {
    
    private String nomeArtista;
    private String cidade;
    private ArrayList<Album> albuns;
    
    public Artista() {
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public ArrayList<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(ArrayList<Album> albuns) {
        this.albuns = albuns;
    }
    
    public String registrar(){
        int retorno = Bandas.cadastrarArtista(this);
        if(retorno != 0){
            return "cadastraArtistaSucesso";
        }
        return "cadastraArtistaFalha";
    }
    
    public String buscar(){
        Artista autor = Bandas.getArtista(nomeArtista);
        if(autor != null){
            cidade = autor.getCidade();
            albuns = Bandas.getAlbumsArtista(nomeArtista);
            return "consultaArtistaSucesso";
        }
        return "consultaArtistaFalha";
    }
    
}
