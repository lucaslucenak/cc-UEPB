rm(list=ls())  # Remove todas as variáveis que possam ter sido armazenadas anteriormente

data <- read.csv("data/2019_nCoV_data.csv")  # Carrega o dataset

sprintf("Média de mortes por Província/Estado: %.2f", mean(data$Deaths))

# Alto, portanto os casos de óbito não são bem distribuídos entre os estados
sprintf("Desvio padrão das mortes por Província/Estado: %.2f", sd(data$Deaths))

# Cria novos dataframes a partir de um dataframe base e de um parâmetro de referência
china <- subset(data, Country == "China")
us <- subset(data, Country == "US")

# Criar um novo dataframe, porém mais resumido
pais <- c("China", "US")
casos_confirmados <- c(sum(china$Confirmed), sum(us$Confirmed))
obitos <- c(sum(china$Deaths), sum(us$Deaths))
recuperacoes <- c(sum(china$Recovered), sum(us$Recovered))
media_mortes <- c(mean(china$Deaths), mean(us$Deaths))
qtd_estados <- c(nrow(china), nrow(us))

resumedData <- data.frame(Pais = pais,
                      CasosConfirmados = casos_confirmados,
                      Obitos = obitos,
                      Recuperacoes = recuperacoes,
                      MediaMortes = media_mortes,
                      QtdEstados = qtd_estados)
resumedData
