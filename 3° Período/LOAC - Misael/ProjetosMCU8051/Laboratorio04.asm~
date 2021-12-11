	ORG 00H		; indica o início do programa em 00H
	LJMP inicio	; "pula" para o label "inicio"
numeros:DB 11000000b	; número 0 (binário)
	DB 11111001b	; número 1 (binário)
	DB 10100100b	; número 2 (binário)
	DB 10110000b	; número 3 (binário)
	DB 10011001b	; número 4 (binário)
	DB 10010010b	; número 5 (binário)
	DB 10000010b	; número 6 (binário)
	DB 11111000b	; número 7 (binário)
	DB 10000000b	; número 8 (binário)
	DB 10010000b	; número 9 (binário)
inicio: MOV	DPTR, #numeros	; move o valor presente no label "numeros" para o registrador DPTR
	MOV	A, #04		; move o valor 5 para o registrador acumulador A
	MOV	B, #03		; move o valor 4 para o registrador acumulador B
	LCALL	dispnum		; chama a sub-rotina "dispnum"
	LJMP	$		; move o ponteiro relativo à execução para o endereço de memória $

dispnum:MOV	P2, #0ffH	; move o valor "00ffH" para o registrador P2
	MOV	P1, #0ffH	; move o valor "00ffH" para o registrador P1
	MOVC	A, @A+DPTR	; soma o conteúdo do registrador acumulador com DPTR deixando o 								; resultado da operação guardado no acumulador e cria um endereço de memória
	MOV	P1, A		; move o conteúdo do registrador acumulador para o registrador P1
	MOV	A, B		; move o conteúdo do registrador B para o registrador acumulador
	CJNE	A, #01, disp1	; compara o conteúdo do registrador acumulador com o valor 01, caso seja diferente o programa 				; vai para o label "disp1"
	CPL	A		; inverte os bits do registrador acumulador
	SJMP	disp5		; salta para o label "disp5"

disp1:	CJNE	A, #02, disp2	; compara o conteúdo do registrador acumulador com o valor 02, caso seja diferente o programa 				; vai para o label "disp2"
	CPL	A		; inverte os bits do registrador acumulador
	SJMP	disp5		; salta para o label "disp5"

disp2:	CJNE	A, #03, disp3	; compara o conteúdo do registrador acumulador com o valor 03, caso seja diferente o programa 				; vai para o label "disp3"
	MOV	A, #0FBH	; move o valor 0F7H para o registrador acumulador
	SJMP	disp5		; salta para o label "disp5"

disp3:	CJNE	A, #04, disp4	; compara o conteúdo do registrador acumulador com o valor 04, caso seja diferente o programa 				; vai para o label "disp4"
	SJMP	disp5		; vai para o label "disp5"
disp4:	CLR	A		; zera todo o registrador acumulador
disp5:	MOV	P2, A		; move o conteúdo do registrador acumulador para o registrador P2
	RET			; retorna à sub-rotina
	END			; indica o fim do programa
	