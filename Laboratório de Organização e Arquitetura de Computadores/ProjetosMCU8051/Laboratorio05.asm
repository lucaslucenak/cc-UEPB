	ORG 00H		;Inicia o programa em 00H
	LJMP INICIO	;Salta para o label "INICIO"
	ORG 0BH		;Vai para o endereço 0BH
	CPL P1.0	;Define o temporizador 0
	RETI		;É o código "RET" para gerar interrupções
	ORG 1BH		;Vai para o endereço 1BH
	CPL P1.1	;Define o temporizador 1
	RETI 		;É o código "RET" para gerar interrupções
	ORG 30H		;Vai para o endereço 30H

INICIO:	MOV SP,#2FH	;Move para o registrardor SP o valor 2FH
	MOV IE,#8AH	;Move para o registrador IE o valor 8AH e ativa as interrupções
			;Timer 0 e timer 1
	MOV TMOD,#10H	;Move o valor 10H e ativa o Timer 1
	SETB TR0	;Define o TL0 através da porta TR0
	SETB TR1	;Define o TH0 através da porta TR1
	SJMP $		;Retornar para o label
	END		;Define o final do programa
	