# CONVERSOR DE DIVISAS

## ESTRUCTURA DEL PROYECTO
src -¬
     |--Principal
     |--ConversorCurrency
     |--Moneda (Record)
     |--MenuCurrency

##  EXPLICACION

El proyecto utiliza una API gratuita que nos permite colocar los pares de monedas y el monto que deseamos convertir en la URI
A traves de nuestra clase ConversorCurrenc obtenemos la respuesta del endpoint y usamos el record Moneda para obtener los rates 
de conversion de las monedas que luego aplicaremos en la clase Principal junto con la clase de MenuCurrency que sirve para visualizar
los simbolos de las monedas y su nombre.
