#include <stdio.h>

main(){

	int Entrega, Devolucao;

	scanf("%d %d", &Entrega, &Devolucao);

	if(Devolucao - Entrega >= 3){
    printf("Muito bem! Apresenta antes do Natal!\n");
    }
    
    else if ((Devolucao - Entrega > 0) && (Devolucao -Entrega < 3)){
    printf("Parece o trabalho do meu filho!\n");
		Entrega += 2;
      
    if (Entrega < 24){
    printf("TCC Apresentado!\n");
    }
      
    else{
    printf("Fail! Entao eh nataaaaal!\n");
    }
      
  }
    else{
    printf("Eu odeio a professora!\n");
  }
	return 0;
}