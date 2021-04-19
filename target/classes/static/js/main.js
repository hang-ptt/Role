$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        //for update user
        if (text == 'Edit') {
            $.get(href, function (users, status) {
                $('.myFormUpdate #id').val(users.id);
                $('.myFormUpdate #name').val(users.name);
                $('.myFormUpdate #address').val(users.address);
                $('.myFormUpdate #email').val(users.email);
                $('.myFormUpdate #tel').val(users.tel);
                $('.myFormUpdate #avatar').attr("src",users.files);
            });
            $('.myFormUpdate #updateModal').modal();
        } else {
            //for creating user
            $('.myFormCreate #name').val('');
            $('.myFormCreate #address').val('');
            $('.myFormCreate #email').val('');
            $('.myFormCreate #files').val('');
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