$(document).ready(function(){
    $(".table .ebtn").on('click', function(event){

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(employee, status){
            $(".myForm #Id").val(employee.id);
            $(".myForm #name").val(employee.name);
            $(".myForm #email").val(employee.email);
            $(".myForm #address").val(employee.address);
            $(".myForm #minute").val(employee.minute);
            $(".myForm #amount").val(employee.amount);
        });

        $(".myForm #exampleModal").modal();

    });

    $(".addbtn").click(function() {
        $(".myForm #Id").val('');
        $(".myForm #name").val('');
        $(".myForm #email").val('');
        $(".myForm #address").val('');
        $(".myForm #minute").val(0);
        $(".myForm #amount").val(0);

        $(".myForm #exampleModal").modal();
    })

    $(".table .delbtn").on('click', function(event) {

           event.preventDefault();
           //delRef
           var href = $(this).attr('href');
           $("#deleteDialog #delRef").attr('href', href)
           $("#deleteDialog").modal();

    })

    $(".table .clockbtn").click(function() {

            event.preventDefault();
            var href = $(this).attr('href');

             $.get(href, function(employee, status){
                $(".myClockInForm #Id").val(employee.id);
                $(".myClockInForm #employeeName").text(employee.name);
                });
            $(".myClockInForm #clockInDialog").modal();
    })
})