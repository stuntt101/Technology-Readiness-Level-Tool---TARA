$(function () {
    // when the modal is closed
    $('#viewSpecificationModal').on('hidden.bs.modal', function () {
        // remove the bs.modal data attribute from it
        $(this).removeData('bs.modal');
        // and empty the modal-content element
        $('#viewSpecificationModal .tableBody').empty();
    });
});