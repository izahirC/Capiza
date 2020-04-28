function actualizarDatos(id) {
	var table = $('#tblProductos').DataTable();
	table.clear();
	table.draw();
	$.ajax({

		url : 'http://localhost:8081/productoPorBodego/' + id,
		dataType : 'json',
		success : function(json) {
			table.rows.add(json).draw();
			$(table.table().container()).removeClass('form-inline');
			$(table.table().container()).addClass('p-5');
			$("#tblProductos").removeClass();
			$("#tblProductos").addClass("table table-hover");
			$("#tblProductos tbody tr").each(function() {
				this.classList.add("table-primary")
			})
		}
	});
}
