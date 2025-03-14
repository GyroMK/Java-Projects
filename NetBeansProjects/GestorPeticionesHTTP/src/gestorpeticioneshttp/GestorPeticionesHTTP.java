package gestorpeticioneshttp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.net.ssl.HttpsURLConnection;

public class GestorPeticionesHTTP {

	public StringBuilder getContenidoMetodoGet(String direccion) throws Exception{
		StringBuilder respuesta = new StringBuilder();
		URL url = new URL(direccion);
		HttpsURLConnection conexion = (HttpsURLConnection)url.openConnection();
		conexion.setRequestMethod("GET");
		conexion.setRequestProperty("Content-Type", "text/plain");
		conexion.setRequestProperty("charset", "utf-8");
		conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
		int estado = conexion.getResponseCode();
		
		Reader streamReader = null;
		if(estado==HttpsURLConnection.HTTP_OK){
			streamReader = new InputStreamReader(conexion.getInputStream());
			int caracter;
			while((caracter=streamReader.read())!=-1){
				respuesta.append((char)caracter);
			}
		}else{
			throw new Exception("Error HTTP " + estado);
		}
		conexion.disconnect();
		
		return respuesta;
	}
	
	public static void writeFile(String strPath, String contenido) throws IOException{
		Path path = Paths.get(strPath);
		byte[] strToBytes = contenido.getBytes();
		Files.write(path, strToBytes);
	}
	
	public static void main(String[] args) {
		try{
			String esquema = "https://";
			String servidor = "dle.rae.es/";
			String recurso = URLEncoder.encode("Croqueta", StandardCharsets.UTF_8.name());
			GestorPeticionesHTTP gp = new GestorPeticionesHTTP();
			String direccion = esquema + servidor + recurso;
			StringBuilder resultado = gp.getContenidoMetodoGet(direccion);
			GestorPeticionesHTTP.writeFile("E:/croqueta.html", resultado.toString());
			System.out.println("Descarga finalizada ;)");
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

}
