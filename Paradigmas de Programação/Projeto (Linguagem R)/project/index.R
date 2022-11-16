# Lê os arquivo e gera um dataframe "adresses"
adresses<-read.table("data/adresses.txt",sep=",",row.names=1,quote="")
name <- adresses[,0]
age <- adresses[,1]
street <- adresses[,2]
cep <- adresses[,3]

df <- data.frame(name, age, street, cep)
write.csv2(df, file='data/new-data.csv')
