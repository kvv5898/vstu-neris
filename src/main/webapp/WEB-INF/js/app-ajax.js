// вызов функции по завершению загрузки страницы
$(document).ready(function() {
    // вызов функции после потери полем 'userName' фокуса
    $('#idEquipment').blur(function() {
        $.ajax({
            url : 'InsertEquipment',     // URL - сервлет
            data : {                 // передаваемые сервлету данные
                userName : $('#idEquipment').val()
            },
            success : function(response) {
                                     // обработка ответа от сервера
                $('#ajaxIdServletResponse').text(response);
            }
        });
    });
});