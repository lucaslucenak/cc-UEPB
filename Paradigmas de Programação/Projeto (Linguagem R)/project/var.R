# df <- data.frame (
#   name = c("Lucas", "Daniel", "Richarlison"),
#   idade = c(21, 21, 25),
#   ehBom = c(FALSE, FALSE, TRUE)
# )
#
# df
#
idadeDaniel <- 22
idadeLucas <- 21

if (idadeDaniel > idadeLucas) {
  cat("Daniel é mais velho que Lucas.")
} else if (idadeDaniel < idadeLucas) {
  cat("Lucas é mais velho que Daniel.")
} else {
  cat("Daniel e Lucas tem a mesma idade.")
}