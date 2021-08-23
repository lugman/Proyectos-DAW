Aplicación móvil
----

Esta aplicación se podría considerar como una ayuda hacia los usuarios que disponen de un
dispositivo móvil con el sistema operativo Android, para poder visualizar los anuncios , así
como crearse su selección de estos para visualizarlos más tarde.
Esta aplicación cuenta con cuatro pantallas las cuales serán:
1. Pantalla principal.
2. Pantalla de búsqueda.
3. Pantalla del anuncio.
4. Pantalla de mi selección.

### 1. Pantalla principal. ### 
Esta aplicación cuando el usuario la inicia este accede a la
pantalla principal, en la cual podrá buscar un anuncio
seleccionando uno de los iconos los cuales se corresponde con las
categorías de su nombre, así como también podrá buscar por una
categoría, ciudad y palabras, combinándolos de la forma que el
usuario prefiera.
También podrá acceder a mi selección.


### 2. Pantalla búsqueda. ###  

En esta pantalla el usuario podrá visualizar los anuncios con los
criterios seleccionados en la pantalla principal.
También podría añadir o quitara anuncios de la pestaña de mi
selección, seleccionando la casilla de arriba a la izquierda.
Forma de realizarlo:
Aquí lo que se ha hecho uso es de la clase AsyncTask, la cual se
ejecuta con los parámetros que se han seleccionado en la
pantalla de inicio y realizaría una petición mediante el uso de
otra clase la cual sería HttpURLConnection lo buscaría, y luego
para mostrar las imágenes se ha utilizado la librería Picasso con
lo que se ha conseguido cargar las imágenes externas.
Re-ofertas. Si seleccionamos un anuncio podemos acceder a su información completa.
### 3 Pantalla anuncio. ### 
Esta pantalla mostraría el resto de información del anuncio, así como la información de
contacto del usuario vendedor. Desde esta ventana también podría añadir a su lista de
anuncios, así como quitarlo de su selección mediante la casilla de arriba a la derecha.
### 4. Pantalla mi selección. ### 
Desde esta pantalla el usuario, podrá ver los anuncios
que el haya decidido añadir para poder visualizarlos más
tarde en esta sección, desde esta sección también podrá
borrar la lista de forma que le aparecerá vacía.
Como se puede apreciar en la imagen esta pestaña seria
como la de búsqueda, pero con la opción de vaciar esta
lista. Y con los anuncios que el haya decidido

***Imagenes***
---
<p align="center">
  <img src="https://github.com/lugman/Proyectos-DAW/blob/main/Aplicacion-movil-proyecto-final-daw/principal.png"width="200px">
   <img src="https://github.com/lugman/Proyectos-DAW/blob/main/Aplicacion-movil-proyecto-final-daw/busqueda-movil.png" width="200px">
</p>
<p align="center">
 
   <img src="https://github.com/lugman/Proyectos-DAW/blob/main/Aplicacion-movil-proyecto-final-daw/detalles.png" width="500px">
</p>
