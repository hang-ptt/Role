$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        //for update user
        if (text == 'Edit') {
            $.get(href, function (sub, status) {
                $('.myFormUpdate #id').val(sub.id);
                $('.myFormUpdate #description').val(sub.description);
                $('.myFormUpdate #createdBy').val(sub.createdBy);
                $('.myFormUpdate #status').val(sub.status);
            });
            $('.myFormUpdate #updateModal').modal();
        } else {
            //for creating user
            $('.myFormCreate #description').val('');
            $('.myFormCreate #createdBy').val('');
            $('.myFormCreate #status').val('');
            $('.myFormCreate #myModalCreate').modal();
        }
    });
    //for delete user
    $('.table .delBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#removeModalCenter #delRef').attr('href', href);
        $('#removeModalCenter').modal();
    });
    $('#table_id').DataTable();
});