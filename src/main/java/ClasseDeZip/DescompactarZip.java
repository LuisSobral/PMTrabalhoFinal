package ClasseDeZip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/*
    Classe de auxílio para baixar e descompactar cada arquivo zip
*/
public class DescompactarZip {
    
    /*
        Método para descompactar e escrever o conteudo de um arquivo zip
    */
    public File descompactarArquivo(String nomeArquivo, String codigoProfessor) throws FileNotFoundException, IOException {
        
        byte[] buffer = new byte[1024];
        
        //baixa o arquivo zip e descompacta o curriculo.xml
        File arquivoZip = baixarArquivo(nomeArquivo,codigoProfessor);
        ZipFile zip = new ZipFile(arquivoZip);
        ZipEntry entrada = zip.getEntry("curriculo.xml");
        File arquivoXML = new File(entrada.getName());

        InputStream is = zip.getInputStream(entrada);
        OutputStream os = new FileOutputStream(arquivoXML);
        
        //Escreve o xml no disco
        int bytesLidos = 0;
        
        while ((bytesLidos = is.read(buffer)) > 0) {
            os.write(buffer, 0, bytesLidos);
        }
        
        is.close();
        os.close();
        zip.close();
        
        //Deleta o arquivo zip
        arquivoZip.delete();
        return arquivoXML;        
    }    
    
    /*
        Método para baixar e escrever um arquivo zip
    */
    private File baixarArquivo(String nomeArquivo, String codigoProfessor) throws MalformedURLException, IOException {
     
        //Cria uma conexão com a url do arquivo
        URL url1 = new URL(nomeArquivo);
        URLConnection con =  url1.openConnection();
        
        //Cria o arquivo zip
        File arquivo = new File(codigoProfessor+".zip");
        FileOutputStream fileOut = new FileOutputStream(arquivo);
         
        //Escreve o arquivo zip no disco
        int c=0;
         
        do{
            c=con.getInputStream().read();
            fileOut.write(c);

        }while(c !=-1);
         
        fileOut.close();

        return arquivo;
    }
}
    

