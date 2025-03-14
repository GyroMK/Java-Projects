#include <stdio.h>

main(){
	FILE *fichero;
	fichero = fopen("texto.txt", "w");
	
	fputs("Texto generado por el proceso en C", fichero);
	
	fclose(fichero);
}
