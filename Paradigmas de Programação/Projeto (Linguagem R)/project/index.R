# Lê os arquivo e gera um dataframe "adresses"
adresses<-read.table("data/adresses.txt",sep=",",row.names=1,quote="")

# Gera vetores que vão armazenar os coneúdos das colunas especificadas pelo índice
name <- adresses[,0]
age <- adresses[,1]
street <- adresses[,2]
cep <- adresses[,3]

# Gera um novo dataframe para inserir os vetores criados anteriormente
# porém, com um cabeçalho agora
df <- data.frame(name, age, street, cep)

# Salva o arquivo criado no diretório específicado
write.csv2(df, file='data/new-data.csv')
