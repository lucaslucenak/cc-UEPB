# Lê os arquivo e gera um dataframe "adresses"
adresses<-read.table("data/adresses.txt",sep=",",row.names=1,quote="")

# Gera vetores que vão armazenar os coneúdos das colunas especificadas pelo índice
nomes <- adresses[,0]
idades <- adresses[,1]
ruas <- adresses[,2]
ceps <- adresses[,3]

# Gera um novo dataframe para inserir os vetores criados anteriormente
# porém, com um cabeçalho agora
df <- data.frame(name=nomes, age=idades, street=ruas, cep=ceps)

# Ordenando o dataframe pela idade
df[order(df$age),]

# Salva o arquivo criado no diretório específicado
write.csv2(df, file='data/new-data.csv')
