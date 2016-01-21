$(function(){
	// create
	$('.open-modal-create').on('click', function(){
		$('#btn-create').html('<i class="fa fa-plus"></i>&nbsp;Create');
		$('#modal-create-title').html('<i class="fa fa-plus"></i>&nbsp;Create');
		
	});
	
	// update
	$('.open-modal-update').on('click', function(){
		var id = $(this).closest('tr').children('td.table-id').text();
		var firstName = $(this).closest('tr').children('td.table-firstName').text();
		var lastName = $(this).closest('tr').children('td.table-lastName').text();
		
		$("#student-id").val(id);
		$("#student-firstName").val(firstName);
		$("#student-lastName").val(lastName);
		
		$('#btn-create').html('<i class="fa fa-edit"></i>&nbsp;Update');
		$('#modal-create-title').html('<i class="fa fa-edit"></i>&nbsp;Update');
		
	});

	// delete
	$('.open-modal-delete').on('click', function(){
		var id = $(this).closest('tr').children('td.table-id').text();
		var firstName = $(this).closest('tr').children('td.table-firstName').text();
		var lastName = $(this).closest('tr').children('td.table-lastName').text();
		
		$("#delete-id").val(id);
		$("#delete-firstName").text(firstName);
		$("#delete-lastName").text(lastName);
		
	});
	
	$('#modal-create').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end();
	});
	
});