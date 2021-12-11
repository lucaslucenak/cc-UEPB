#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <unistd.h>
#include <stdbool.h>
#include <windows.h>
#include <time.h>
#include <conio.h>
#define TAM 50

//-----------------------------------------------------------------------------STRUCTS-----------------------------------------------------------------------------
FILE * pont_arq;

typedef struct pessoa{
    char cpf[TAM];
    char nome[TAM];
    char endereco[TAM];
    char telefone[TAM];
    int idade;
} Pessoa;

Pessoa pessoa[];

struct dadosContaCorrente {
    char cpfCorrentista[TAM];
    int numeroContaCorrenteS;
    float saldoInicial;
};
struct dadosContaCorrente contaCorrente[];

typedef struct atendimento {
    int contaCorrente;
    char hora[20];
    int idade;
    int tempoEspera;
    float valor;
    char operacao[15];
    struct atendimento * Prox;
} Atendimento;

typedef Atendimento * FILA;

FILA filaAtend;

Atendimento atend[];
Atendimento * vetorUm;
Atendimento * vetorDois;

//-----------------------------------------------------------------------------PROTOTIPAGEM-----------------------------------------------------------------------------
void lerCadastros();
void lerContasCorrentes();
int verificaVariavel();
int validaChar(char letra);
bool verificarStr(char *entrada);
float validacaoEntrada(char * entrada);
void cadastrar();
void cadastroContaCorrente();
void atendimento();
void chamarAtendimento();
void movimentacaoDiaria();
void menu();
void iniciarFila(FILA* Fila);
void inserirElemento(FILA* Fila, int ContaCorrente, char * Hora, int Idade, int TempoEspera, float Valor, char * Operacao);
void apagarFila(FILA * Fila);
void listarFila(FILA Fila);
Atendimento * lerFila(FILA Fila, Atendimento * vetor);
Atendimento * ordenarTempo(Atendimento * vetor, int lenFila);

int numero_cadastro = 0;
int numeroContaCorrente;
int conta = 0;
int tamFila = 0;
int operacaoEfetuada = 0;
int elementosDaFila = 0;
char *operacaoLista;
char horaAtendimento[40];



//-----------------------------------------------------------------------------MAIN-----------------------------------------------------------------------------
int main() {
    setlocale(LC_ALL,"");
    iniciarFila(&filaAtend);
    int opcaoMenu;

    while (opcaoMenu != 7){
        menu();
        //Validação da escolha do menu
        while(1){
            printf("Opção: ");
            opcaoMenu = verificaVariavel();

            if (opcaoMenu < 1 || opcaoMenu > 7) {
                printf("Opção inválida, escolha uma opção entre 1 e 7.\n");
                continue;
            }
            else {
                break;
            }
        }

        if (opcaoMenu == 1) {
            lerCadastros();
            printf("Iniciando o cadastro...\n");
            sleep(1);
            system("cls");
            cadastrar();
            system("pause");
        }
        else if (opcaoMenu == 2) {
            lerContasCorrentes();
            lerCadastros();
            printf("Iniciando cadastro de conta corrente...\n");
            sleep(1);
            system("cls");
            cadastroContaCorrente();
            system("pause");
        }
        else if (opcaoMenu == 3) {
            printf("Iniciando atendimento...\n");
            sleep(1);
            system("cls");
            atendimento();
            system("pause");
        }
        else if (opcaoMenu == 4) {
            printf("Chamando correntista para o atendimento...\n");
            sleep(1);
            system("cls");
            chamarAtendimento();
            system("pause");
        }
        else if (opcaoMenu == 5) {
            printf("Mostrando fila de atendimento...\n");
            sleep(1);
            system("cls");
            printf(" ----------------- FILA DE ATENDIMENTO ----------------- \n");
            printf(" CC \t  HORA\t\tIDADE\tTEMPO \t  VALOR \t OP.\n");
            listarFila(filaAtend);
            system("pause");
        }
        else if (opcaoMenu == 6) {
            printf("Mostrando movimentação diária...\n");
            sleep(1);
            system("cls");
            movimentacaoDiaria();
            system("pause");
        }
    }
    return 0;
}

//-----------------------------------------------------------------------------FUNÇÕES-----------------------------------------------------------------------------

void menu(){
    system("cls");
    printf(
        "============== MENU =============\n"
        "1. Cadastrar correntista\n"
        "2. Cadastrar conta corrente\n"
        "3. Registrar atendimento diário\n"
        "4. Chamar correntista para atendimento\n"
        "5. Mostrar fila de atendimento\n"
        "6. Mostrar movimentação diária\n"
        "7. Sair\n");
}

//-----------------------------------------------------------------------------FILAS-----------------------------------------------------------------------------

// Iniciar uma Fila
void iniciarFila(FILA* Fila) {
    * Fila = NULL;
}

//Insere um novo registro no fim da Fila
void inserirElemento(FILA* Fila, int ContaCorrente, char * Hora, int Idade, int TempoEspera, float Valor, char * Operacao) {
    if (*Fila == NULL) {
        *Fila = (FILA) malloc(sizeof(Atendimento));
        if (*Fila == NULL)
            return;
        elementosDaFila++;
        (*Fila)->contaCorrente = ContaCorrente;
        strcpy((*Fila)->hora, Hora);
        (*Fila)->idade = Idade;
        (*Fila)->tempoEspera = TempoEspera;
        (*Fila)->valor = Valor;
        strcpy((*Fila)->operacao, Operacao);
        (**Fila).Prox = NULL;
    }
    else {
        inserirElemento(& (**Fila) .Prox, ContaCorrente, Hora, Idade, TempoEspera, Valor, Operacao);
    }
}

//Apaga o primeiro elemento da Fila (se existir)
void apagarFila(FILA * Fila) {
    Atendimento * aux = * Fila;

    if (Fila == NULL)
        return;

    *Fila = (*Fila)->Prox;
    free (aux);
    elementosDaFila--;
}

//Listar todos os elementos da Fila Recursivamente
void listarFila(FILA Fila) {
    if (Fila == NULL)
        return;
    printf(" %d \t%s \t  %d \t  %d   \t  %.2f \t\t%s\n", Fila->contaCorrente, Fila->hora, Fila->idade, Fila->tempoEspera, Fila->valor, Fila->operacao);

    listarFila(Fila->Prox);
}

//Listar todos os elementos da fila recursivamente
Atendimento * lerFila(FILA Fila, Atendimento * vetor) {
    if (Fila == NULL)
        return 0;

    int contador = 1;
    do {
        vetor[contador].contaCorrente = Fila->contaCorrente;
        strcpy(vetor[contador].hora, Fila->hora);
        vetor[contador].idade = Fila->idade;
        vetor[contador].tempoEspera = Fila->tempoEspera;
        vetor[contador].valor = Fila->valor;
        strcpy(vetor[contador].operacao, Fila->operacao);

        Fila = Fila->Prox;
        contador++;
    }
    while (Fila != NULL);

    return vetor;
}

//Função para ordenar os tempos de espera
Atendimento * ordenarTempo(Atendimento * vetor, int lenFila) {
    Atendimento aux[lenFila];
    int comparaHora = 0;
    for (int i = 1; i <= lenFila; ++i) {
        for (int j = i + 1; j <= lenFila; ++j) {
            if (vetor[j].tempoEspera > vetor[i].tempoEspera) {
                aux[i] = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux[i];
            }
            else if (vetor[i].tempoEspera == vetor[j].tempoEspera) {
                if (vetor[j].idade > vetor[i].idade) {
                    aux[i] = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux[i];
                }
                else if(vetor[i].idade == vetor[j].idade) {
                    comparaHora = strcmp(vetor[j].hora, vetor[i].hora);
                    if (comparaHora < 0) {
                        aux[i] = vetor[i];
                        vetor[i] = vetor[j];
                        vetor[j] = aux[i];
                    }
                }
            }
        }
    }
    return vetor;
}

//-----------------------------------------------------------------------------VALIDAÇÕES-----------------------------------------------------------------------------

//Validar CPF do usuário
int validacaoCPF(char entradaCPF[]) {

    int tamanhoCPF, cpfValido = 0;

    cpfValido = 0;
    tamanhoCPF = strlen(entradaCPF);

    if (tamanhoCPF == 14){
        cpfValido += 1;
    }
    if(entradaCPF[3] == '.' && entradaCPF[7] == '.'){
        cpfValido += 1;
    }
    if(entradaCPF[11] == '-'){
        cpfValido += 1;
    }
    if (entradaCPF[0] >= '0' && entradaCPF[0] <= '9' && entradaCPF[1] >= '0' && entradaCPF[1] >= '0' && entradaCPF[2] >= '0' && entradaCPF[2] >= '0' && entradaCPF[4] >= '0' && entradaCPF[4] >= '0' && entradaCPF[5] >= '0' && entradaCPF[5] >= '0' && entradaCPF[6] >= '0' && entradaCPF[6] >= '0' && entradaCPF[8] >= '0' && entradaCPF[8] >= '0' && entradaCPF[9] >= '0' && entradaCPF[9] >= '0' && entradaCPF[10] >= '0' && entradaCPF[10] >= '0' && entradaCPF[12] >= '0' && entradaCPF[12] >= '0' && entradaCPF[13] >= '0' && entradaCPF[13] >= '0'){
        cpfValido += 1;
    }

    return cpfValido;
}

//Função de verificar entrada de inteiros
int verificaVariavel (){
    char variavel[50];
    bool invalido = false;
    int i = 0, retorno;
    while(1){
        invalido = false;
        scanf(" %[^\n]s", variavel);
        for (i = 0; i < strlen(variavel); i++){
            if (variavel[i] >= '0' && variavel[i] <= '9'){
            } else
                invalido = true;
        }
        if (invalido == true) {
            printf("Só é permitido digitar números: ");
        } else if (invalido == false) {
            retorno = atoi(variavel);
            break;
        }
    }
    return retorno;
}

//Função para validar se a entrada é inteira/float
float validacaoEntrada(char * entrada){
    int i, lenEntrada;
    int posicaoVirgula;
    int boolCaractere_temVirgula = 0, boolCaractere_NaotemVirgula = 0;
    bool temVirgula = false;
    float entradaFloat = 0;

    lenEntrada = strlen(entrada);

    //Procura a posição da possível vírgula
    for (i = 0; i < lenEntrada; i++) {
        if (entrada[i] == ',') {
            posicaoVirgula = i;
            boolCaractere_temVirgula += 1;
            temVirgula = true;
            break;
        }
    }

    //Caso tenha uma vírgula, ou seja, caso seja um valor com casa decimal
    if (temVirgula == true) {
    //Verifica se os caracteres antes da vírgula são números
        for (i = posicaoVirgula + 1; i < lenEntrada; i++) {
            if (entrada[i] >= '0' && entrada[i] <= '9') {
                boolCaractere_temVirgula += 1;
            }
        }

    //Verifica se os caracteres depois da vírgula são números
        for (i = 0; i <= posicaoVirgula; i++) {
            if (entrada[i] >= '0' && entrada[i] <= '9') {
                boolCaractere_temVirgula += 1;
            }
        }

        if (boolCaractere_temVirgula == lenEntrada) {
            entradaFloat = atof(entrada);
            return entradaFloat;
        }
        else {
            return -1;
        }
    }

    //Caso não tenha uma vírgula, ou seja, caso seja um valor inteiro
    if (temVirgula == false) {
        //Verifica se os caracteres são números
        for (i = 0; i < lenEntrada; i++) {
            if (entrada[i] >= '0' && entrada[i] <= '9') {
                boolCaractere_NaotemVirgula += 1;
            }
        }

        if (boolCaractere_NaotemVirgula == lenEntrada) {
            entradaFloat = atof(entrada);
            return entradaFloat;
        }
        else {
            return -1;
        }
    }
}

//Verificar entrada do teclado
bool verificarStr(char * entrada){
    bool ehLetra;
    int lenEntrada = strlen(entrada);
    for (int counter = 0; counter < lenEntrada; counter++){
        if ((entrada[counter] == ' ') || (entrada[counter] >= 'a' && entrada[counter] <= 'z') || (entrada[counter] >= 'A' && entrada[counter] <= 'Z')){
            ehLetra = true;
        }
        else {
            ehLetra = false;
            break;
        }
    }
    return ehLetra;
}

// Função para verificar a entrada de um char
int validaChar(char letra) {
    letra = toupper(letra);

    if (letra == 'D' || letra == 'S' || letra == 'P') {
        return 1;
    }
    return 0;
}

//-----------------------------------------------------------------------------LER ARQUIVOS-----------------------------------------------------------------------------

//Função para ler os cadastros de correntista do arquivo
void lerCadastros(){
    pont_arq = fopen("cadastros.txt", "rt");
    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("cadastros.txt", "w");
        fclose(pont_arq);
        return 1;
    }
    while(true) {
        if (fscanf(pont_arq, " %d", &numero_cadastro) == EOF)
            break;
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].cpf);
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].nome);
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].endereco);
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].telefone);
        fscanf(pont_arq, " %d", &pessoa[numero_cadastro].idade);
    }

    fclose(pont_arq);
}

//Função para ler os cadastros de conta corrente do arquivo
void lerContasCorrentes() {
    pont_arq = fopen("contascorrentes.txt", "rt");
    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("contascorrentes.txt", "w");
        fclose(pont_arq);
        return 1;
    }
    int numero = 1;
    while(true) {
        if (fscanf(pont_arq, " %d\n", &numero) == EOF)
            break;
        contaCorrente[numero].numeroContaCorrenteS = numero;
        fscanf(pont_arq, " %s\n", &contaCorrente[numero].cpfCorrentista);
        fscanf(pont_arq, " %f\n", &contaCorrente[numero].saldoInicial);
    }
    conta = contaCorrente[numero].numeroContaCorrenteS;

    fclose(pont_arq);
}

//-----------------------------------------------------------------------------OPÇÕES-----------------------------------------------------------------------------

//Função Opção 01
void cadastrar(){
    numero_cadastro++;
    pont_arq = fopen("cadastros.txt", "a");
    int i = 0;
    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("cadastros.txt", "w");
        fclose(pont_arq);
        return 1;
    }

    char cpf[TAM];
    int validacaocpf;
    bool validacpf = false;
    bool cpfexistente = false;
    bool telefonevalido = false;
    bool idadevalido = false;

    while(validacpf == false) {
        printf("Insira seu CPF: ");
        scanf(" %s", &cpf);

        validacaocpf = validacaoCPF(cpf);

        if (validacaocpf == 4) {
            for (i = 0; i < TAM; i++){
                if (strcmp(cpf, pessoa[i].cpf) == 0){
                    printf("CPF já consta no sistema.\n");
                    cpfexistente = true;
                }
            }
            if (cpfexistente == false){
                strcpy(pessoa[numero_cadastro].cpf, cpf);
                printf("CPF cadastrado com sucesso!\n");
                validacpf = true;
            } else {
                printf("Tente novamente!\n");
                return 0;
            }
        }
        else{
            printf("\nFormato de CPF invalido, digite novamente.\n");
            printf("Exemplo de formato válido: 000.000.000-00.\n");
        }
    }

    // VERIFICA NOME
    bool verificarNome = false;
    printf("\nInsira seu nome completo: ");

    while(!verificarNome) {
        scanf(" %[^\n]s", &pessoa[numero_cadastro].nome);
        verificarNome = verificarStr(pessoa[numero_cadastro].nome);
        if (verificarNome) {
            printf("Nome cadastrado com sucesso.\n");
        }
        else if (!verificarNome){
            printf("Nome inválido. Tente novamente: ");
        }
    }

    // VERIFICA ENDERECO
    printf("\nInsira seu endereço: ");
    scanf(" %[^\n]s", &pessoa[numero_cadastro].endereco);

    // VERIFICA TELEFONE
    printf("\nInsira seu telefone (ex: DDD+900000000): ");
    while(1) {
        scanf(" %[^\n]s", &pessoa[numero_cadastro].telefone);
        int lenTelefone = strlen(pessoa[numero_cadastro].telefone);
        telefonevalido = true;

        for (i = 0; i < strlen(pessoa[numero_cadastro].telefone); i++) {
            if (pessoa[numero_cadastro].telefone[i] >= '0' && pessoa[numero_cadastro].telefone[i] <= '9') {
            }
            else {
                telefonevalido = false;
            }
        }
        if (telefonevalido == false) {
            printf("Só é possivel digitar números. Tente novamente: \n");
            continue;
        }
        else if (lenTelefone != 11) {
            printf("Quantidade de dígitos inválida! Tente novamente: ");
            continue;
        }
        else if (telefonevalido == true) {
            printf("Telefone cadastrado com sucesso.\n");
            break;
        }
    }

    // VERIFICA IDADE
    printf("\nInsira sua idade: ");
    int idadeInt;

    while(1){
        idadeInt = verificaVariavel();

        if (idadeInt < 16 || idadeInt > 118) {
            printf("Idade inválida! Você precisa ter no mínimo 16 anos. Tente novamente: ");
            continue;
        }
        else {
            printf("Idade cadastrada com sucesso.\n");
            pessoa[numero_cadastro].idade = idadeInt;
            break;
        }
    }

    system("cls");
    printf(" -------------------\n"
           "| DADOS CADASTRAIS: |\n"
           " -------------------\n");

    printf("CPF: %s\n",pessoa[numero_cadastro].cpf);
    printf("NOME: %s\n",pessoa[numero_cadastro].nome);
    printf("ENDEREÇO: %s\n",pessoa[numero_cadastro].endereco);
    printf("TELEFONE: %s\n",pessoa[numero_cadastro].telefone);
    printf("IDADE: %d\n",pessoa[numero_cadastro].idade);

    printf("Cadastro efetuado com sucesso.\n");
    printf("Seu numero de cadastro é %d.\n",numero_cadastro);

    fprintf(pont_arq, "%d\n%s\n%s\n%s\n%s\n%d\n" , numero_cadastro, pessoa[numero_cadastro].cpf, pessoa[numero_cadastro].nome, pessoa[numero_cadastro].endereco, pessoa[numero_cadastro].telefone, pessoa[numero_cadastro].idade);
    fclose(pont_arq);
}

//Função 02
void cadastroContaCorrente() {

    char entradaCPF[TAM]; //Entrada do CPF
    int cpfValido = 0;
    bool continuarCadastro = false; //Serve para dar procedencia aos outros dois dados, caso o CPF seja encontrado na struct 1
    bool existeCPF = false;
    bool ccrepetida = false;

    //VALIDAR CPF
    while(continuarCadastro == false) {
        printf("Insira seu CPF: ");
        scanf(" %s", &entradaCPF);

        cpfValido = validacaoCPF(entradaCPF);

        if (cpfValido == 4) {
            for (int k = 0; k < TAM; k++){
                if (strcmp(entradaCPF, pessoa[k].cpf) == 0){
                    existeCPF = true;
                }
                if (strcmp(entradaCPF, contaCorrente[k].cpfCorrentista) == 0){
                    ccrepetida = true;
                }
            }

            if (existeCPF == true && ccrepetida == false){
                printf("O CPF consta no sistema e você pode continuar.\n");
                continuarCadastro = true;
            }
            else {
                printf("CPF não encontrado no sistema ou já cadastrada.\n");
                return 0;
            }
        }
        else{
            printf("\nFormato de CPF invalido, digite novamente.\n");
            printf("Exemplo de formato válido: 000.000.000-00.\n");
        }
    }

    // CASO O CPF ESTEJA VALIDADO
    if (continuarCadastro == true) {

        char entradaSaldo[TAM];

        while (true) {
            printf("Insira seu saldo inicial: R$ ");
            scanf(" %[^\n]s", &entradaSaldo);
            contaCorrente[numeroContaCorrente].saldoInicial = validacaoEntrada(entradaSaldo);

            if (contaCorrente[numeroContaCorrente].saldoInicial < 0)
                printf("Valor inválido!\n");
            if (contaCorrente[numeroContaCorrente].saldoInicial > 0)
                break;
        }

        pont_arq = fopen("contascorrentes.txt", "a");

        if (pont_arq == NULL){
            printf("Erro na abertura do arquivo!\n");
            return 1;
        }

        printf("\nCPF do correntista: [%s]\n", entradaCPF);
        printf("Saldo inicial do correntista: [%.2f]\n", contaCorrente[numeroContaCorrente].saldoInicial);

        // incrementa para passar para a prox conta corrente do arquivo
        conta++;

        contaCorrente[numeroContaCorrente].numeroContaCorrenteS = conta;

        printf("O número da sua conta é: [%d]\n", contaCorrente[numeroContaCorrente].numeroContaCorrenteS);

        fprintf(pont_arq,"%d\n", contaCorrente[numeroContaCorrente].numeroContaCorrenteS);
        fprintf(pont_arq,"%s\n", entradaCPF);
        fprintf(pont_arq,"%.2f\n", contaCorrente[numeroContaCorrente].saldoInicial);
        fclose(pont_arq);

        numeroContaCorrente++;
    }
}

//Função 03
void atendimento() {
    // Pega a hora do atendimento
    time_t now;
    struct tm * tm_now;

    char dataAtendimento[40];

    time_t data;
    data = time(NULL);
    struct tm tm = *localtime(&data);
    printf("Data do pedido de Atendimento: %d/%d/%d\n", tm.tm_mday, tm.tm_mon + 1, tm.tm_year + 1900);

    time(&now);
    tm_now = localtime(&now);
    strftime(horaAtendimento, sizeof(horaAtendimento), "%H:%M:%S", tm_now);

    printf("Hora do pedido de Atendimento: %s\n", horaAtendimento);

    // Comeca o atendimento
    int corrente, ret = 0;
    int idadeAtual;
    int tempoEspera;
    int contador = 1;

    bool continuarAtendimento;
    bool existeConta = false;
    char operacao;
    char cpfAtual[15];

    char entradaValor[50];
    float valor;

    printf("Informe o número da conta corrente: ");
    corrente = verificaVariavel();

    // Verifica se a CC ja existe na fila
    for (int l = 1; l <= tamFila; l++ ) {
        if (vetorUm[l].contaCorrente == corrente) {
            printf("\nVocê já está na fila e será atendido em breve.\n");
            return 0;
        }
    }

    pont_arq = fopen("contascorrentes.txt", "rt");

    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("contascorrentes.txt", "w");
        fclose(pont_arq);
        return 1;
    }

    while (fscanf(pont_arq, " %d\n %s\n %f", &contaCorrente[contador].numeroContaCorrenteS, &contaCorrente[contador].cpfCorrentista, &contaCorrente[contador].saldoInicial) != EOF) {
        if (contaCorrente[contador].numeroContaCorrenteS == corrente) {
            printf("\nSua conta existe no sistema. Continue para o atendimento.\n\n");
            existeConta = true;
            system("pause");
            system("cls");
        }
        contador++;
    }
    fclose(pont_arq);

    strcpy(cpfAtual, contaCorrente[corrente].cpfCorrentista);

    pont_arq = fopen("cadastros.txt", "rt");
    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("cadastros.txt", "w");
        fclose(pont_arq);
        return 1;
    }

    // Lê no arquivo e verifica se cpfAtual é igual a algum CPF já cadastrado
    while(true) {
        if (fscanf(pont_arq, " %d", &numero_cadastro) == EOF)
            break;
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].cpf);
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].nome);
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].endereco);
        fscanf(pont_arq, " %s", pessoa[numero_cadastro].telefone);
        fscanf(pont_arq, " %d", &pessoa[numero_cadastro].idade);
        // Percorre pelo CPF para pegar a idade referente
        if (strcmp(pessoa[numero_cadastro].cpf, cpfAtual) == 0) {
            printf("\nCPF encontrado em cadastro.\n\n");
            idadeAtual = pessoa[numero_cadastro].idade;
            break;
        }
    }

    fclose(pont_arq);

    if(existeConta == true) {
        continuarAtendimento = true;
    } else {
        printf("A conta corrente não existe.\n\n");
        return 0;
    }

    // Se a conta corrente existir no sistema entra no menu
    if (continuarAtendimento == true) {
        tamFila++;
        // Adiciona + 5 minutos no tempo de espera se > 60 anos
        if (idadeAtual >= 60) {
            tempoEspera = 5;
        } else {
            tempoEspera = 0;
        }

        printf("\nSaldo atual: R$%.2f\n", contaCorrente[corrente].saldoInicial);
        printf("\nDigite a letra conforme a operação que você deseja fazer: \n");
        printf("\t(D) para depósito \n");
        printf("\t(S) para saque    \n");
        printf("\t(P) para pagamento\n");

        while(1) {
            // Validação da entrada
            fflush(stdin);
            printf("\n\tEscolha sua opção: ");
            operacao = toupper(getchar());

            ret = validaChar(operacao);

            if (ret == 1)
                break;
        }

        while(true) {
            printf("Digite o valor da operação (Utilizar vírgula para valores decimais): R$ ");
            scanf(" %s", &entradaValor);
            valor = validacaoEntrada(entradaValor);

            if (valor <= 0)
                printf("Valor inválido!\n");
            if (valor > 0)
                break;
        }

        pont_arq = fopen("atendimento.txt", "a");

        if (pont_arq == NULL) {
            printf("Erro na abertura do arquivo!\n");
            return 1;
        }

        fprintf(pont_arq, "%d\n", corrente);
        fprintf(pont_arq, "%c\n", operacao);
        fprintf(pont_arq, "%.2f\n", valor);
        fclose(pont_arq);

        if (operacao == 'D') {
            operacaoLista = "DEPOSITO";
        }

        else if (operacao == 'S') {
            operacaoLista = "SAQUE";
        }

        else if (operacao == 'P') {
            operacaoLista = "PAGAMENTO";
        }

        // Insere o cliente atual na fila
        inserirElemento(&filaAtend, corrente, horaAtendimento, idadeAtual, tempoEspera, valor, operacaoLista);

        // Passa a fila para dentro de um vetor
        vetorUm = lerFila(filaAtend, atend);

        // Ordena a fila no vetor
        vetorUm = ordenarTempo(vetorUm, tamFila);

        int contadorTam = 0;

        // Apagando a fila
        while (filaAtend != NULL) {
            filaAtend->Prox;
            apagarFila(&filaAtend);
            contadorTam++;
        }


        // Insere os elementos ordenados
        for (int l = 1; l <= contadorTam; l++ ) {
            inserirElemento(&filaAtend, vetorUm[l].contaCorrente, vetorUm[l].hora, vetorUm[l].idade, vetorUm[l].tempoEspera, vetorUm[l].valor, vetorUm[l].operacao);
        }

    } else {
        printf("Cadastre uma conta corrente primeiro!\n");
    }
}

void chamarAtendimento() {
    printf("\nCORRENTISTAS NA FILA\n");
    listarFila(filaAtend);
    if (filaAtend == NULL) {
        printf("\nNão tem ninguém na fila no momento!\n\n");
        return;
    }

    vetorUm = lerFila(filaAtend, atend);

    pont_arq = fopen("contascorrentes.txt", "rt");

    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("contascorrentes.txt", "w");
        fclose(pont_arq);
        return 1;
    }

    // Lê no arquivo e verifica em qual posicao esta a primeira CC da fila
    int contadorSaldo = 1;
    while (fscanf(pont_arq, " %d\n %s\n %f", &contaCorrente[contadorSaldo].numeroContaCorrenteS, &contaCorrente[contadorSaldo].cpfCorrentista, &contaCorrente[contadorSaldo].saldoInicial) != EOF) {
        if (contaCorrente[contadorSaldo].numeroContaCorrenteS == vetorUm[1].contaCorrente) {
            break;
        }
        contadorSaldo++;
    }
    fclose(pont_arq);

    // Executando operações
    if (strcmp(vetorUm[1].operacao, "DEPOSITO") == 0) {
        contaCorrente[contadorSaldo].saldoInicial += vetorUm[1].valor;
        operacaoEfetuada = 1;
    }

    else if ((strcmp(vetorUm[1].operacao, "SAQUE") == 0) || (strcmp(vetorUm[1].operacao, "PAGAMENTO") == 0)) {
        if ((contaCorrente[contadorSaldo].saldoInicial - vetorUm[1].valor) < 0) {
            vetorUm[1].valor = contaCorrente[contadorSaldo].saldoInicial;
            operacaoEfetuada = 0;
        }
        else {
            contaCorrente[contadorSaldo].saldoInicial -= vetorUm[1].valor;
            operacaoEfetuada = 1;
        }
    }

    float saldoAtual = contaCorrente[contadorSaldo].saldoInicial;
    int ccAtual = contaCorrente[contadorSaldo].numeroContaCorrenteS;

    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("movimentacaoDiaria.txt", "w");
        fclose(pont_arq);
        return 1;
    }
    pont_arq = fopen("movimentacaoDiaria.txt", "a");

    char dateStr[9];

	_strdate( dateStr);

    fprintf(pont_arq, "Data: %s | ", dateStr);
    fprintf(pont_arq, "Hora: %s | ", horaAtendimento);
    fprintf(pont_arq, "Conta %d | ", ccAtual);
    fprintf(pont_arq, "Operação: %s | ", vetorUm[1].operacao);
    fprintf(pont_arq, "Valor: R$%.2f | ", vetorUm[1].valor);
    fprintf(pont_arq, "Status: %d\n", operacaoEfetuada);

    fclose(pont_arq);

    pont_arq = fopen("contascorrentes.txt", "rt");

    if (pont_arq == NULL) {
        printf("Arquivo não encontrado!\nCriando arquivo...\n");
        pont_arq = fopen("contascorrentes.txt", "w");
        fclose(pont_arq);
        return 1;
    }

    // Lê o arquivo novamente para atualizar o saldo da conta do cliente
    int contadorCC = 1;
    while (fscanf(pont_arq, " %d\n %s\n %f", &contaCorrente[contadorCC].numeroContaCorrenteS, &contaCorrente[contadorCC].cpfCorrentista, &contaCorrente[contadorCC].saldoInicial) != EOF) {
        contadorCC++;
    }
    fclose(pont_arq);

    // Abre o arquivo em modo W para reescrever o saldo atualizado no arquivo
    pont_arq = fopen("contascorrentes.txt", "w");

    contaCorrente[ccAtual].saldoInicial = saldoAtual;

    for (int c = 1; c < contadorCC; c++) {
        fprintf(pont_arq,"%d\n", contaCorrente[c].numeroContaCorrenteS);
        fprintf(pont_arq,"%s\n", contaCorrente[c].cpfCorrentista);
        fprintf(pont_arq,"%.2f\n", contaCorrente[c].saldoInicial);
    }

    fclose(pont_arq);

    int tamanhoDaFila = elementosDaFila;

    // Limpa a fila para receber a ordenacao
    while (filaAtend != NULL) {
        filaAtend->Prox;
        apagarFila(&filaAtend);
    }

    // Incrementa os tempos de espera
    for (int d = 1; d <= tamanhoDaFila; d++) {
        if (vetorUm[d].idade >= 60) {
            vetorUm[d].tempoEspera += 2;
        }
        else {
            vetorUm[d].tempoEspera++;
        }
    }

    // Insere os elementos ordenados
    for (int l = 1; l <= tamanhoDaFila; l++ ) {
        inserirElemento(&filaAtend, vetorUm[l].contaCorrente, vetorUm[l].hora, vetorUm[l].idade, vetorUm[l].tempoEspera, vetorUm[l].valor, vetorUm[l].operacao);
    }

    // Ordena a fila com os tempos incrementados
    vetorUm = ordenarTempo(vetorUm, elementosDaFila);

    // Tirando o primeiro da fila
    apagarFila(&filaAtend);

}

//Função opção 06
void movimentacaoDiaria(){
    pont_arq = fopen("movimentacaoDiaria.txt", "rt");
    char linha [500];
    while (fscanf(pont_arq," %[^\n]s",linha)!= EOF){
        printf("%s\n",linha);
    }
    fclose(pont_arq);
}