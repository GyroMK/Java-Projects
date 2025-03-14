package dam.unidad1;

public class ProcesoPrincipal {
	//10.10.14.110
	public static void main(String[] args){
		try{			
			String []nombreProceso = {"java", "dam.unidad1.ProcesoSecundario"};
			Process proceso = Runtime.getRuntime().exec(nombreProceso);
			
			// Almacenamos el valor de retorno del proceso
			int valor = proceso.waitFor();
			
			// 0 si todo ha ido bien
			if(valor == 0){
				System.out.println("Proceso realizado con éxito ;)");
			}else{
				System.out.println("Ha ocurrido un error: " + valor);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
