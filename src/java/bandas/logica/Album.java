package bandas.logica;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="Album")
@RequestScoped
public class Album {

    private String titulo;
    private String capa;
    private float preco;
    private String nomeArtista;
   
    public Album() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String buscar() {
        Album l = Bandas.getAlbum(titulo);
        if (l != null) {
            this.setCapa(l.getCapa());
            this.setPreco(l.getPreco());
            this.setNomeArtista(l.getNomeArtista());
            return "consultaAlbumSucesso";
        }
        return "consultaAlbumFalha";
    }
    
    public String registrar(){
        int retorno = Bandas.cadastrarAlbum(this);
        if(retorno != 0){
            return "cadastraAlbumSucesso";
        }
        return "cadastraAlbumFalha";
    }
}
