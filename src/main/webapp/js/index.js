$(document).ready(function () {
    $("#datos").validate({
        rules: {
            Xk: {
                required: true
            },
            P: {
                required: true
            },
            datosIngresados: {
                required: true
            }
        }
    });
});