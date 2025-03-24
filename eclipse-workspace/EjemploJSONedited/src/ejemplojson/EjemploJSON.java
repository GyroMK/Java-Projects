package ejemplojson;


import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class EjemploJSON {

	public int almacenarPagina(String esquema, String servidor, String recurso, String path) throws Exception {
		String direccion = esquema + servidor + recurso;
		HttpClient httpClient = HttpClient.newBuilder().version(Version.HTTP_1_1)
				.followRedirects(HttpClient.Redirect.NORMAL).build();

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(direccion))
				.headers("Content-Type", "text/plain").setHeader("User-Agent", "Mozilla/5.0").build();

		HttpResponse<Path> response = httpClient.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(path)));

		return response.statusCode();
	}

	public static void main(String[] args) {

		// http://www.omdbapi.com/?apikey=[tuclave]&

		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el nombre de una pelicula: ");
		String pelicula = teclado.nextLine();
		System.out.println("Pelicula: " + pelicula);
		System.out.println("Introduce el anyo de una pelicula: ");
		String anyo = teclado.nextLine();
		System.out.println("anyo: " + anyo);
		String esquema = "https://";
		System.out.println("Esquema: " + esquema);
		String servidor = "www.omdbapi.com/?apikey=b265a329&t=";
		System.out.println("Servidor: " + servidor);
		
		pelicula = URLEncoder.encode(pelicula, StandardCharsets.UTF_8);
		anyo = URLEncoder.encode(anyo, StandardCharsets.UTF_8);

		

		// FALTA SACAR POR CONSOLA
		EjemploJSON gestor = new EjemploJSON();

		try {
			int codigoEstado = gestor.almacenarPagina(esquema, servidor, pelicula.concat("&y="+anyo), "C:\\Users\\sergi.carmona\\Documents\\Java-Projects\\eclipse-workspace\\EjemploJSONedited\\" + pelicula.concat(".json"));
			System.out.println("Nombre de la pelicula:" + pelicula);
			if (codigoEstado == HttpURLConnection.HTTP_OK) {
				System.out.println("Descarga finalizada");
			} else {
				System.out.println("Error " + codigoEstado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
