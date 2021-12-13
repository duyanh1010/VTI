$(function() {
    var isRememberMe = storage.getRemember();
    document.getElementById("rememberMe").checked = isRememberMe;

    $(".form-resend").hide();

});

function login() {
    //lay username password
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    //validate
    // kiem tra do dai
    if (!username) {
        message = "Bạn chưa nhập username";
        showNameErrorMessage(message);
        return;
    }
    if (!password) {
        message = "Bạn chưa nhập password";
        showNameErrorMessage(message);
        return;
    }

    if (password.length < 6 || password.length > 50 || username.length < 6 || username.length > 50) {
        // show error
        message = "Đăng nhập không thành công";
        showNameErrorMessage();
        return;
    }

    //call API
    $.ajax({
        url: 'http://localhost:8080/api/v1/login/',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
        },
        success: function(data) {
            //
            if (data.status == "NOT_ACTIVE") {
                alert("Bạn cần active tài khoản trước khi đăng nhập!");
                return false;
            }

            var isRememberMe = document.getElementById("rememberMe").checked;
            storage.saveRemember(isRememberMe);

            console.log(data);
            storage.setItem("ID", data.id);
            storage.setItem("FULL_NAME", data.fullName);
            storage.setItem("USERNAME", username);
            storage.setItem("PASSWORD", password);
            storage.setItem("ROLE", data.role);

            window.location.replace("QLNV_AJAX.html");
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                message = "Đăng nhập không thành công";
                showNameErrorMessage();
                return;
            } else {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });

    function showNameErrorMessage() {
        document.getElementById("nameErrorMessage").style.display = "block";
        document.getElementById("nameErrorMessage").innerHTML = message;
    }

    function hideNameErrorMessage() {
        document.getElementById("nameErrorMessage").style.display = "none";
    }
}

function logout() {
    // document.getElementById("username").innerHTML = storage.getItem("USERNAME");
    // document.getElementById("password").innerHTML = storage.getItem("PASSWORD");

    storage.removeItem("ID");
    storage.removeItem("FULL_NAME");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");
    storage.removeItem("ROLE");

    window.location.replace("login.html");
}

$("#password").keyup(function(event) {
    if (event.keyCode === 13) {
        $("#myButton").click();
    }
});
$("#rememberMe").keyup(function(event) {
    if (event.keyCode === 13) {
        $("#myButton").click();
    }
});

function ResentEmailActive() {
    $(".form-resend").toggle();
}