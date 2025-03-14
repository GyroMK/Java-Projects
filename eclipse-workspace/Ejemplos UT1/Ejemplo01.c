#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

main(){
	int contador=0;
	pid_t idHijo;
	pid_t idPadre;
	
	printf("Empezamos: \n");
	idPadre = getpid();
	printf("Antes de bifurcarse\n");
	contador++;
	idHijo = fork();
	contador++;
	printf("Despues de bifurcarse\n");
	
	if(idHijo == 0){
		printf("id Hijo: %ld. id Padre: %ld. Contador: %d \n", (long)getpid(), (long)idPadre, contador);
	}else{
		printf("id Padre: %ld. id Hijo: %ld. Contador: %d \n", (long)getpid(), (long)idPadre, contador);
	}
}
