import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Magasin {
    private ArrayList<Article> article;

    public int indiceDe(int code){
        int indice=-1;
        for (Article a : article) {
            if (a.getCode()==code)
                indice=article.indexOf(a);
        }
        return indice;
    }

    public void ajouter(Article a)throws Exception{
        for (Article ar : article) {
            if (ar.getCode()==a.getCode())
                throw new Exception("l'article existe déja !!");
            else
                article.add(a);
        }
    }

    public boolean suprimmer(int code){
        boolean res=false;
        for (Article a : article) {
            if (a.getCode()==code) {
                article.remove(a);
                res=true;
            }
        }
        return res;
    }

    public boolean suprimmer(Article a){
        boolean res=false;
        for (Article ar : article) {
            if(ar.equals(a)){
                article.remove(a);
                res=true;
            }
        }
        return res;
    }
    public int nombreArticlesEnSolde(){
        int nombreArEnSold=0;
        for (Article ar:article) {
            if (ar.getPrixorigine()>ar.prixArticle()){
                nombreArEnSold++;
            }
        }
        return nombreArEnSold;

    }

    public void enregistrer(String chemain) throws IOException {
        File articles=new File(chemain);
        BufferedWriter writer = new BufferedWriter(new FileWriter(articles));
        try{
            articles.createNewFile();
            for (Article ar:article) {
                writer.write(ar.toString());
            }
            writer.close();
        }catch (IOException e){
            e.getMessage();
        }

    }
}
