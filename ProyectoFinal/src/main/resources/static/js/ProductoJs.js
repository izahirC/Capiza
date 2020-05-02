
function reporteCritico() {
	if ($.fn.DataTable.isDataTable("#table_id")) {
		  $('#table_id').DataTable().clear().destroy();
		}
	$.ajax({

				url : 'http://localhost:8081/reporteCriticos/',
				dataType : 'json',
				success : function(json) {
					var table = $('#table_id')
							.DataTable(
									{
										"data" : json,
										"columns" : [
												{
													"data" : "id",
													"title" : "ID"
												},
												{
													"data" : "miPaciente.cedula",
													"title" : "Cedula",

												},
												{
													"data" : "miPaciente.nombre",
													"title" : "Paciente"
												},
												{
													"data" : "miPaciente.apellido",
													"title" : "Paciente Apellido"
												},
												{
													"data" : "miPaciente.tipoSangre",
													"title" : "Tipo Sangre"
												},
												{
													"data" : "miPaciente.genero",
													"title" : "Genero"
												},
												{
													"data" : "miClinica.nombre",
													"title" : "Clinica"
												},
												{
													"data" : "miEnfermedad.nombre",
													"title" : "Enfermedad"
												},
												{
													"data" : "miEnfermedad.tipo",
													"title" : "Tipo Enfermedad"
												},
												{
													"data" : "miEnfermedad.medicamento",
													"title" : "Medicamento"
												} ],
										dom : 'Bfrtip',
										buttons : [
												{
													extend : 'copy',
													className : 'btn btn-info buttons-excel buttons-html5 excelButton'
												},
												{
													extend : 'excel',
													className : 'btn btn-info buttons-excel buttons-html5 excelButton'
												} ]

									});
					$(table.table().container()).removeClass('form-inline');
					$(table.table().container()).addClass('p-5');
					$("#table_id").removeClass();
					$("#table_id").addClass("table table-hover");
					$("#table_id tbody tr").each(function() {
						this.classList.add("table-primary")
					})
				}
			});
}

function reporteCerrado() {
	if ($.fn.DataTable.isDataTable("#table_id")) {
		  $('#table_id').DataTable().clear().destroy();
		}
	$.ajax({

				url : 'http://localhost:8081/reporteCerrados/',
				dataType : 'json',
				success : function(json) {
					var table = $('#table_id')
							.DataTable(
									{
										"data" : json,
										"columns" : [
												{
													"data" : "id",
													"title" : "ID"
												},
												{
													"data" : "miPaciente.cedula",
													"title" : "Cedula",

												},
												{
													"data" : "miPaciente.nombre",
													"title" : "Paciente"
												},
												{
													"data" : "miPaciente.apellido",
													"title" : "Paciente Apellido"
												},
												{
													"data" : "miPaciente.tipoSangre",
													"title" : "Tipo Sangre"
												},
												{
													"data" : "miPaciente.genero",
													"title" : "Genero"
												},
												{
													"data" : "miClinica.nombre",
													"title" : "Clinica"
												},
												{
													"data" : "miEnfermedad.nombre",
													"title" : "Enfermedad"
												},
												{
													"data" : "miEnfermedad.tipo",
													"title" : "Tipo Enfermedad"
												},
												{
													"data" : "miEnfermedad.medicamento",
													"title" : "Medicamento"
												} ],
										dom : 'Bfrtip',
										buttons : [
												{
													extend : 'copy',
													className : 'btn btn-info buttons-excel buttons-html5 excelButton'
												},
												{
													extend : 'excel',
													className : 'btn btn-info buttons-excel buttons-html5 excelButton'
												} ]

									});
					$(table.table().container()).removeClass('form-inline');
					$(table.table().container()).addClass('p-5');
					$("#table_id").removeClass();
					$("#table_id").addClass("table table-hover");
					$("#table_id tbody tr").each(function() {
						this.classList.add("table-primary")
					})
				}
			});
}

