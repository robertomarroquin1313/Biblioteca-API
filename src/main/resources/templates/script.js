// Cuando el documento esté listo
$(document).ready(function () {
    // Manejar clic en el botón "Agregar Libro"
    $("#agregarLibro").click(function () {
        mostrarFormularioCreacionEdicion({});
    });

    // Cargar y mostrar la lista de libros
    cargarListaLibros();

    // Función para cargar y mostrar la lista de libros
    function cargarListaLibros() {
        // Realizar una solicitud GET a la API para obtener la lista de libros
        $.get("/api/libros/obtener", function (data) {
            // Limpiar la tabla
            $("#tablaLibros").empty();

            // Iterar a través de los libros y agregarlos a la tabla
            data.forEach(function (libro) {
                var row = `<tr>
                    <td>${libro.name}</td>
                    <td>${libro.price}</td>
                    <td>${libro.autor.name}</td>
                    <td>${libro.categoria.name}</td>
                    <td>${libro.estatus}</td>
                    <td>
                        <button class="btn btn-sm btn-primary editarLibro" data-id="${libro.idBook}">Editar</button>
                        <button class="btn btn-sm btn-danger eliminarLibro" data-id="${libro.idBook}">Desactivar</button>
                    </td>
                </tr>`;
                $("#tablaLibros").append(row);
            });

            // Manejar clic en el botón "Editar"
            $(".editarLibro").click(function () {
                var libroId = $(this).data("id");
                // Realizar una solicitud GET a la API para obtener los detalles del libro
                $.get(`/api/libros/mod/{id}`, function (libro) {
                    mostrarFormularioCreacionEdicion(libro);
                });
            });

            // Manejar clic en el botón "Desactivar"
            $(".eliminarLibro").click(function () {
                var libroId = $(this).data("id");
                // Realizar una solicitud DELETE a la API para desactivar el libro
                $.ajax({
                    url: `/api/libros/eliminar/{id}`,
                    type: "DELETE",
                    success: function () {
                        // Recargar la lista de libros después de eliminar uno
                        cargarListaLibros();
                    }
                });
            });
        });
    }

    // Función para mostrar el formulario de creación/edición de libros en un modal
    function mostrarFormularioCreacionEdicion(libro) {
        // Generar el formulario HTML con los campos y valores del libro
        var formularioHtml = `
            <div class="modal-header">
                <h5 class="modal-title">${libro.idBook ? 'Editar Libro' : 'Agregar Libro'}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="formularioLibro">
                    <div class="form-group">
                        <label for="nombre">Nombre del Libro</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="${libro.name || ''}" required>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" id="precio" name="precio" value="${libro.price || ''}" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="autor">Autor</label>
                        <select class="form-control" id="autor" name="autor">
                            <!-- Aquí se cargarán los autores desde JavaScript -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="categoria">Categoría</label>
                        <select class="form-control" id="categoria" name="categoria">
                            <!-- Aquí se cargarán las categorías desde JavaScript -->
                        </select>
                    </div>
                    <div class="form-group">
                         <label for="estatus">Estado</label>
                         <input type="text" class="form-control" id="estatus" name="estatus" value="${libro.estatus || ''}" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" id="guardarLibro">Guardar</button>
            </div>
        `;

        // Agregar el formulario al modal
        $("#libroModal .modal-content").html(formularioHtml);

        // Obtener y cargar la lista de autores desde la API
        $.get("/api/autores/obtener", function (autores) {
            var autorSelect = $("#autor");
            autorSelect.empty();
            autores.forEach(function (autor) {
                var option = `<option value="${autor.idAuthor}">${autor.name}</option>`;
                autorSelect.append(option);
            });
            // Establecer el autor seleccionado en el formulario
            if (libro.autor) {
                autorSelect.val(libro.autor.idAuthor);
            }
        });

        // Obtener y cargar la lista de categorías desde la API
        $.get("/api/categorias/obtener", function (categorias) {
            var categoriaSelect = $("#categoria");
            categoriaSelect.empty();
            categorias.forEach(function (categoria) {
                var option = `<option value="${categoria.idCategory}">${categoria.name}</option>`;
                categoriaSelect.append(option);
            });
            // Establecer la categoría seleccionada en el formulario
            if (libro.categoria) {
                categoriaSelect.val(libro.categoria.idCategory);
            }
        });

        // Manejar clic en el botón "Guardar"
        $("#guardarLibro").click(function () {
            // Obtener los valores del formulario
            var nombre = $("#nombre").val();
            var precio = parseFloat($("#precio").val());
            var autorId = $("#autor").val();
            var categoriaId = $("#categoria").val();
            var estatus = $("#estatus").val();

            // Crear un objeto con los datos del libro
            var libroData = {
                name: nombre,
                price: precio,
                autor: { idAuthor: autorId },
                categoria: { idCategory: categoriaId },
                estatus: estatus
            };

            // Determinar si se está creando o editando un libro
            if (libro.idBook) {
                // Edición: Realizar una solicitud PUT a la API
                $.ajax({
                    url: `/api/libros/mod/{id}`,
                    type: "PUT",
                    contentType: "application/json",
                    data: JSON.stringify(libroData),
                    success: function () {
                        // Cerrar el modal y recargar la lista de libros
                        $("#libroModal").modal("hide");
                        cargarListaLibros();
                    }
                });
            } else {
                // Creación: Realizar una solicitud POST a la API
                $.post("/api/libros/crear", libroData, function () {
                    // Cerrar el modal y recargar la lista de libros
                    $("#libroModal").modal("hide");
                    cargarListaLibros();
                });
            }
        });

        // Mostrar el modal
        $("#libroModal").modal("show");
    }
});
